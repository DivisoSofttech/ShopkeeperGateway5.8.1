package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.PreOrderSettings;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.Store;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreAddress;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreDTO;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreSettings;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-06T17:25:34+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class StoreMapperImpl implements StoreMapper {

    @Autowired
    private StoreAddressMapper storeAddressMapper;
    @Autowired
    private StoreSettingsMapper storeSettingsMapper;
    @Autowired
    private PreOrderSettingsMapper preOrderSettingsMapper;

    @Override
    public List<Store> toEntity(List<StoreDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Store> list = new ArrayList<Store>( dtoList.size() );
        for ( StoreDTO storeDTO : dtoList ) {
            list.add( toEntity( storeDTO ) );
        }

        return list;
    }

    @Override
    public List<StoreDTO> toDto(List<Store> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StoreDTO> list = new ArrayList<StoreDTO>( entityList.size() );
        for ( Store store : entityList ) {
            list.add( toDto( store ) );
        }

        return list;
    }

    @Override
    public StoreDTO toDto(Store store) {
        if ( store == null ) {
            return null;
        }

        StoreDTO storeDTO = new StoreDTO();

        storeDTO.setPreOrderSettingsId( storePreOrderSettingsId( store ) );
        storeDTO.setStoreSettingsId( storeStoreSettingsId( store ) );
        storeDTO.setStoreAddressId( storeStoreAddressId( store ) );
        storeDTO.setClosingTime( store.getClosingTime() );
        storeDTO.setContactNo( store.getContactNo() );
        storeDTO.setEmail( store.getEmail() );
        storeDTO.setId( store.getId() );
        storeDTO.setImageLink( store.getImageLink() );
        storeDTO.setInfo( store.getInfo() );
        storeDTO.setLocation( store.getLocation() );
        storeDTO.setLocationName( store.getLocationName() );
        storeDTO.setMaxDeliveryTime( store.getMaxDeliveryTime() );
        storeDTO.setMinAmount( store.getMinAmount() );
        storeDTO.setName( store.getName() );
        storeDTO.setOpeningTime( store.getOpeningTime() );
        storeDTO.setRegNo( store.getRegNo() );
        storeDTO.setStoreUniqueId( store.getStoreUniqueId() );
        storeDTO.setTotalRating( store.getTotalRating() );

        return storeDTO;
    }

    @Override
    public Store toEntity(StoreDTO storeDTO) {
        if ( storeDTO == null ) {
            return null;
        }

        Store store = new Store();

        store.setStoreSettings( storeSettingsMapper.fromId( storeDTO.getStoreSettingsId() ) );
        store.setStoreAddress( storeAddressMapper.fromId( storeDTO.getStoreAddressId() ) );
        store.setPreOrderSettings( preOrderSettingsMapper.fromId( storeDTO.getPreOrderSettingsId() ) );
        store.setClosingTime( storeDTO.getClosingTime() );
        store.setContactNo( storeDTO.getContactNo() );
        store.setEmail( storeDTO.getEmail() );
        store.setId( storeDTO.getId() );
        store.setImageLink( storeDTO.getImageLink() );
        store.setInfo( storeDTO.getInfo() );
        store.setLocation( storeDTO.getLocation() );
        store.setLocationName( storeDTO.getLocationName() );
        store.setMaxDeliveryTime( storeDTO.getMaxDeliveryTime() );
        store.setMinAmount( storeDTO.getMinAmount() );
        store.setName( storeDTO.getName() );
        store.setOpeningTime( storeDTO.getOpeningTime() );
        store.setRegNo( storeDTO.getRegNo() );
        store.setStoreUniqueId( storeDTO.getStoreUniqueId() );
        store.setTotalRating( storeDTO.getTotalRating() );

        return store;
    }

    private Long storePreOrderSettingsId(Store store) {
        if ( store == null ) {
            return null;
        }
        PreOrderSettings preOrderSettings = store.getPreOrderSettings();
        if ( preOrderSettings == null ) {
            return null;
        }
        Long id = preOrderSettings.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long storeStoreSettingsId(Store store) {
        if ( store == null ) {
            return null;
        }
        StoreSettings storeSettings = store.getStoreSettings();
        if ( storeSettings == null ) {
            return null;
        }
        Long id = storeSettings.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long storeStoreAddressId(Store store) {
        if ( store == null ) {
            return null;
        }
        StoreAddress storeAddress = store.getStoreAddress();
        if ( storeAddress == null ) {
            return null;
        }
        Long id = storeAddress.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
