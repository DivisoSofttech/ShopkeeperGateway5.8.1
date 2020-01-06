package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.PreOrderSettings;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.PreOrderSettingsDTO;
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
public class PreOrderSettingsMapperImpl implements PreOrderSettingsMapper {

    @Override
    public List<PreOrderSettings> toEntity(List<PreOrderSettingsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<PreOrderSettings> list = new ArrayList<PreOrderSettings>( dtoList.size() );
        for ( PreOrderSettingsDTO preOrderSettingsDTO : dtoList ) {
            list.add( toEntity( preOrderSettingsDTO ) );
        }

        return list;
    }

    @Override
    public List<PreOrderSettingsDTO> toDto(List<PreOrderSettings> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PreOrderSettingsDTO> list = new ArrayList<PreOrderSettingsDTO>( entityList.size() );
        for ( PreOrderSettings preOrderSettings : entityList ) {
            list.add( toDto( preOrderSettings ) );
        }

        return list;
    }

    @Override
    public PreOrderSettingsDTO toDto(PreOrderSettings preOrderSettings) {
        if ( preOrderSettings == null ) {
            return null;
        }

        PreOrderSettingsDTO preOrderSettingsDTO = new PreOrderSettingsDTO();

        preOrderSettingsDTO.setFromTime( preOrderSettings.getFromTime() );
        preOrderSettingsDTO.setId( preOrderSettings.getId() );
        preOrderSettingsDTO.setIsPreOrderAvailable( preOrderSettings.isIsPreOrderAvailable() );
        preOrderSettingsDTO.setToTime( preOrderSettings.getToTime() );

        return preOrderSettingsDTO;
    }

    @Override
    public PreOrderSettings toEntity(PreOrderSettingsDTO preOrderSettingsDTO) {
        if ( preOrderSettingsDTO == null ) {
            return null;
        }

        PreOrderSettings preOrderSettings = new PreOrderSettings();

        preOrderSettings.setFromTime( preOrderSettingsDTO.getFromTime() );
        preOrderSettings.setId( preOrderSettingsDTO.getId() );
        preOrderSettings.setIsPreOrderAvailable( preOrderSettingsDTO.isIsPreOrderAvailable() );
        preOrderSettings.setToTime( preOrderSettingsDTO.getToTime() );

        return preOrderSettings;
    }
}
