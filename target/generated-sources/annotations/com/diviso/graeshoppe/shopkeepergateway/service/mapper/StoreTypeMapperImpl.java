package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.Store;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreType;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreTypeDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-06T17:25:32+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class StoreTypeMapperImpl implements StoreTypeMapper {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<StoreType> toEntity(List<StoreTypeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<StoreType> list = new ArrayList<StoreType>( dtoList.size() );
        for ( StoreTypeDTO storeTypeDTO : dtoList ) {
            list.add( toEntity( storeTypeDTO ) );
        }

        return list;
    }

    @Override
    public List<StoreTypeDTO> toDto(List<StoreType> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StoreTypeDTO> list = new ArrayList<StoreTypeDTO>( entityList.size() );
        for ( StoreType storeType : entityList ) {
            list.add( toDto( storeType ) );
        }

        return list;
    }

    @Override
    public StoreTypeDTO toDto(StoreType storeType) {
        if ( storeType == null ) {
            return null;
        }

        StoreTypeDTO storeTypeDTO = new StoreTypeDTO();

        storeTypeDTO.setStoreId( storeTypeStoreId( storeType ) );
        storeTypeDTO.setId( storeType.getId() );
        storeTypeDTO.setName( storeType.getName() );

        return storeTypeDTO;
    }

    @Override
    public StoreType toEntity(StoreTypeDTO storeTypeDTO) {
        if ( storeTypeDTO == null ) {
            return null;
        }

        StoreType storeType = new StoreType();

        storeType.setStore( storeMapper.fromId( storeTypeDTO.getStoreId() ) );
        storeType.setId( storeTypeDTO.getId() );
        storeType.setName( storeTypeDTO.getName() );

        return storeType;
    }

    private Long storeTypeStoreId(StoreType storeType) {
        if ( storeType == null ) {
            return null;
        }
        Store store = storeType.getStore();
        if ( store == null ) {
            return null;
        }
        Long id = store.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
