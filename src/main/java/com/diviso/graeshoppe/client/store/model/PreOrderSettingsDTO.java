package com.diviso.graeshoppe.client.store.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * PreOrderSettingsDTO
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-30T14:09:05.929+05:30[Asia/Kolkata]")

public class PreOrderSettingsDTO   {
  @JsonProperty("fromTime")
  private OffsetDateTime fromTime = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("isPreOrderAvailable")
  private Boolean isPreOrderAvailable = null;

  @JsonProperty("toTime")
  private OffsetDateTime toTime = null;

  public PreOrderSettingsDTO fromTime(OffsetDateTime fromTime) {
    this.fromTime = fromTime;
    return this;
  }

  /**
   * Get fromTime
   * @return fromTime
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getFromTime() {
    return fromTime;
  }

  public void setFromTime(OffsetDateTime fromTime) {
    this.fromTime = fromTime;
  }

  public PreOrderSettingsDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PreOrderSettingsDTO isPreOrderAvailable(Boolean isPreOrderAvailable) {
    this.isPreOrderAvailable = isPreOrderAvailable;
    return this;
  }

  /**
   * Get isPreOrderAvailable
   * @return isPreOrderAvailable
  **/
  @ApiModelProperty(value = "")


  public Boolean isIsPreOrderAvailable() {
    return isPreOrderAvailable;
  }

  public void setIsPreOrderAvailable(Boolean isPreOrderAvailable) {
    this.isPreOrderAvailable = isPreOrderAvailable;
  }

  public PreOrderSettingsDTO toTime(OffsetDateTime toTime) {
    this.toTime = toTime;
    return this;
  }

  /**
   * Get toTime
   * @return toTime
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getToTime() {
    return toTime;
  }

  public void setToTime(OffsetDateTime toTime) {
    this.toTime = toTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PreOrderSettingsDTO preOrderSettingsDTO = (PreOrderSettingsDTO) o;
    return Objects.equals(this.fromTime, preOrderSettingsDTO.fromTime) &&
        Objects.equals(this.id, preOrderSettingsDTO.id) &&
        Objects.equals(this.isPreOrderAvailable, preOrderSettingsDTO.isPreOrderAvailable) &&
        Objects.equals(this.toTime, preOrderSettingsDTO.toTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromTime, id, isPreOrderAvailable, toTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PreOrderSettingsDTO {\n");
    
    sb.append("    fromTime: ").append(toIndentedString(fromTime)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isPreOrderAvailable: ").append(toIndentedString(isPreOrderAvailable)).append("\n");
    sb.append("    toTime: ").append(toIndentedString(toTime)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

