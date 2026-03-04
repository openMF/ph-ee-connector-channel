package org.mifos.connector.channel.interceptor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
@Primary
public class WebMvcConfig extends WebMvcConfigurationSupport implements WebMvc {

    @Autowired
    HandlerInterceptor idInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(idInterceptor);
        super.addInterceptors(registry);
    }
}
