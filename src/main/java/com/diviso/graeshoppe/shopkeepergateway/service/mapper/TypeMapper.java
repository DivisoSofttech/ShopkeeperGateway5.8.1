package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import org.mapstruct.*;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.Type;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.TypeDTO;



/**
 * Mapper for the entity Type and its DTO TypeDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TypeMapper extends EntityMapper<TypeDTO, Type> {



    default Type fromId(Long id) {
        if (id == null) {
            return null;
        }
        Type type = new Type();
        type.setId(id);
        return type;
    }
}
