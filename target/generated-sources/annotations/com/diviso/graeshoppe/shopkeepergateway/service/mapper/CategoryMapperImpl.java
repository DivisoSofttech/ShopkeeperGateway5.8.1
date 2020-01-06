package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.product.model.Category;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.CategoryDTO;
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
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO toDto(Category entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setDescription( entity.getDescription() );
        categoryDTO.setIDPcode( entity.getIDPcode() );
        categoryDTO.setId( entity.getId() );
        categoryDTO.setImageLink( entity.getImageLink() );
        categoryDTO.setName( entity.getName() );

        return categoryDTO;
    }

    @Override
    public List<Category> toEntity(List<CategoryDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( dtoList.size() );
        for ( CategoryDTO categoryDTO : dtoList ) {
            list.add( toEntity( categoryDTO ) );
        }

        return list;
    }

    @Override
    public List<CategoryDTO> toDto(List<Category> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( entityList.size() );
        for ( Category category : entityList ) {
            list.add( toDto( category ) );
        }

        return list;
    }

    @Override
    public Category toEntity(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setDescription( categoryDTO.getDescription() );
        category.setIDPcode( categoryDTO.getIDPcode() );
        category.setId( categoryDTO.getId() );
        category.setImageLink( categoryDTO.getImageLink() );
        category.setName( categoryDTO.getName() );

        return category;
    }
}
