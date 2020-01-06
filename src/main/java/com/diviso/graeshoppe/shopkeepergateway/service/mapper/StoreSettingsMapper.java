package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import org.mapstruct.*;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreSettings;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreSettingsDTO;
/**
 * Mapper for the entity StoreSettings and its DTO StoreSettingsDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StoreSettingsMapper extends EntityMapper<StoreSettingsDTO, StoreSettings> {



    default StoreSettings fromId(Long id) {
        if (id == null) {
            return null;
        }
        StoreSettings storeSettings = new StoreSettings();
        storeSettings.setId(id);
        return storeSettings;
    }
}