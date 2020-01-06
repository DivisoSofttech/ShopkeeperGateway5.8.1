package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.product.model.Brand;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.BrandDTO;
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
public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand toEntity(BrandDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setIDPcode( dto.getIDPcode() );
        brand.setId( dto.getId() );
        brand.setName( dto.getName() );

        return brand;
    }

    @Override
    public BrandDTO toDto(Brand entity) {
        if ( entity == null ) {
            return null;
        }

        BrandDTO brandDTO = new BrandDTO();

        brandDTO.setIDPcode( entity.getIDPcode() );
        brandDTO.setId( entity.getId() );
        brandDTO.setName( entity.getName() );

        return brandDTO;
    }

    @Override
    public List<Brand> toEntity(List<BrandDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Brand> list = new ArrayList<Brand>( dtoList.size() );
        for ( BrandDTO brandDTO : dtoList ) {
            list.add( toEntity( brandDTO ) );
        }

        return list;
    }

    @Override
    public List<BrandDTO> toDto(List<Brand> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BrandDTO> list = new ArrayList<BrandDTO>( entityList.size() );
        for ( Brand brand : entityList ) {
            list.add( toDto( brand ) );
        }

        return list;
    }
}
