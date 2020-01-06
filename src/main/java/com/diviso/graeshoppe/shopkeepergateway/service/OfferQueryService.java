package com.diviso.graeshoppe.shopkeepergateway.service;

import java.util.List;

import com.diviso.graeshoppe.shopkeepergateway.client.order.model.aggregator.Offer;





public interface OfferQueryService {

	List<Offer> findOfferLinesByOrderId(Long orderId);

}
