package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import org.mapstruct.*;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.Store;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreDTO;
@Mapper(componentModel = "spring", uses = {StoreAddressMapper.class, StoreSettingsMapper.class, PreOrderSettingsMapper.class})
public interface StoreMapper extends EntityMapper<StoreDTO, Store> {

    @Override
	@Mapping(source = "storeAddress.id", target = "storeAddressId")
    @Mapping(source = "storeSettings.id", target = "storeSettingsId")
    @Mapping(source = "preOrderSettings.id", target = "preOrderSettingsId")
    StoreDTO toDto(Store store);

    @Override
	@Mapping(source = "storeAddressId", target = "storeAddress")
    @Mapping(source = "storeSettingsId", target = "storeSettings")
    @Mapping(source = "preOrderSettingsId", target = "preOrderSettings")
    @Mapping(target = "storeTypes", ignore = true)

    @Mapping(target = "banners", ignore = true)
    @Mapping(target = "deliveryInfos", ignore = true)
    @Mapping(target = "userRatingReviews", ignore = true)
    Store toEntity(StoreDTO storeDTO);

    default Store fromId(Long id) {
        if (id == null) {
            return null;
        }
        Store store = new Store();
        store.setId(id);
        return store;
    }
}