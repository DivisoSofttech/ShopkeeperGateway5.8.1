package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.DeliveryInfo;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.DeliveryInfoDTO;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.Store;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.Type;
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
public class DeliveryInfoMapperImpl implements DeliveryInfoMapper {

    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<DeliveryInfo> toEntity(List<DeliveryInfoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DeliveryInfo> list = new ArrayList<DeliveryInfo>( dtoList.size() );
        for ( DeliveryInfoDTO deliveryInfoDTO : dtoList ) {
            list.add( toEntity( deliveryInfoDTO ) );
        }

        return list;
    }

    @Override
    public List<DeliveryInfoDTO> toDto(List<DeliveryInfo> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DeliveryInfoDTO> list = new ArrayList<DeliveryInfoDTO>( entityList.size() );
        for ( DeliveryInfo deliveryInfo : entityList ) {
            list.add( toDto( deliveryInfo ) );
        }

        return list;
    }

    @Override
    public DeliveryInfoDTO toDto(DeliveryInfo deliveryInfo) {
        if ( deliveryInfo == null ) {
            return null;
        }

        DeliveryInfoDTO deliveryInfoDTO = new DeliveryInfoDTO();

        deliveryInfoDTO.setStoreId( deliveryInfoStoreId( deliveryInfo ) );
        deliveryInfoDTO.setTypeId( deliveryInfoTypeId( deliveryInfo ) );
        deliveryInfoDTO.setEndTime( deliveryInfo.getEndTime() );
        deliveryInfoDTO.setId( deliveryInfo.getId() );
        deliveryInfoDTO.setStartingTime( deliveryInfo.getStartingTime() );

        return deliveryInfoDTO;
    }

    @Override
    public DeliveryInfo toEntity(DeliveryInfoDTO deliveryInfoDTO) {
        if ( deliveryInfoDTO == null ) {
            return null;
        }

        DeliveryInfo deliveryInfo = new DeliveryInfo();

        deliveryInfo.setType( typeMapper.fromId( deliveryInfoDTO.getTypeId() ) );
        deliveryInfo.setStore( storeMapper.fromId( deliveryInfoDTO.getStoreId() ) );
        deliveryInfo.setEndTime( deliveryInfoDTO.getEndTime() );
        deliveryInfo.setId( deliveryInfoDTO.getId() );
        deliveryInfo.setStartingTime( deliveryInfoDTO.getStartingTime() );

        return deliveryInfo;
    }

    private Long deliveryInfoStoreId(DeliveryInfo deliveryInfo) {
        if ( deliveryInfo == null ) {
            return null;
        }
        Store store = deliveryInfo.getStore();
        if ( store == null ) {
            return null;
        }
        Long id = store.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long deliveryInfoTypeId(DeliveryInfo deliveryInfo) {
        if ( deliveryInfo == null ) {
            return null;
        }
        Type type = deliveryInfo.getType();
        if ( type == null ) {
            return null;
        }
        Long id = type.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
