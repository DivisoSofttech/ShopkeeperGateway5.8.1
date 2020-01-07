package com.diviso.graeshoppe.shopkeepergateway.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.Banner;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.BannerDTO;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.Store;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreBundleDTO;
import com.diviso.graeshoppe.shopkeepergateway.client.store.model.StoreDTO;


public interface StoreQueryService {
	

	
	public Store findStoreByRegNo(String regNo);
	
	
	/**
	 * @param regNo
	 * @return
	 */
	public Page<Banner> findBannersByStoreId(String regNo,Pageable pageable );

	
	public StoreDTO findStoreDTOByRegNo( String regNo);
	
	public ResponseEntity<StoreBundleDTO> getStoreBundle(String regNo);
	public /*ResponseEntity<BannerDTO> */BannerDTO findBanner(Long id) ;
	

}
