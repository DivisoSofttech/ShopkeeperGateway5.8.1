package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import org.mapstruct.Mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.product.model.Brand;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.BrandDTO;

/**
 * Mapper for the entity Brand and its DTO BrandDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BrandMapper extends EntityMapper<BrandDTO, Brand> {



    default Brand fromId(Long id) {
        if (id == null) {
            return null;
        }
        Brand brand = new Brand();
        brand.setId(id);
        return brand;
    }
}