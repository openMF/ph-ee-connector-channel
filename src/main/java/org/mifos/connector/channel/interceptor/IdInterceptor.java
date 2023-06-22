package org.mifos.connector.channel.interceptor;

import static org.mifos.connector.channel.camel.config.CamelProperties.CLIENTCORRELATIONID;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.mifos.connector.channel.camel.routes.ChannelRouteBuilder;
import org.mifos.connector.common.channel.dto.PhErrorDTO;
import org.mifos.connector.common.exception.PaymentHubError;
import org.mifos.connector.common.exception.PaymentHubErrorCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Primary
public class IdInterceptor implements HandlerInterceptor {

    @Autowired
    ChannelRouteBuilder channelRouteBuilder;

    @Value("${redis.idempotency.enabled}")
    Boolean redisIdempotencyEnabled;

    @Value("${redis.idempotency.apiList}.split(',')")
    private Set<String> apiList;

    @Value("${redis.idempotency.keyFormat}")
    String keyFormat;

    @Value("${redis.cacheRetencyDuration}")
    long cacheRetencyDuration;

    @Autowired
    public RedisTemplate<String, String> redisTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());;

    void IdInterceptor(Set<String> apiList) {
        this.apiList = apiList;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (redisIdempotencyEnabled) {
            if (apiList.contains(request.getRequestURI())) {
                logger.debug("redis idempotency is enabled for this api,checking for idempotency");
                return checkIdempotency(request, response);
            } else {
                logger.debug("redis idempotency is disabled for this api,proceeding with request");
            }
            return true;
        } else {
            logger.debug("redis idempotency is disabled,proceeding with request");
        }
        return true;
    }

    private boolean checkIdempotency(HttpServletRequest request, HttpServletResponse response) {
        PhErrorDTO errorDTO = null;
        String correlationId = request.getHeader(CLIENTCORRELATIONID);
        if (correlationId.isBlank()) {
            logger.debug("X-CorrelationID is missing,attaching error dto to response");
            errorDTO = new PhErrorDTO.PhErrorDTOBuilder(PaymentHubError.MandatoryValueNotSupplied)
                    .addErrorParameter(CLIENTCORRELATIONID, "X-CorrelationID")
                    .developerMessage("Pass the valid header value for " + CLIENTCORRELATIONID).build();
            createError(response, errorDTO);
            return false;
        }
        String key = createRedisKey(request.getHeader("Platform-TenantId"), correlationId, request.getRequestURI(), keyFormat);
        logger.debug("X-CorrelationID value is {}", correlationId);
        if (Boolean.TRUE.equals(redisTemplate.hasKey(key))) {
            logger.debug("X-CorrelationID exists already in redis,attaching error dto to response");
            errorDTO = new PhErrorDTO.PhErrorDTOBuilder(PaymentHubError.TransactionExistsError)
                    .addErrorParameter(CLIENTCORRELATIONID, correlationId)
                    .developerMessage("Pass the valid header value for " + CLIENTCORRELATIONID).build();
            createError(response, errorDTO);
            response.setHeader(CLIENTCORRELATIONID, correlationId);
            return false;
        } else {
            logger.debug("X-CorrelationID does not exist in redis,proceeding with request");
            redisTemplate.opsForValue().set(key, correlationId, cacheRetencyDuration, TimeUnit.DAYS);
            return true;
        }

    }

    private String createRedisKey(String tenant, String correlationId, String requestURI, String keyFormat) {
        if (keyFormat.isBlank()) {
            logger.info("redis key format is empty,using default key format as {tenant}{clientCorrelationId}");
            keyFormat = tenant + correlationId;
        } else if (!keyFormat.isBlank()) {
            List<String> keyFormatList = Arrays.asList(keyFormat.split("_"));
            String outputString = "";
            for (String keyFormatStr : keyFormatList) {
                if (keyFormatStr.equals("tenant") && StringUtils.isNotBlank(tenant)) {
                    outputString = outputString + tenant + "_";
                } else if (keyFormatStr.equals("clientCorrelationId") && StringUtils.isNotBlank(correlationId)) {
                    outputString = outputString + correlationId + "_";
                } else if (keyFormatStr.equals("api") && StringUtils.isNotBlank(requestURI)) {
                    outputString = outputString + requestURI + "_";
                }
                keyFormat = StringUtils.chop(outputString);
            }
        } else {
            throw new RuntimeException(String.format("Invalid key format %s", keyFormat));
        }

        logger.debug("redis key is {}", keyFormat);
        return keyFormat;
    }

    public void createError(HttpServletResponse response, PhErrorDTO errorDTO) {
        if (errorDTO.getErrorCategory().equals(PaymentHubErrorCategory.System.name())) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        try {
            response.getWriter().write(getObjectMapper().writeValueAsString(errorDTO));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setVisibilityChecker(objectMapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY).withGetterVisibility(JsonAutoDetect.Visibility.NONE));
        return objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

}
