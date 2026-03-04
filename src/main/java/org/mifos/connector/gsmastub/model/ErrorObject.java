package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * ErrorObject
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class ErrorObject   {
  /**
   * The category grouping for the error.
   */
  public enum ErrorCategoryEnum {
    BUSINESSRULE("businessRule"),
    
    VALIDATION("validation"),
    
    AUTHORISATION("authorisation"),
    
    IDENTIFICATION("identification"),
    
    INTERNAL("internal"),
    
    SERVICEUNAVAILABLE("serviceUnavailable");

    private String value;

    ErrorCategoryEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ErrorCategoryEnum fromValue(String text) {
      for (ErrorCategoryEnum b : ErrorCategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("errorCategory")
  private ErrorCategoryEnum errorCategory = null;

  /**
   * The harmonised error code identifying the reason for error.
   */
  public enum ErrorCodeEnum {
    GENERICERROR("genericError"),
    
    DAILYVOLUMELIMITEXCEEDED("dailyVolumeLimitExceeded"),
    
    DAILYVALUELIMITEXCEEDED("dailyValueLimitExceeded"),
    
    WEEKLYVOLUMELIMITEXCEEDED("weeklyVolumeLimitExceeded"),
    
    WEEKLYVALUELIMITEXCEEDED("weeklyValueLimitExceeded"),
    
    MONTHLYVOLUMELIMITEXCEEDED("monthlyVolumeLimitExceeded"),
    
    MONTHLYVALUELIMITEXCEEDED("monthlyValueLimitExceeded"),
    
    ACCOUNTMAXTOTALVOLUMEEXCEEDED("accountMaxTotalVolumeExceeded"),
    
    ACCOUNTMAXTOTALVALUEEXCEEDED("accountMaxTotalValueExceeded"),
    
    LESSTHANTRANSACTIONMINVALUE("lessThanTransactionMinValue"),
    
    GREATERTHANTRANSACTIONMAXVALUE("greaterThanTransactionMaxValue"),
    
    MAXBALANCEEXCEEDED("maxBalanceExceeded"),
    
    SAMEPARTIESERROR("samePartiesError"),
    
    DUPLICATEREQUEST("duplicateRequest"),
    
    INSUFFICIENTFUNDS("insufficientFunds"),
    
    INCORRECTSTATE("incorrectState"),
    
    UNDERPAYMENTNOTALLOWED("underPaymentNotAllowed"),
    
    OVERPAYMENTNOTALLOWED("overPaymentNotAllowed"),
    
    RATELIMITERROR("rateLimitError"),
    
    TRANSACTIONTYPEERROR("transactionTypeError"),
    
    NOMANDATEAUTHORITY("noMandateAuthority"),
    
    LINKVIOLATION("linkViolation"),
    
    COUNTRYOFORIGINNOTPERMITTED("countryofOriginNotPermitted"),
    
    NATIONALITYNOTPERMITTED("nationalityNotPermitted"),
    
    IDDOCUMENTNOTSUPPORTED("idDocumentNotSupported"),
    
    ISSUINGCOUNTRYNOTSUPPORTED("issuingCountryNotSupported"),
    
    QUOTEHASEXPIRED("quoteHasExpired"),
    
    IDENTIFIERERROR("identifierError"),
    
    LENGTHERROR("lengthError"),
    
    FORMATERROR("formatError"),
    
    NEGATIVEVALUE("negativeValue"),
    
    CURRENCYNOTSUPPORTED("currencyNotSupported"),
    
    MANDATORYVALUENOTSUPPLIED("mandatoryValueNotSupplied"),
    
    INVALIDOFFSET("invalidOffset"),
    
    CLIENTAUTHORISATIONERROR("clientAuthorisationError"),
    
    REQUESTDECLINED("requestDeclined"),
    
    SERVICINGPARTYAUTHORISATIONERROR("servicingPartyAuthorisationError"),
    
    REQUESTINGPARTYAUTHORISATIONERROR("requestingPartyAuthorisationError");

    private String value;

    ErrorCodeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ErrorCodeEnum fromValue(String text) {
      for (ErrorCodeEnum b : ErrorCodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("errorCode")
  private ErrorCodeEnum errorCode = null;

  @JsonProperty("errordescription")
  private String errordescription = null;

  @JsonProperty("errorDateTime")
  private OffsetDateTime errorDateTime = null;

  @JsonProperty("errorParameters")
  private MetadataArray errorParameters = null;

  public ErrorObject errorCategory(ErrorCategoryEnum errorCategory) {
    this.errorCategory = errorCategory;
    return this;
  }

  /**
   * The category grouping for the error.
   * @return errorCategory
   **/
  @Schema(required = true, description = "The category grouping for the error.")
      @NotNull

    public ErrorCategoryEnum getErrorCategory() {
    return errorCategory;
  }

  public void setErrorCategory(ErrorCategoryEnum errorCategory) {
    this.errorCategory = errorCategory;
  }

  public ErrorObject errorCode(ErrorCodeEnum errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * The harmonised error code identifying the reason for error.
   * @return errorCode
   **/
  @Schema(required = true, description = "The harmonised error code identifying the reason for error.")
      @NotNull

    public ErrorCodeEnum getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(ErrorCodeEnum errorCode) {
    this.errorCode = errorCode;
  }

  public ErrorObject errordescription(String errordescription) {
    this.errordescription = errordescription;
    return this;
  }

  /**
   * A textual description of the error.
   * @return errordescription
   **/
  @Schema(description = "A textual description of the error.")
  
  @Size(max=256)   public String getErrordescription() {
    return errordescription;
  }

  public void setErrordescription(String errordescription) {
    this.errordescription = errordescription;
  }

  public ErrorObject errorDateTime(OffsetDateTime errorDateTime) {
    this.errorDateTime = errorDateTime;
    return this;
  }

  /**
   * The timestamp indicating when the error occurred.
   * @return errorDateTime
   **/
  @Schema(description = "The timestamp indicating when the error occurred.")
  
    @Valid
    public OffsetDateTime getErrorDateTime() {
    return errorDateTime;
  }

  public void setErrorDateTime(OffsetDateTime errorDateTime) {
    this.errorDateTime = errorDateTime;
  }

  public ErrorObject errorParameters(MetadataArray errorParameters) {
    this.errorParameters = errorParameters;
    return this;
  }

  /**
   * Get errorParameters
   * @return errorParameters
   **/
  @Schema(description = "")
  
    @Valid
    public MetadataArray getErrorParameters() {
    return errorParameters;
  }

  public void setErrorParameters(MetadataArray errorParameters) {
    this.errorParameters = errorParameters;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorObject errorObject = (ErrorObject) o;
    return Objects.equals(this.errorCategory, errorObject.errorCategory) &&
        Objects.equals(this.errorCode, errorObject.errorCode) &&
        Objects.equals(this.errordescription, errorObject.errordescription) &&
        Objects.equals(this.errorDateTime, errorObject.errorDateTime) &&
        Objects.equals(this.errorParameters, errorObject.errorParameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCategory, errorCode, errordescription, errorDateTime, errorParameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorObject {\n");
    
    sb.append("    errorCategory: ").append(toIndentedString(errorCategory)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    errordescription: ").append(toIndentedString(errordescription)).append("\n");
    sb.append("    errorDateTime: ").append(toIndentedString(errorDateTime)).append("\n");
    sb.append("    errorParameters: ").append(toIndentedString(errorParameters)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
