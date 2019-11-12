package com.diviso.graeshoppe.client.product.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.diviso.graeshoppe.client.product.ProductClientConfiguration;

@FeignClient(name="${product.name}", configuration = ProductClientConfiguration.class)
public interface AddressResourceApiClient extends AddressResourceApi {
}