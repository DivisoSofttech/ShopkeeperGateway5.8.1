package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.product.model.TaxCategory;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.TaxCategoryDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-06T17:25:33+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class TaxCategoryMapperImpl implements TaxCategoryMapper {

    @Override
    public TaxCategoryDTO toDto(TaxCategory entity) {
        if ( entity == null ) {
            return null;
        }

        TaxCategoryDTO taxCategoryDTO = new TaxCategoryDTO();

        taxCategoryDTO.setDescription( entity.getDescription() );
        taxCategoryDTO.setIDPcode( entity.getIDPcode() );
        taxCategoryDTO.setId( entity.getId() );
        taxCategoryDTO.setName( entity.getName() );

        return taxCategoryDTO;
    }

    @Override
    public List<TaxCategory> toEntity(List<TaxCategoryDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TaxCategory> list = new ArrayList<TaxCategory>( dtoList.size() );
        for ( TaxCategoryDTO taxCategoryDTO : dtoList ) {
            list.add( toEntity( taxCategoryDTO ) );
        }

        return list;
    }

    @Override
    public List<TaxCategoryDTO> toDto(List<TaxCategory> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TaxCategoryDTO> list = new ArrayList<TaxCategoryDTO>( entityList.size() );
        for ( TaxCategory taxCategory : entityList ) {
            list.add( toDto( taxCategory ) );
        }

        return list;
    }

    @Override
    public TaxCategory toEntity(TaxCategoryDTO taxCategoryDTO) {
        if ( taxCategoryDTO == null ) {
            return null;
        }

        TaxCategory taxCategory = new TaxCategory();

        taxCategory.setDescription( taxCategoryDTO.getDescription() );
        taxCategory.setIDPcode( taxCategoryDTO.getIDPcode() );
        taxCategory.setId( taxCategoryDTO.getId() );
        taxCategory.setName( taxCategoryDTO.getName() );

        return taxCategory;
    }
}
