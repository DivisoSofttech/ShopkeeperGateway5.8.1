package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.Type;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.TypeDTO;
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
public class TypeMapperImpl implements TypeMapper {

    @Override
    public Type toEntity(TypeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Type type = new Type();

        type.setId( dto.getId() );
        type.setName( dto.getName() );

        return type;
    }

    @Override
    public TypeDTO toDto(Type entity) {
        if ( entity == null ) {
            return null;
        }

        TypeDTO typeDTO = new TypeDTO();

        typeDTO.setId( entity.getId() );
        typeDTO.setName( entity.getName() );

        return typeDTO;
    }

    @Override
    public List<Type> toEntity(List<TypeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Type> list = new ArrayList<Type>( dtoList.size() );
        for ( TypeDTO typeDTO : dtoList ) {
            list.add( toEntity( typeDTO ) );
        }

        return list;
    }

    @Override
    public List<TypeDTO> toDto(List<Type> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TypeDTO> list = new ArrayList<TypeDTO>( entityList.size() );
        for ( Type type : entityList ) {
            list.add( toDto( type ) );
        }

        return list;
    }
}
