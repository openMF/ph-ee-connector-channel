package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

/**
 * ResponseHeartbeat
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class ResponseHeartbeat {

    @JsonProperty("serviceStatus")
    private ServiceStatus serviceStatus = null;

    @JsonProperty("delay")
    private BigDecimal delay = null;

    @JsonProperty("plannedRestorationTime")
    private OffsetDateTime plannedRestorationTime = null;

    public ResponseHeartbeat serviceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
        return this;
    }

    /**
     * Get serviceStatus
     *
     * @return serviceStatus
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public ResponseHeartbeat delay(BigDecimal delay) {
        this.delay = delay;
        return this;
    }

    /**
     * The anticipated processing delay in milliseconds.
     *
     * @return delay
     **/
    @Schema(description = "The anticipated processing delay in milliseconds.")

    @Valid
    public BigDecimal getDelay() {
        return delay;
    }

    public void setDelay(BigDecimal delay) {
        this.delay = delay;
    }

    public ResponseHeartbeat plannedRestorationTime(OffsetDateTime plannedRestorationTime) {
        this.plannedRestorationTime = plannedRestorationTime;
        return this;
    }

    /**
     * Where the planned restoration time is known (e.g. scheduled maintenance), it can be provided in this field.
     *
     * @return plannedRestorationTime
     **/
    @Schema(description = "Where the planned restoration time is known (e.g. scheduled maintenance), it can be provided in this field.")

    @Valid
    public OffsetDateTime getPlannedRestorationTime() {
        return plannedRestorationTime;
    }

    public void setPlannedRestorationTime(OffsetDateTime plannedRestorationTime) {
        this.plannedRestorationTime = plannedRestorationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseHeartbeat responseHeartbeat = (ResponseHeartbeat) o;
        return Objects.equals(this.serviceStatus, responseHeartbeat.serviceStatus) && Objects.equals(this.delay, responseHeartbeat.delay)
                && Objects.equals(this.plannedRestorationTime, responseHeartbeat.plannedRestorationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceStatus, delay, plannedRestorationTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseHeartbeat {\n");

        sb.append("    serviceStatus: ").append(toIndentedString(serviceStatus)).append("\n");
        sb.append("    delay: ").append(toIndentedString(delay)).append("\n");
        sb.append("    plannedRestorationTime: ").append(toIndentedString(plannedRestorationTime)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
