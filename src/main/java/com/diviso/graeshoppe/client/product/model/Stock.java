package com.diviso.graeshoppe.client.product.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Stock
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-17T14:38:38.757+05:30[Asia/Kolkata]")
@Document(indexName = "stock")
public class Stock   {
  @JsonProperty("dateOfStockUpdated")
  private LocalDate dateOfStockUpdated = null;

  @JsonProperty("deliveryNoteRef")
  private Long deliveryNoteRef = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("reference")
  private String reference = null;

  @JsonProperty("status")
  private Status status = null;

  @JsonProperty("stockLines")
  @Valid
  private List<StockLine> stockLines = null;

  @JsonProperty("storageCost")
  private Double storageCost = null;

  public Stock dateOfStockUpdated(LocalDate dateOfStockUpdated) {
    this.dateOfStockUpdated = dateOfStockUpdated;
    return this;
  }

  /**
   * Get dateOfStockUpdated
   * @return dateOfStockUpdated
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getDateOfStockUpdated() {
    return dateOfStockUpdated;
  }

  public void setDateOfStockUpdated(LocalDate dateOfStockUpdated) {
    this.dateOfStockUpdated = dateOfStockUpdated;
  }

  public Stock deliveryNoteRef(Long deliveryNoteRef) {
    this.deliveryNoteRef = deliveryNoteRef;
    return this;
  }

  /**
   * Get deliveryNoteRef
   * @return deliveryNoteRef
  **/
  @ApiModelProperty(value = "")


  public Long getDeliveryNoteRef() {
    return deliveryNoteRef;
  }

  public void setDeliveryNoteRef(Long deliveryNoteRef) {
    this.deliveryNoteRef = deliveryNoteRef;
  }

  public Stock id(Long id) {
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

  public Stock reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Get reference
   * @return reference
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Stock status(Status status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Stock stockLines(List<StockLine> stockLines) {
    this.stockLines = stockLines;
    return this;
  }

  public Stock addStockLinesItem(StockLine stockLinesItem) {
    if (this.stockLines == null) {
      this.stockLines = new ArrayList<StockLine>();
    }
    this.stockLines.add(stockLinesItem);
    return this;
  }

  /**
   * Get stockLines
   * @return stockLines
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<StockLine> getStockLines() {
    return stockLines;
  }

  public void setStockLines(List<StockLine> stockLines) {
    this.stockLines = stockLines;
  }

  public Stock storageCost(Double storageCost) {
    this.storageCost = storageCost;
    return this;
  }

  /**
   * Get storageCost
   * @return storageCost
  **/
  @ApiModelProperty(value = "")


  public Double getStorageCost() {
    return storageCost;
  }

  public void setStorageCost(Double storageCost) {
    this.storageCost = storageCost;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stock stock = (Stock) o;
    return Objects.equals(this.dateOfStockUpdated, stock.dateOfStockUpdated) &&
        Objects.equals(this.deliveryNoteRef, stock.deliveryNoteRef) &&
        Objects.equals(this.id, stock.id) &&
        Objects.equals(this.reference, stock.reference) &&
        Objects.equals(this.status, stock.status) &&
        Objects.equals(this.stockLines, stock.stockLines) &&
        Objects.equals(this.storageCost, stock.storageCost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateOfStockUpdated, deliveryNoteRef, id, reference, status, stockLines, storageCost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stock {\n");
    
    sb.append("    dateOfStockUpdated: ").append(toIndentedString(dateOfStockUpdated)).append("\n");
    sb.append("    deliveryNoteRef: ").append(toIndentedString(deliveryNoteRef)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    stockLines: ").append(toIndentedString(stockLines)).append("\n");
    sb.append("    storageCost: ").append(toIndentedString(storageCost)).append("\n");
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

