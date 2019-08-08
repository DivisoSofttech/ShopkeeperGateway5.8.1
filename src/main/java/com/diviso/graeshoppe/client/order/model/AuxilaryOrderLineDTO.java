package com.diviso.graeshoppe.client.order.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AuxilaryOrderLineDTO
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-08-06T14:01:39.473+05:30[Asia/Calcutta]")

public class AuxilaryOrderLineDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("orderLineId")
  private Long orderLineId = null;

  public AuxilaryOrderLineDTO id(Long id) {
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

  public AuxilaryOrderLineDTO orderLineId(Long orderLineId) {
    this.orderLineId = orderLineId;
    return this;
  }

  /**
   * Get orderLineId
   * @return orderLineId
  **/
  @ApiModelProperty(value = "")


  public Long getOrderLineId() {
    return orderLineId;
  }

  public void setOrderLineId(Long orderLineId) {
    this.orderLineId = orderLineId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuxilaryOrderLineDTO auxilaryOrderLineDTO = (AuxilaryOrderLineDTO) o;
    return Objects.equals(this.id, auxilaryOrderLineDTO.id) &&
        Objects.equals(this.orderLineId, auxilaryOrderLineDTO.orderLineId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, orderLineId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuxilaryOrderLineDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    orderLineId: ").append(toIndentedString(orderLineId)).append("\n");
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
