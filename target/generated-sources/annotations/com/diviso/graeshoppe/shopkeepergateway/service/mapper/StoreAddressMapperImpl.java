package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreAddress;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreAddressDTO;
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
public class StoreAddressMapperImpl implements StoreAddressMapper {

    @Override
    public StoreAddress toEntity(StoreAddressDTO dto) {
        if ( dto == null ) {
            return null;
        }

        StoreAddress storeAddress = new StoreAddress();

        storeAddress.setAddressType( dto.getAddressType() );
        storeAddress.setCity( dto.getCity() );
        storeAddress.setHouseNoOrBuildingName( dto.getHouseNoOrBuildingName() );
        storeAddress.setId( dto.getId() );
        storeAddress.setLandmark( dto.getLandmark() );
        storeAddress.setPincode( dto.getPincode() );
        storeAddress.setRoadNameAreaOrStreet( dto.getRoadNameAreaOrStreet() );
        storeAddress.setState( dto.getState() );

        return storeAddress;
    }

    @Override
    public StoreAddressDTO toDto(StoreAddress entity) {
        if ( entity == null ) {
            return null;
        }

        StoreAddressDTO storeAddressDTO = new StoreAddressDTO();

        storeAddressDTO.setAddressType( entity.getAddressType() );
        storeAddressDTO.setCity( entity.getCity() );
        storeAddressDTO.setHouseNoOrBuildingName( entity.getHouseNoOrBuildingName() );
        storeAddressDTO.setId( entity.getId() );
        storeAddressDTO.setLandmark( entity.getLandmark() );
        storeAddressDTO.setPincode( entity.getPincode() );
        storeAddressDTO.setRoadNameAreaOrStreet( entity.getRoadNameAreaOrStreet() );
        storeAddressDTO.setState( entity.getState() );

        return storeAddressDTO;
    }

    @Override
    public List<StoreAddress> toEntity(List<StoreAddressDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<StoreAddress> list = new ArrayList<StoreAddress>( dtoList.size() );
        for ( StoreAddressDTO storeAddressDTO : dtoList ) {
            list.add( toEntity( storeAddressDTO ) );
        }

        return list;
    }

    @Override
    public List<StoreAddressDTO> toDto(List<StoreAddress> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StoreAddressDTO> list = new ArrayList<StoreAddressDTO>( entityList.size() );
        for ( StoreAddress storeAddress : entityList ) {
            list.add( toDto( storeAddress ) );
        }

        return list;
    }
}
