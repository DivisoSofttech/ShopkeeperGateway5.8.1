package com.diviso.graeshoppe.shopkeepergateway.client.order;

import com.diviso.graeshoppe.shopkeepergateway.client.ExcludeFromComponentScan;
import com.diviso.graeshoppe.shopkeepergateway.client.TokenRelayRequestInterceptor;
import com.diviso.graeshoppe.shopkeepergateway.security.oauth2.AuthorizationHeaderUtil;

import feign.RequestInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponentScan
@EnableConfigurationProperties
public class OrderClientConfiguration {
	
}
