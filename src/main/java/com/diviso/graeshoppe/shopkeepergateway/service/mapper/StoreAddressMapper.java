package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import org.mapstruct.*;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreAddress;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreAddressDTO;

/**
 * Mapper for the entity StoreAddress and its DTO StoreAddressDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StoreAddressMapper extends EntityMapper<StoreAddressDTO, StoreAddress> {



    default StoreAddress fromId(Long id) {
        if (id == null) {
            return null;
        }
        StoreAddress storeAddress = new StoreAddress();
        storeAddress.setId(id);
        return storeAddress;
    }
}