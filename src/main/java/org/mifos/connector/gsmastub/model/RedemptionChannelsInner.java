package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * RedemptionChannelsInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class RedemptionChannelsInner {

    @JsonProperty("channelType")
    private String channelType = null;

    public RedemptionChannelsInner channelType(String channelType) {
        this.channelType = channelType;
        return this;
    }

    /**
     * Identifies the channel type.
     *
     * @return channelType
     **/
    @Schema(required = true, description = "Identifies the channel type.")
    @NotNull

    @Size(min = 1, max = 256)
    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RedemptionChannelsInner redemptionChannelsInner = (RedemptionChannelsInner) o;
        return Objects.equals(this.channelType, redemptionChannelsInner.channelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RedemptionChannelsInner {\n");

        sb.append("    channelType: ").append(toIndentedString(channelType)).append("\n");
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
