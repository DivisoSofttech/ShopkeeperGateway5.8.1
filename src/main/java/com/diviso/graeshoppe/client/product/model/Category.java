package com.diviso.graeshoppe.client.product.model;

import java.util.Objects;
import com.diviso.graeshoppe.client.product.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Category
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-10-28T15:55:43.394+05:30[Asia/Kolkata]")
@Document(indexName = "category")
public class Category   {
  @JsonProperty("description")
  private String description = null;

  public String getImageLink() {
	return imageLink;
}

public void setImageLink(String imageLink) {
	this.imageLink = imageLink;
}

@JsonProperty("iDPcode")
  private String iDPcode = null;

  @JsonProperty("id")
  private Long id = null;
  
  
  @JsonProperty("imagelink")
  private String imageLink = null;

  @JsonProperty("image")
  private byte[] image = null;

  @JsonProperty("imageContentType")
  private String imageContentType = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("products")
  @Valid
  private List<Product> products = null;

  public Category description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Category iDPcode(String iDPcode) {
    this.iDPcode = iDPcode;
    return this;
  }

  /**
   * Get iDPcode
   * @return iDPcode
  **/
  @ApiModelProperty(value = "")


  public String getIDPcode() {
    return iDPcode;
  }

  public void setIDPcode(String iDPcode) {
    this.iDPcode = iDPcode;
  }

  public Category id(Long id) {
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

  public Category image(byte[] image) {
    this.image = image;
    return this;
  }

  /**
   * Get image
   * @return image
  **/
  @ApiModelProperty(value = "")

@Pattern(regexp="^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$") 
  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }

  public Category imageContentType(String imageContentType) {
    this.imageContentType = imageContentType;
    return this;
  }

  /**
   * Get imageContentType
   * @return imageContentType
  **/
  @ApiModelProperty(value = "")


  public String getImageContentType() {
    return imageContentType;
  }

  public void setImageContentType(String imageContentType) {
    this.imageContentType = imageContentType;
  }

  public Category name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Category products(List<Product> products) {
    this.products = products;
    return this;
  }

  public Category addProductsItem(Product productsItem) {
    if (this.products == null) {
      this.products = new ArrayList<Product>();
    }
    this.products.add(productsItem);
    return this;
  }

  /**
   * Get products
   * @return products
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }




  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((iDPcode == null) ? 0 : iDPcode.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + Arrays.hashCode(image);
	result = prime * result + ((imageContentType == null) ? 0 : imageContentType.hashCode());
	result = prime * result + ((imageLink == null) ? 0 : imageLink.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((products == null) ? 0 : products.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Category other = (Category) obj;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (iDPcode == null) {
		if (other.iDPcode != null)
			return false;
	} else if (!iDPcode.equals(other.iDPcode))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (!Arrays.equals(image, other.image))
		return false;
	if (imageContentType == null) {
		if (other.imageContentType != null)
			return false;
	} else if (!imageContentType.equals(other.imageContentType))
		return false;
	if (imageLink == null) {
		if (other.imageLink != null)
			return false;
	} else if (!imageLink.equals(other.imageLink))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (products == null) {
		if (other.products != null)
			return false;
	} else if (!products.equals(other.products))
		return false;
	return true;
}

@Override
public String toString() {
	return "Category [description=" + description + ", iDPcode=" + iDPcode + ", id=" + id + ", imageLink=" + imageLink
			+ ", image=" + Arrays.toString(image) + ", imageContentType=" + imageContentType + ", name=" + name
			+ ", products=" + products + "]";
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

