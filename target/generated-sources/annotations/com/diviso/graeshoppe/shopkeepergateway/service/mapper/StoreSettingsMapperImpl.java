package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreSettings;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreSettingsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-06T17:25:34+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class StoreSettingsMapperImpl implements StoreSettingsMapper {

    @Override
    public StoreSettings toEntity(StoreSettingsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        StoreSettings storeSettings = new StoreSettings();

        storeSettings.setDeliveryCharge( dto.getDeliveryCharge() );
        storeSettings.setId( dto.getId() );
        storeSettings.setIsActive( dto.isIsActive() );
        storeSettings.setIsInventoryRequired( dto.isIsInventoryRequired() );
        storeSettings.setOrderAcceptType( dto.getOrderAcceptType() );
        storeSettings.setServiceCharge( dto.getServiceCharge() );

        return storeSettings;
    }

    @Override
    public StoreSettingsDTO toDto(StoreSettings entity) {
        if ( entity == null ) {
            return null;
        }

        StoreSettingsDTO storeSettingsDTO = new StoreSettingsDTO();

        storeSettingsDTO.setDeliveryCharge( entity.getDeliveryCharge() );
        storeSettingsDTO.setId( entity.getId() );
        storeSettingsDTO.setIsActive( entity.isIsActive() );
        storeSettingsDTO.setIsInventoryRequired( entity.isIsInventoryRequired() );
        storeSettingsDTO.setOrderAcceptType( entity.getOrderAcceptType() );
        storeSettingsDTO.setServiceCharge( entity.getServiceCharge() );

        return storeSettingsDTO;
    }

    @Override
    public List<StoreSettings> toEntity(List<StoreSettingsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<StoreSettings> list = new ArrayList<StoreSettings>( dtoList.size() );
        for ( StoreSettingsDTO storeSettingsDTO : dtoList ) {
            list.add( toEntity( storeSettingsDTO ) );
        }

        return list;
    }

    @Override
    public List<StoreSettingsDTO> toDto(List<StoreSettings> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StoreSettingsDTO> list = new ArrayList<StoreSettingsDTO>( entityList.size() );
        for ( StoreSettings storeSettings : entityList ) {
            list.add( toDto( storeSettings ) );
        }

        return list;
    }
}
