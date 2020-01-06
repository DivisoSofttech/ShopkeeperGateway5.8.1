package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.diviso.graeshoppe.shopkeepergateway.client.product.model.ComboLineItem;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.ComboLineItemDTO;

/**
 * Mapper for the entity ComboLineItem and its DTO ComboLineItemDTO.
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ComboLineItemMapper extends EntityMapper<ComboLineItemDTO, ComboLineItem> {

    @Override
	@Mapping(source = "product.id", target = "productId")
    @Mapping(source = "comboItem.id", target = "comboItemId")
    ComboLineItemDTO toDto(ComboLineItem comboLineItem);

    @Override
	@Mapping(source = "productId", target = "product")
    @Mapping(source = "comboItemId", target = "comboItem")
    ComboLineItem toEntity(ComboLineItemDTO comboLineItemDTO);

    default ComboLineItem fromId(Long id) {
        if (id == null) {
            return null;
        }
        ComboLineItem comboLineItem = new ComboLineItem();
        comboLineItem.setId(id);
        return comboLineItem;
    }
}