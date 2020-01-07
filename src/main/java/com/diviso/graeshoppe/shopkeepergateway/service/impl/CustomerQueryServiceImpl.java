package com.diviso.graeshoppe.shopkeepergateway.service.impl;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.diviso.graeshoppe.shopkeepergateway.client.customer.model.Contact;
import com.diviso.graeshoppe.shopkeepergateway.client.customer.model.ContactDTO;
import com.diviso.graeshoppe.shopkeepergateway.client.customer.model.Customer;
import com.diviso.graeshoppe.shopkeepergateway.client.customer.model.CustomerDTO;
import com.diviso.graeshoppe.shopkeepergateway.service.CustomerQueryService;
import com.diviso.graeshoppe.shopkeepergateway.service.mapper.ContactMapper;
import com.diviso.graeshoppe.shopkeepergateway.service.mapper.CustomerMapper;
import com.diviso.graeshoppe.shopkeepergateway.web.rest.util.ServiceUtility;
/**
 * @author Prince
 *
 */
/**
 * @author Prince
 *
 */
/**
 * @author Prince
 *
 */
@Service
public class CustomerQueryServiceImpl implements CustomerQueryService{
	
	

	private final Logger log = LoggerFactory.getLogger(CustomerQueryServiceImpl.class);
	
	@Autowired
	private RestHighLevelClient restHighLevelClient;
	
	@Autowired
	private ServiceUtility serviceUtility;
	

	@Autowired
	ContactMapper contactMapper;
	 
	@Autowired
	CustomerMapper customerMapper;
	/**
	 * @param name
	 * 
	 */
	@Override
	public Page<Customer> findAllCustomersByName(String name, Pageable pageable) {
		
		QueryBuilder dslQuery = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery())
				.filter(QueryBuilders.termQuery("name.keyword", name));
		
		
		
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(dslQuery);
		SearchResponse searchResponse = serviceUtility.searchResponseForPage("customer", searchSourceBuilder, pageable);

		Page<Customer> page= serviceUtility.getPageResult(searchResponse, pageable, new Customer());

		
		return page;
		
		
	/*	SearchSourceBuilder builder = new SearchSourceBuilder();

		
		 * String[] include = new String[] { "" };
		 * 
		 * String[] exclude = new String[] {};
		 * 
		 * builder.fetchSource(include, exclude);
		 

		builder.query( matchQuery("name", searchTerm) );

		SearchRequest searchRequest = serviceUtility.generateSearchRequest("customer", pageable.getPageSize(), pageable.getPageNumber(),
				builder);

		SearchResponse searchResponse = null;

		try {
			searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) { // TODO Auto-generated
			e.printStackTrace();
		}
		return serviceUtility.getPageResult(searchResponse, pageable, new Customer());*/
	}
	
	/**
	 * @param
	 */
	@Override
	public Page<Customer> findAllCustomers(Pageable pageable) {
		
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(matchAllQuery());
		SearchResponse searchResponse = serviceUtility.searchResponseForPage("customer", searchSourceBuilder, pageable);

		Page<Customer> page= serviceUtility.getPageResult(searchResponse, pageable, new Customer());

		
		return page;
		
		/*SearchSourceBuilder builder = new SearchSourceBuilder();
		
		
		 * String[] include = new String[] { "" };
		 * 
		 * String[] exclude = new String[] {};
		 * 
		 * builder.fetchSource(include, exclude);
		 

		builder.query(matchAllQuery());

		SearchRequest searchRequest = serviceUtility.generateSearchRequest("customer", pageable.getPageSize(), pageable.getPageNumber(),
				builder);

		SearchResponse searchResponse = null;

		try {
			searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) { // TODO Auto-generated
			e.printStackTrace();
		}
		return serviceUtility.getPageResult(searchResponse, pageable, new Customer());*/
	}
	@Override
	public CustomerDTO findCustomerById(Long id) {
		QueryBuilder dslQuery = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery())
				.filter(QueryBuilders.termQuery("id", id));
		
		SearchResponse searchResponse = serviceUtility.searchResponseForObject("customer", dslQuery);
		Customer result=serviceUtility.getObjectResult(searchResponse, new Customer());
		return customerMapper.toDto(result);
		
		
	}
	@Override
	public ContactDTO findContactById( Long id) {

		QueryBuilder dslQuery = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery())
				.filter(QueryBuilders.termQuery("id", id));
		
		SearchResponse searchResponse = serviceUtility.searchResponseForObject("contact", dslQuery);
		Contact result=serviceUtility.getObjectResult(searchResponse, new Contact());
		return contactMapper.toDto(result);
		
		
		
	}
	
}
