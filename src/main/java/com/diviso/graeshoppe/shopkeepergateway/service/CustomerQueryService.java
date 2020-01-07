package com.diviso.graeshoppe.shopkeepergateway.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.diviso.graeshoppe.shopkeepergateway.client.customer.model.ContactDTO;
import com.diviso.graeshoppe.shopkeepergateway.client.customer.model.Customer;
import com.diviso.graeshoppe.shopkeepergateway.client.customer.model.CustomerDTO;



public interface CustomerQueryService {
	
	public Page<Customer> findAllCustomers(Pageable pageable);


	public Page<Customer> findAllCustomersByName(String name, Pageable pageable);

	public CustomerDTO findCustomerById(Long id);
	
	public ContactDTO findContactById( Long id) ;
}
