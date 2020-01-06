package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import org.mapstruct.Mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.customer.model.Contact;
import com.diviso.graeshoppe.shopkeepergateway.client.customer.model.ContactDTO;

/**
 * Mapper for the entity Contact and its DTO ContactDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ContactMapper extends EntityMapper<ContactDTO, Contact> {



    default Contact fromId(Long id) {
        if (id == null) {
            return null;
        }
        Contact contact = new Contact();
        contact.setId(id);
        return contact;
    }
}