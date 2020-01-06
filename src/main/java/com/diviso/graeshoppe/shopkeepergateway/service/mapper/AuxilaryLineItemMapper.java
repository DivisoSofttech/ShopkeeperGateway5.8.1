package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import org.mapstruct.*;


import com.diviso.graeshoppe.shopkeepergateway.client.product.model.AuxilaryLineItem;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.AuxilaryLineItemDTO;

/**
 * Mapper for the entity AuxilaryLineItem and its DTO AuxilaryLineItemDTO.
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface AuxilaryLineItemMapper extends EntityMapper<AuxilaryLineItemDTO, AuxilaryLineItem> {

    @Override
	@Mapping(source = "product.id", target = "productId")
    @Mapping(source = "auxilaryItem.id", target = "auxilaryItemId")
    AuxilaryLineItemDTO toDto(AuxilaryLineItem auxilaryLineItem);

    @Override
	@Mapping(source = "productId", target = "product")
    @Mapping(source = "auxilaryItemId", target = "auxilaryItem")
    AuxilaryLineItem toEntity(AuxilaryLineItemDTO auxilaryLineItemDTO);

    default AuxilaryLineItem fromId(Long id) {
        if (id == null) {
            return null;
        }
        AuxilaryLineItem auxilaryLineItem = new AuxilaryLineItem();
        auxilaryLineItem.setId(id);
        return auxilaryLineItem;
    }
}