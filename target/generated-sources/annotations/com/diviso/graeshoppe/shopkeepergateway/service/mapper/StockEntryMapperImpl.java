package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.product.model.Location;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.Reason;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.StockEntry;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.StockEntryDTO;
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
public class StockEntryMapperImpl implements StockEntryMapper {

    @Autowired
    private ReasonMapper reasonMapper;
    @Autowired
    private LocationMapper locationMapper;

    @Override
    public List<StockEntry> toEntity(List<StockEntryDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<StockEntry> list = new ArrayList<StockEntry>( dtoList.size() );
        for ( StockEntryDTO stockEntryDTO : dtoList ) {
            list.add( toEntity( stockEntryDTO ) );
        }

        return list;
    }

    @Override
    public List<StockEntryDTO> toDto(List<StockEntry> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StockEntryDTO> list = new ArrayList<StockEntryDTO>( entityList.size() );
        for ( StockEntry stockEntry : entityList ) {
            list.add( toDto( stockEntry ) );
        }

        return list;
    }

    @Override
    public StockEntryDTO toDto(StockEntry stockEntry) {
        if ( stockEntry == null ) {
            return null;
        }

        StockEntryDTO stockEntryDTO = new StockEntryDTO();

        stockEntryDTO.setReasonId( stockEntryReasonId( stockEntry ) );
        stockEntryDTO.setLocationId( stockEntryLocationId( stockEntry ) );
        stockEntryDTO.setDate( stockEntry.getDate() );
        stockEntryDTO.setDescription( stockEntry.getDescription() );
        stockEntryDTO.iDPcode( stockEntry.getiDPcode() );
        stockEntryDTO.setId( stockEntry.getId() );
        stockEntryDTO.setReference( stockEntry.getReference() );

        return stockEntryDTO;
    }

    @Override
    public StockEntry toEntity(StockEntryDTO stockEntryDTO) {
        if ( stockEntryDTO == null ) {
            return null;
        }

        StockEntry stockEntry = new StockEntry();

        stockEntry.setReason( reasonMapper.fromId( stockEntryDTO.getReasonId() ) );
        stockEntry.setLocation( locationMapper.fromId( stockEntryDTO.getLocationId() ) );
        stockEntry.setId( stockEntryDTO.getId() );
        stockEntry.setReference( stockEntryDTO.getReference() );
        stockEntry.setDate( stockEntryDTO.getDate() );
        stockEntry.setDescription( stockEntryDTO.getDescription() );

        return stockEntry;
    }

    private Long stockEntryReasonId(StockEntry stockEntry) {
        if ( stockEntry == null ) {
            return null;
        }
        Reason reason = stockEntry.getReason();
        if ( reason == null ) {
            return null;
        }
        Long id = reason.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long stockEntryLocationId(StockEntry stockEntry) {
        if ( stockEntry == null ) {
            return null;
        }
        Location location = stockEntry.getLocation();
        if ( location == null ) {
            return null;
        }
        Long id = location.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
