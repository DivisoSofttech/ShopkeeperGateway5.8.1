package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.product.model.Brand;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.Category;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.Discount;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.Location;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.Manufacturer;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.Product;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.ProductDTO;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.TaxCategory;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.UOM;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-06T17:25:33+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private TaxCategoryMapper taxCategoryMapper;
    @Autowired
    private UOMMapper uOMMapper;
    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private ManufacturerMapper manufacturerMapper;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private DiscountMapper discountMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Product> toEntity(List<ProductDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( dtoList.size() );
        for ( ProductDTO productDTO : dtoList ) {
            list.add( toEntity( productDTO ) );
        }

        return list;
    }

    @Override
    public List<ProductDTO> toDto(List<Product> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( entityList.size() );
        for ( Product product : entityList ) {
            list.add( toDto( product ) );
        }

        return list;
    }

    @Override
    public ProductDTO toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setLocationId( productLocationId( product ) );
        productDTO.setBrandId( productBrandId( product ) );
        productDTO.setManufacturerId( productManufacturerId( product ) );
        productDTO.setUnitId( productUnitId( product ) );
        productDTO.setDiscountId( productDiscountId( product ) );
        productDTO.setCategoryId( productCategoryId( product ) );
        productDTO.setTaxCategoryId( productTaxCategoryId( product ) );
        productDTO.setBuyPrice( product.getBuyPrice() );
        productDTO.setIDPcode( product.getIDPcode() );
        productDTO.setId( product.getId() );
        productDTO.setImageLink( product.getImageLink() );
        productDTO.setIsActive( product.isIsActive() );
        productDTO.setIsAuxilaryItem( product.isIsAuxilaryItem() );
        productDTO.setIsServiceItem( product.isIsServiceItem() );
        productDTO.setMaxQuantityLevel( product.getMaxQuantityLevel() );
        productDTO.setMinQuantityLevel( product.getMinQuantityLevel() );
        productDTO.setName( product.getName() );
        productDTO.setReference( product.getReference() );
        productDTO.setSellingPrice( product.getSellingPrice() );
        productDTO.setShowInCatalogue( product.isShowInCatalogue() );
        productDTO.setSku( product.getSku() );
        productDTO.setStorageCost( product.getStorageCost() );

        return productDTO;
    }

    @Override
    public Product toEntity(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setUnit( uOMMapper.fromId( productDTO.getUnitId() ) );
        product.setDiscount( discountMapper.fromId( productDTO.getDiscountId() ) );
        product.setLocation( locationMapper.fromId( productDTO.getLocationId() ) );
        product.setCategory( categoryMapper.fromId( productDTO.getCategoryId() ) );
        product.setBrand( brandMapper.fromId( productDTO.getBrandId() ) );
        product.setTaxCategory( taxCategoryMapper.fromId( productDTO.getTaxCategoryId() ) );
        product.setManufacturer( manufacturerMapper.fromId( productDTO.getManufacturerId() ) );
        product.setBuyPrice( productDTO.getBuyPrice() );
        product.setIDPcode( productDTO.getIDPcode() );
        product.setId( productDTO.getId() );
        product.setImageLink( productDTO.getImageLink() );
        product.setIsActive( productDTO.isIsActive() );
        product.setIsAuxilaryItem( productDTO.isIsAuxilaryItem() );
        product.setIsServiceItem( productDTO.isIsServiceItem() );
        product.setMaxQuantityLevel( productDTO.getMaxQuantityLevel() );
        product.setMinQuantityLevel( productDTO.getMinQuantityLevel() );
        product.setName( productDTO.getName() );
        product.setReference( productDTO.getReference() );
        product.setSellingPrice( productDTO.getSellingPrice() );
        product.setShowInCatalogue( productDTO.isShowInCatalogue() );
        product.setSku( productDTO.getSku() );
        product.setStorageCost( productDTO.getStorageCost() );

        return product;
    }

    private Long productLocationId(Product product) {
        if ( product == null ) {
            return null;
        }
        Location location = product.getLocation();
        if ( location == null ) {
            return null;
        }
        Long id = location.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long productBrandId(Product product) {
        if ( product == null ) {
            return null;
        }
        Brand brand = product.getBrand();
        if ( brand == null ) {
            return null;
        }
        Long id = brand.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long productManufacturerId(Product product) {
        if ( product == null ) {
            return null;
        }
        Manufacturer manufacturer = product.getManufacturer();
        if ( manufacturer == null ) {
            return null;
        }
        Long id = manufacturer.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long productUnitId(Product product) {
        if ( product == null ) {
            return null;
        }
        UOM unit = product.getUnit();
        if ( unit == null ) {
            return null;
        }
        Long id = unit.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long productDiscountId(Product product) {
        if ( product == null ) {
            return null;
        }
        Discount discount = product.getDiscount();
        if ( discount == null ) {
            return null;
        }
        Long id = discount.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long productCategoryId(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long productTaxCategoryId(Product product) {
        if ( product == null ) {
            return null;
        }
        TaxCategory taxCategory = product.getTaxCategory();
        if ( taxCategory == null ) {
            return null;
        }
        Long id = taxCategory.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
