package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.product.model.Reason;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.ReasonDTO;
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
public class ReasonMapperImpl implements ReasonMapper {

    @Override
    public Reason toEntity(ReasonDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Reason reason = new Reason();

        reason.setId( dto.getId() );
        reason.setName( dto.getName() );
        reason.setDescription( dto.getDescription() );

        return reason;
    }

    @Override
    public ReasonDTO toDto(Reason entity) {
        if ( entity == null ) {
            return null;
        }

        ReasonDTO reasonDTO = new ReasonDTO();

        reasonDTO.setDescription( entity.getDescription() );
        reasonDTO.iDPcode( entity.getiDPcode() );
        reasonDTO.setId( entity.getId() );
        reasonDTO.setName( entity.getName() );

        return reasonDTO;
    }

    @Override
    public List<Reason> toEntity(List<ReasonDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Reason> list = new ArrayList<Reason>( dtoList.size() );
        for ( ReasonDTO reasonDTO : dtoList ) {
            list.add( toEntity( reasonDTO ) );
        }

        return list;
    }

    @Override
    public List<ReasonDTO> toDto(List<Reason> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ReasonDTO> list = new ArrayList<ReasonDTO>( entityList.size() );
        for ( Reason reason : entityList ) {
            list.add( toDto( reason ) );
        }

        return list;
    }
}
