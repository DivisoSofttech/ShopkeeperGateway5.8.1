package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import org.mapstruct.*;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.PreOrderSettings;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.PreOrderSettingsDTO;
/**
 * Mapper for the entity PreOrderSettings and its DTO PreOrderSettingsDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PreOrderSettingsMapper extends EntityMapper<PreOrderSettingsDTO, PreOrderSettings> {

    PreOrderSettingsDTO toDto(PreOrderSettings preOrderSettings);


    PreOrderSettings toEntity(PreOrderSettingsDTO preOrderSettingsDTO);

    default PreOrderSettings fromId(Long id) {
        if (id == null) {
            return null;
        }
        PreOrderSettings preOrderSettings = new PreOrderSettings();
        preOrderSettings.setId(id);
        return preOrderSettings;
    }
}
