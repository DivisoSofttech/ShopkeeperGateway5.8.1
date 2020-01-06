package com.diviso.graeshoppe.shopkeepergateway.service.mapper;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.Banner;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.BannerDTO;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.Store;
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
public class BannerMapperImpl implements BannerMapper {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Banner> toEntity(List<BannerDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Banner> list = new ArrayList<Banner>( dtoList.size() );
        for ( BannerDTO bannerDTO : dtoList ) {
            list.add( toEntity( bannerDTO ) );
        }

        return list;
    }

    @Override
    public List<BannerDTO> toDto(List<Banner> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BannerDTO> list = new ArrayList<BannerDTO>( entityList.size() );
        for ( Banner banner : entityList ) {
            list.add( toDto( banner ) );
        }

        return list;
    }

    @Override
    public BannerDTO toDto(Banner banner) {
        if ( banner == null ) {
            return null;
        }

        BannerDTO bannerDTO = new BannerDTO();

        bannerDTO.setStoreId( bannerStoreId( banner ) );
        bannerDTO.setId( banner.getId() );
        bannerDTO.setImageLink( banner.getImageLink() );

        return bannerDTO;
    }

    @Override
    public Banner toEntity(BannerDTO bannerDTO) {
        if ( bannerDTO == null ) {
            return null;
        }

        Banner banner = new Banner();

        banner.setStore( storeMapper.fromId( bannerDTO.getStoreId() ) );
        banner.setId( bannerDTO.getId() );
        banner.setImageLink( bannerDTO.getImageLink() );

        return banner;
    }

    private Long bannerStoreId(Banner banner) {
        if ( banner == null ) {
            return null;
        }
        Store store = banner.getStore();
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
