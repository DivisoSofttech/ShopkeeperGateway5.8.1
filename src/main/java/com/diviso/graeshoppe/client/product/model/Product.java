package com.diviso.graeshoppe.client.product.model;

import java.util.Objects;
import java.util.Set;

import com.diviso.graeshoppe.client.product.model.AuxilaryLineItem;
import com.diviso.graeshoppe.client.product.model.Brand;
import com.diviso.graeshoppe.client.product.model.Category;
import com.diviso.graeshoppe.client.product.model.ComboLineItem;
import com.diviso.graeshoppe.client.product.model.Discount;
import com.diviso.graeshoppe.client.product.model.Label;
import com.diviso.graeshoppe.client.product.model.Location;
import com.diviso.graeshoppe.client.product.model.Manufacturer;
import com.diviso.graeshoppe.client.product.model.Supplier;
import com.diviso.graeshoppe.client.product.model.TaxCategory;
import com.diviso.graeshoppe.client.product.model.UOM;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Product
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-10-28T15:55:43.394+05:30[Asia/Kolkata]")
@Document(indexName = "product")
public class Product   {
 /* @JsonProperty("auxilaryLineItems")
  @Valid
  private List<AuxilaryLineItem> auxilaryLineItems = null;

  @JsonProperty("brand")
  private Brand brand = null;

  @JsonProperty("buyPrice")
  private Double buyPrice = null;

  @JsonProperty("category")
  private Category category = null;

  @JsonProperty("comboLineItems")
  @Valid
  private List<ComboLineItem> comboLineItems = null;

  @JsonProperty("discount")
  private Discount discount = null;
  
  @JsonProperty("imagelink")
  private String imageLink;

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

  @JsonProperty("image")
  private byte[] image = null;

  @JsonProperty("imageContentType")
  private String imageContentType = null;

  @JsonProperty("isActive")
  private Boolean isActive = null;

  @JsonProperty("isAuxilaryItem")
  private Boolean isAuxilaryItem = null;

  @JsonProperty("isServiceItem")
  private Boolean isServiceItem = null;

  @JsonProperty("labels")
  @Valid
  private List<Label> labels = null;

  @JsonProperty("location")
  private Location location = null;

  @JsonProperty("manufacturer")
  private Manufacturer manufacturer = null;

  @JsonProperty("maxQuantityLevel")
  private Double maxQuantityLevel = null;

  @JsonProperty("minQuantityLevel")
  private Double minQuantityLevel = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("reference")
  private String reference = null;

  @JsonProperty("sellingPrice")
  private Double sellingPrice = null;

  @JsonProperty("showInCatalogue")
  private Boolean showInCatalogue = null;

  @JsonProperty("sku")
  private String sku = null;

  @JsonProperty("storageCost")
  private Double storageCost = null;

  @JsonProperty("supplier")
  private Supplier supplier = null;

  @JsonProperty("taxCategory")
  private TaxCategory taxCategory = null;

  @JsonProperty("unit")
  private UOM unit = null;

  public Product auxilaryLineItems(List<AuxilaryLineItem> auxilaryLineItems) {
    this.auxilaryLineItems = auxilaryLineItems;
    return this;
  }

  public Product addAuxilaryLineItemsItem(AuxilaryLineItem auxilaryLineItemsItem) {
    if (this.auxilaryLineItems == null) {
      this.auxilaryLineItems = new ArrayList<AuxilaryLineItem>();
    }
    this.auxilaryLineItems.add(auxilaryLineItemsItem);
    return this;
  }

  *//**
   * Get auxilaryLineItems
   * @return auxilaryLineItems
  **//*
  @ApiModelProperty(value = "")

  @Valid

  public List<AuxilaryLineItem> getAuxilaryLineItems() {
    return auxilaryLineItems;
  }

  public void setAuxilaryLineItems(List<AuxilaryLineItem> auxilaryLineItems) {
    this.auxilaryLineItems = auxilaryLineItems;
  }

  public Product brand(Brand brand) {
    this.brand = brand;
    return this;
  }

  *//**
   * Get brand
   * @return brand
  **//*
  @ApiModelProperty(value = "")

  @Valid

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public Product buyPrice(Double buyPrice) {
    this.buyPrice = buyPrice;
    return this;
  }

  *//**
   * Get buyPrice
   * @return buyPrice
  **//*
  @ApiModelProperty(value = "")


  public Double getBuyPrice() {
    return buyPrice;
  }

  public void setBuyPrice(Double buyPrice) {
    this.buyPrice = buyPrice;
  }

  public Product category(Category category) {
    this.category = category;
    return this;
  }

  *//**
   * Get category
   * @return category
  **//*
  @ApiModelProperty(value = "")

  @Valid

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Product comboLineItems(List<ComboLineItem> comboLineItems) {
    this.comboLineItems = comboLineItems;
    return this;
  }

  public Product addComboLineItemsItem(ComboLineItem comboLineItemsItem) {
    if (this.comboLineItems == null) {
      this.comboLineItems = new ArrayList<ComboLineItem>();
    }
    this.comboLineItems.add(comboLineItemsItem);
    return this;
  }

  *//**
   * Get comboLineItems
   * @return comboLineItems
  **//*
  @ApiModelProperty(value = "")

  @Valid

  public List<ComboLineItem> getComboLineItems() {
    return comboLineItems;
  }

  public void setComboLineItems(List<ComboLineItem> comboLineItems) {
    this.comboLineItems = comboLineItems;
  }

  public Product discount(Discount discount) {
    this.discount = discount;
    return this;
  }

  *//**
   * Get discount
   * @return discount
  **//*
  @ApiModelProperty(value = "")

  @Valid

  public Discount getDiscount() {
    return discount;
  }

  public void setDiscount(Discount discount) {
    this.discount = discount;
  }

  public Product iDPcode(String iDPcode) {
    this.iDPcode = iDPcode;
    return this;
  }

  *//**
   * Get iDPcode
   * @return iDPcode
  **//*
  @ApiModelProperty(value = "")


  public String getIDPcode() {
    return iDPcode;
  }

  public void setIDPcode(String iDPcode) {
    this.iDPcode = iDPcode;
  }

  public Product id(Long id) {
    this.id = id;
    return this;
  }

  *//**
   * Get id
   * @return id
  **//*
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Product image(byte[] image) {
    this.image = image;
    return this;
  }

  *//**
   * Get image
   * @return image
  **//*
  @ApiModelProperty(value = "")

@Pattern(regexp="^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$") 
  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }

  public Product imageContentType(String imageContentType) {
    this.imageContentType = imageContentType;
    return this;
  }

  *//**
   * Get imageContentType
   * @return imageContentType
  **//*
  @ApiModelProperty(value = "")


  public String getImageContentType() {
    return imageContentType;
  }

  public void setImageContentType(String imageContentType) {
    this.imageContentType = imageContentType;
  }

  public Product isActive(Boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  *//**
   * Get isActive
   * @return isActive
  **//*
  @ApiModelProperty(value = "")


  public Boolean isIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public Product isAuxilaryItem(Boolean isAuxilaryItem) {
    this.isAuxilaryItem = isAuxilaryItem;
    return this;
  }

  *//**
   * Get isAuxilaryItem
   * @return isAuxilaryItem
  **//*
  @ApiModelProperty(value = "")


  public Boolean isIsAuxilaryItem() {
    return isAuxilaryItem;
  }

  public void setIsAuxilaryItem(Boolean isAuxilaryItem) {
    this.isAuxilaryItem = isAuxilaryItem;
  }

  public Product isServiceItem(Boolean isServiceItem) {
    this.isServiceItem = isServiceItem;
    return this;
  }

  *//**
   * Get isServiceItem
   * @return isServiceItem
  **//*
  @ApiModelProperty(value = "")


  public Boolean isIsServiceItem() {
    return isServiceItem;
  }

  public void setIsServiceItem(Boolean isServiceItem) {
    this.isServiceItem = isServiceItem;
  }

  public Product labels(List<Label> labels) {
    this.labels = labels;
    return this;
  }

  public Product addLabelsItem(Label labelsItem) {
    if (this.labels == null) {
      this.labels = new ArrayList<Label>();
    }
    this.labels.add(labelsItem);
    return this;
  }

  *//**
   * Get labels
   * @return labels
  **//*
  @ApiModelProperty(value = "")

  @Valid

  public List<Label> getLabels() {
    return labels;
  }

  public void setLabels(List<Label> labels) {
    this.labels = labels;
  }

  public Product location(Location location) {
    this.location = location;
    return this;
  }

  *//**
   * Get location
   * @return location
  **//*
  @ApiModelProperty(value = "")

  @Valid

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Product manufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
    return this;
  }

  *//**
   * Get manufacturer
   * @return manufacturer
  **//*
  @ApiModelProperty(value = "")

  @Valid

  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }

  public Product maxQuantityLevel(Double maxQuantityLevel) {
    this.maxQuantityLevel = maxQuantityLevel;
    return this;
  }

  *//**
   * Get maxQuantityLevel
   * @return maxQuantityLevel
  **//*
  @ApiModelProperty(value = "")


  public Double getMaxQuantityLevel() {
    return maxQuantityLevel;
  }

  public void setMaxQuantityLevel(Double maxQuantityLevel) {
    this.maxQuantityLevel = maxQuantityLevel;
  }

  public Product minQuantityLevel(Double minQuantityLevel) {
    this.minQuantityLevel = minQuantityLevel;
    return this;
  }

  *//**
   * Get minQuantityLevel
   * @return minQuantityLevel
  **//*
  @ApiModelProperty(value = "")


  public Double getMinQuantityLevel() {
    return minQuantityLevel;
  }

  public void setMinQuantityLevel(Double minQuantityLevel) {
    this.minQuantityLevel = minQuantityLevel;
  }

  public Product name(String name) {
    this.name = name;
    return this;
  }

  *//**
   * Get name
   * @return name
  **//*
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Product reference(String reference) {
    this.reference = reference;
    return this;
  }

  *//**
   * Get reference
   * @return reference
  **//*
  @ApiModelProperty(value = "")


  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Product sellingPrice(Double sellingPrice) {
    this.sellingPrice = sellingPrice;
    return this;
  }

  *//**
   * Get sellingPrice
   * @return sellingPrice
  **//*
  @ApiModelProperty(value = "")


  public Double getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(Double sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public Product showInCatalogue(Boolean showInCatalogue) {
    this.showInCatalogue = showInCatalogue;
    return this;
  }

  *//**
   * Get showInCatalogue
   * @return showInCatalogue
  **//*
  @ApiModelProperty(value = "")


  public Boolean isShowInCatalogue() {
    return showInCatalogue;
  }

  public void setShowInCatalogue(Boolean showInCatalogue) {
    this.showInCatalogue = showInCatalogue;
  }

  public Product sku(String sku) {
    this.sku = sku;
    return this;
  }

  *//**
   * Get sku
   * @return sku
  **//*
  @ApiModelProperty(value = "")


  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public Product storageCost(Double storageCost) {
    this.storageCost = storageCost;
    return this;
  }

  *//**
   * Get storageCost
   * @return storageCost
  **//*
  @ApiModelProperty(value = "")


  public Double getStorageCost() {
    return storageCost;
  }

  public void setStorageCost(Double storageCost) {
    this.storageCost = storageCost;
  }

  public Product supplier(Supplier supplier) {
    this.supplier = supplier;
    return this;
  }

  *//**
   * Get supplier
   * @return supplier
  **//*
  @ApiModelProperty(value = "")

  @Valid

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public Product taxCategory(TaxCategory taxCategory) {
    this.taxCategory = taxCategory;
    return this;
  }

  *//**
   * Get taxCategory
   * @return taxCategory
  **//*
  @ApiModelProperty(value = "")

  @Valid

  public TaxCategory getTaxCategory() {
    return taxCategory;
  }

  public void setTaxCategory(TaxCategory taxCategory) {
    this.taxCategory = taxCategory;
  }

  public Product unit(UOM unit) {
    this.unit = unit;
    return this;
  }

  *//**
   * Get unit
   * @return unit
  **//*
  @ApiModelProperty(value = "")

  @Valid

  public UOM getUnit() {
    return unit;
  }

  public void setUnit(UOM unit) {
    this.unit = unit;
  }


  
  @Override
public String toString() {
	return "Product [auxilaryLineItems=" + auxilaryLineItems + ", brand=" + brand + ", buyPrice=" + buyPrice
			+ ", category=" + category + ", comboLineItems=" + comboLineItems + ", discount=" + discount
			+ ", imageLink=" + imageLink + ", iDPcode=" + iDPcode + ", id=" + id + ", image=" + Arrays.toString(image)
			+ ", imageContentType=" + imageContentType + ", isActive=" + isActive + ", isAuxilaryItem=" + isAuxilaryItem
			+ ", isServiceItem=" + isServiceItem + ", labels=" + labels + ", location=" + location + ", manufacturer="
			+ manufacturer + ", maxQuantityLevel=" + maxQuantityLevel + ", minQuantityLevel=" + minQuantityLevel
			+ ", name=" + name + ", reference=" + reference + ", sellingPrice=" + sellingPrice + ", showInCatalogue="
			+ showInCatalogue + ", sku=" + sku + ", storageCost=" + storageCost + ", supplier=" + supplier
			+ ", taxCategory=" + taxCategory + ", unit=" + unit + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((auxilaryLineItems == null) ? 0 : auxilaryLineItems.hashCode());
	result = prime * result + ((brand == null) ? 0 : brand.hashCode());
	result = prime * result + ((buyPrice == null) ? 0 : buyPrice.hashCode());
	result = prime * result + ((category == null) ? 0 : category.hashCode());
	result = prime * result + ((comboLineItems == null) ? 0 : comboLineItems.hashCode());
	result = prime * result + ((discount == null) ? 0 : discount.hashCode());
	result = prime * result + ((iDPcode == null) ? 0 : iDPcode.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + Arrays.hashCode(image);
	result = prime * result + ((imageContentType == null) ? 0 : imageContentType.hashCode());
	result = prime * result + ((imageLink == null) ? 0 : imageLink.hashCode());
	result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
	result = prime * result + ((isAuxilaryItem == null) ? 0 : isAuxilaryItem.hashCode());
	result = prime * result + ((isServiceItem == null) ? 0 : isServiceItem.hashCode());
	result = prime * result + ((labels == null) ? 0 : labels.hashCode());
	result = prime * result + ((location == null) ? 0 : location.hashCode());
	result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
	result = prime * result + ((maxQuantityLevel == null) ? 0 : maxQuantityLevel.hashCode());
	result = prime * result + ((minQuantityLevel == null) ? 0 : minQuantityLevel.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((reference == null) ? 0 : reference.hashCode());
	result = prime * result + ((sellingPrice == null) ? 0 : sellingPrice.hashCode());
	result = prime * result + ((showInCatalogue == null) ? 0 : showInCatalogue.hashCode());
	result = prime * result + ((sku == null) ? 0 : sku.hashCode());
	result = prime * result + ((storageCost == null) ? 0 : storageCost.hashCode());
	result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
	result = prime * result + ((taxCategory == null) ? 0 : taxCategory.hashCode());
	result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
	Product other = (Product) obj;
	if (auxilaryLineItems == null) {
		if (other.auxilaryLineItems != null)
			return false;
	} else if (!auxilaryLineItems.equals(other.auxilaryLineItems))
		return false;
	if (brand == null) {
		if (other.brand != null)
			return false;
	} else if (!brand.equals(other.brand))
		return false;
	if (buyPrice == null) {
		if (other.buyPrice != null)
			return false;
	} else if (!buyPrice.equals(other.buyPrice))
		return false;
	if (category == null) {
		if (other.category != null)
			return false;
	} else if (!category.equals(other.category))
		return false;
	if (comboLineItems == null) {
		if (other.comboLineItems != null)
			return false;
	} else if (!comboLineItems.equals(other.comboLineItems))
		return false;
	if (discount == null) {
		if (other.discount != null)
			return false;
	} else if (!discount.equals(other.discount))
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
	if (isActive == null) {
		if (other.isActive != null)
			return false;
	} else if (!isActive.equals(other.isActive))
		return false;
	if (isAuxilaryItem == null) {
		if (other.isAuxilaryItem != null)
			return false;
	} else if (!isAuxilaryItem.equals(other.isAuxilaryItem))
		return false;
	if (isServiceItem == null) {
		if (other.isServiceItem != null)
			return false;
	} else if (!isServiceItem.equals(other.isServiceItem))
		return false;
	if (labels == null) {
		if (other.labels != null)
			return false;
	} else if (!labels.equals(other.labels))
		return false;
	if (location == null) {
		if (other.location != null)
			return false;
	} else if (!location.equals(other.location))
		return false;
	if (manufacturer == null) {
		if (other.manufacturer != null)
			return false;
	} else if (!manufacturer.equals(other.manufacturer))
		return false;
	if (maxQuantityLevel == null) {
		if (other.maxQuantityLevel != null)
			return false;
	} else if (!maxQuantityLevel.equals(other.maxQuantityLevel))
		return false;
	if (minQuantityLevel == null) {
		if (other.minQuantityLevel != null)
			return false;
	} else if (!minQuantityLevel.equals(other.minQuantityLevel))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (reference == null) {
		if (other.reference != null)
			return false;
	} else if (!reference.equals(other.reference))
		return false;
	if (sellingPrice == null) {
		if (other.sellingPrice != null)
			return false;
	} else if (!sellingPrice.equals(other.sellingPrice))
		return false;
	if (showInCatalogue == null) {
		if (other.showInCatalogue != null)
			return false;
	} else if (!showInCatalogue.equals(other.showInCatalogue))
		return false;
	if (sku == null) {
		if (other.sku != null)
			return false;
	} else if (!sku.equals(other.sku))
		return false;
	if (storageCost == null) {
		if (other.storageCost != null)
			return false;
	} else if (!storageCost.equals(other.storageCost))
		return false;
	if (supplier == null) {
		if (other.supplier != null)
			return false;
	} else if (!supplier.equals(other.supplier))
		return false;
	if (taxCategory == null) {
		if (other.taxCategory != null)
			return false;
	} else if (!taxCategory.equals(other.taxCategory))
		return false;
	if (unit == null) {
		if (other.unit != null)
			return false;
	} else if (!unit.equals(other.unit))
		return false;
	return true;
}

*//**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   *//*
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }*/
	  private Long id;

	    
	    private String reference;

	 
	    private String name;

	
	    private Boolean showInCatalogue;

	    private byte[] image;

	 
	    private String imageContentType;

	
	    private String imageLink;

	  
	    private Boolean isActive;

	   
	    private String sku;

	  
	    private String iDPcode;

	   
	    private Boolean isServiceItem;

	   
	    private Boolean isAuxilaryItem;

	 
	    private Double minQuantityLevel;

	   
	    private Double maxQuantityLevel;

	 
	    private Double storageCost;

	  
	    private Double sellingPrice;

	  
	    private Double buyPrice;

	   
	    private Set<AuxilaryLineItem> auxilaryLineItems = new HashSet<>();
	  
	    private Set<ComboLineItem> comboLineItems = new HashSet<>();
	  
	    private Set<Label> labels = new HashSet<>();
	    
	    private TaxCategory taxCategory;

	   
	    private UOM unit;

	  
	    private Location location;

	   
	    private Supplier supplier;

	  
	    private Manufacturer manufacturer;

	   
	    private Brand brand;

	 
	    private Discount discount;

	   
	    private Category category;

	    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getReference() {
	        return reference;
	    }

	    public Product reference(String reference) {
	        this.reference = reference;
	        return this;
	    }

	    public void setReference(String reference) {
	        this.reference = reference;
	    }

	    public String getName() {
	        return name;
	    }

	    public Product name(String name) {
	        this.name = name;
	        return this;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Boolean isShowInCatalogue() {
	        return showInCatalogue;
	    }

	    public Product showInCatalogue(Boolean showInCatalogue) {
	        this.showInCatalogue = showInCatalogue;
	        return this;
	    }

	    public void setShowInCatalogue(Boolean showInCatalogue) {
	        this.showInCatalogue = showInCatalogue;
	    }

	    public byte[] getImage() {
	        return image;
	    }

	    public Product image(byte[] image) {
	        this.image = image;
	        return this;
	    }

	    public void setImage(byte[] image) {
	        this.image = image;
	    }

	    public String getImageContentType() {
	        return imageContentType;
	    }

	    public Product imageContentType(String imageContentType) {
	        this.imageContentType = imageContentType;
	        return this;
	    }

	    public void setImageContentType(String imageContentType) {
	        this.imageContentType = imageContentType;
	    }

	    public String getImageLink() {
	        return imageLink;
	    }

	    public Product imageLink(String imageLink) {
	        this.imageLink = imageLink;
	        return this;
	    }

	    public void setImageLink(String imageLink) {
	        this.imageLink = imageLink;
	    }

	    public Boolean isIsActive() {
	        return isActive;
	    }

	    public Product isActive(Boolean isActive) {
	        this.isActive = isActive;
	        return this;
	    }

	    public void setIsActive(Boolean isActive) {
	        this.isActive = isActive;
	    }

	    public String getSku() {
	        return sku;
	    }

	    public Product sku(String sku) {
	        this.sku = sku;
	        return this;
	    }

	    public void setSku(String sku) {
	        this.sku = sku;
	    }

	    public String getiDPcode() {
	        return iDPcode;
	    }

	    public Product iDPcode(String iDPcode) {
	        this.iDPcode = iDPcode;
	        return this;
	    }

	    public void setiDPcode(String iDPcode) {
	        this.iDPcode = iDPcode;
	    }

	    public Boolean isIsServiceItem() {
	        return isServiceItem;
	    }

	    public Product isServiceItem(Boolean isServiceItem) {
	        this.isServiceItem = isServiceItem;
	        return this;
	    }

	    public void setIsServiceItem(Boolean isServiceItem) {
	        this.isServiceItem = isServiceItem;
	    }

	    public Boolean isIsAuxilaryItem() {
	        return isAuxilaryItem;
	    }

	    public Product isAuxilaryItem(Boolean isAuxilaryItem) {
	        this.isAuxilaryItem = isAuxilaryItem;
	        return this;
	    }

	    public void setIsAuxilaryItem(Boolean isAuxilaryItem) {
	        this.isAuxilaryItem = isAuxilaryItem;
	    }

	    public Double getMinQuantityLevel() {
	        return minQuantityLevel;
	    }

	    public Product minQuantityLevel(Double minQuantityLevel) {
	        this.minQuantityLevel = minQuantityLevel;
	        return this;
	    }

	    public void setMinQuantityLevel(Double minQuantityLevel) {
	        this.minQuantityLevel = minQuantityLevel;
	    }

	    public Double getMaxQuantityLevel() {
	        return maxQuantityLevel;
	    }

	    public Product maxQuantityLevel(Double maxQuantityLevel) {
	        this.maxQuantityLevel = maxQuantityLevel;
	        return this;
	    }

	    public void setMaxQuantityLevel(Double maxQuantityLevel) {
	        this.maxQuantityLevel = maxQuantityLevel;
	    }

	    public Double getStorageCost() {
	        return storageCost;
	    }

	    public Product storageCost(Double storageCost) {
	        this.storageCost = storageCost;
	        return this;
	    }

	    public void setStorageCost(Double storageCost) {
	        this.storageCost = storageCost;
	    }

	    public Double getSellingPrice() {
	        return sellingPrice;
	    }

	    public Product sellingPrice(Double sellingPrice) {
	        this.sellingPrice = sellingPrice;
	        return this;
	    }

	    public void setSellingPrice(Double sellingPrice) {
	        this.sellingPrice = sellingPrice;
	    }

	    public Double getBuyPrice() {
	        return buyPrice;
	    }

	    public Product buyPrice(Double buyPrice) {
	        this.buyPrice = buyPrice;
	        return this;
	    }

	    public void setBuyPrice(Double buyPrice) {
	        this.buyPrice = buyPrice;
	    }

	    public Set<AuxilaryLineItem> getAuxilaryLineItems() {
	        return auxilaryLineItems;
	    }

	    public Product auxilaryLineItems(Set<AuxilaryLineItem> auxilaryLineItems) {
	        this.auxilaryLineItems = auxilaryLineItems;
	        return this;
	    }

	    public Product addAuxilaryLineItems(AuxilaryLineItem auxilaryLineItem) {
	        this.auxilaryLineItems.add(auxilaryLineItem);
	        auxilaryLineItem.setProduct(this);
	        return this;
	    }

	    public Product removeAuxilaryLineItems(AuxilaryLineItem auxilaryLineItem) {
	        this.auxilaryLineItems.remove(auxilaryLineItem);
	        auxilaryLineItem.setProduct(null);
	        return this;
	    }

	    public void setAuxilaryLineItems(Set<AuxilaryLineItem> auxilaryLineItems) {
	        this.auxilaryLineItems = auxilaryLineItems;
	    }

	    public Set<ComboLineItem> getComboLineItems() {
	        return comboLineItems;
	    }

	    public Product comboLineItems(Set<ComboLineItem> comboLineItems) {
	        this.comboLineItems = comboLineItems;
	        return this;
	    }

	    public Product addComboLineItems(ComboLineItem comboLineItem) {
	        this.comboLineItems.add(comboLineItem);
	        comboLineItem.setProduct(this);
	        return this;
	    }

	    public Product removeComboLineItems(ComboLineItem comboLineItem) {
	        this.comboLineItems.remove(comboLineItem);
	        comboLineItem.setProduct(null);
	        return this;
	    }

	    public void setComboLineItems(Set<ComboLineItem> comboLineItems) {
	        this.comboLineItems = comboLineItems;
	    }

	    public Set<Label> getLabels() {
	        return labels;
	    }

	    public Product labels(Set<Label> labels) {
	        this.labels = labels;
	        return this;
	    }

	    public Product addLabels(Label label) {
	        this.labels.add(label);
	        label.setProduct(this);
	        return this;
	    }

	    public Product removeLabels(Label label) {
	        this.labels.remove(label);
	        label.setProduct(null);
	        return this;
	    }

	    public void setLabels(Set<Label> labels) {
	        this.labels = labels;
	    }

	    public TaxCategory getTaxCategory() {
	        return taxCategory;
	    }

	    public Product taxCategory(TaxCategory taxCategory) {
	        this.taxCategory = taxCategory;
	        return this;
	    }

	    public void setTaxCategory(TaxCategory taxCategory) {
	        this.taxCategory = taxCategory;
	    }

	    public UOM getUnit() {
	        return unit;
	    }

	    public Product unit(UOM uOM) {
	        this.unit = uOM;
	        return this;
	    }

	    public void setUnit(UOM uOM) {
	        this.unit = uOM;
	    }

	    public Location getLocation() {
	        return location;
	    }

	    public Product location(Location location) {
	        this.location = location;
	        return this;
	    }

	    public void setLocation(Location location) {
	        this.location = location;
	    }

	    public Supplier getSupplier() {
	        return supplier;
	    }

	    public Product supplier(Supplier supplier) {
	        this.supplier = supplier;
	        return this;
	    }

	    public void setSupplier(Supplier supplier) {
	        this.supplier = supplier;
	    }

	    public Manufacturer getManufacturer() {
	        return manufacturer;
	    }

	    public Product manufacturer(Manufacturer manufacturer) {
	        this.manufacturer = manufacturer;
	        return this;
	    }

	    public void setManufacturer(Manufacturer manufacturer) {
	        this.manufacturer = manufacturer;
	    }

	    public Brand getBrand() {
	        return brand;
	    }

	    public Product brand(Brand brand) {
	        this.brand = brand;
	        return this;
	    }

	    public void setBrand(Brand brand) {
	        this.brand = brand;
	    }

	    public Discount getDiscount() {
	        return discount;
	    }

	    public Product discount(Discount discount) {
	        this.discount = discount;
	        return this;
	    }

	    public void setDiscount(Discount discount) {
	        this.discount = discount;
	    }

	    public Category getCategory() {
	        return category;
	    }

	    public Product category(Category category) {
	        this.category = category;
	        return this;
	    }

	    public void setCategory(Category category) {
	        this.category = category;
	    }
	    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) {
	            return true;
	        }
	        if (o == null || getClass() != o.getClass()) {
	            return false;
	        }
	        Product product = (Product) o;
	        if (product.getId() == null || getId() == null) {
	            return false;
	        }
	        return Objects.equals(getId(), product.getId());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hashCode(getId());
	    }

	    @Override
	    public String toString() {
	        return "Product{" +
	            "id=" + getId() +
	            ", reference='" + getReference() + "'" +
	            ", name='" + getName() + "'" +
	            ", showInCatalogue='" + isShowInCatalogue() + "'" +
	            ", image='" + getImage() + "'" +
	            ", imageContentType='" + getImageContentType() + "'" +
	            ", imageLink='" + getImageLink() + "'" +
	            ", isActive='" + isIsActive() + "'" +
	            ", sku='" + getSku() + "'" +
	            ", iDPcode='" + getiDPcode() + "'" +
	            ", isServiceItem='" + isIsServiceItem() + "'" +
	            ", isAuxilaryItem='" + isIsAuxilaryItem() + "'" +
	            ", minQuantityLevel=" + getMinQuantityLevel() +
	            ", maxQuantityLevel=" + getMaxQuantityLevel() +
	            ", storageCost=" + getStorageCost() +
	            ", sellingPrice=" + getSellingPrice() +
	            ", buyPrice=" + getBuyPrice() +
	            "}";
	    }
}

