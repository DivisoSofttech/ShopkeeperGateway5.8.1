package com.diviso.graeshoppe.client.product.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.diviso.graeshoppe.client.product.ProductClientConfiguration;

@FeignClient(name="product",  configuration = ProductClientConfiguration.class)
public interface ProductResourceApiClient extends ProductResourceApi {
}	