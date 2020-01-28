package com.diviso.graeshoppe.shopkeepergateway.web.rest;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.diviso.graeshoppe.shopkeepergateway.client.order.model.aggregator.OrderLine;


import com.diviso.graeshoppe.shopkeepergateway.client.order.api.OrderQueryResourceApi;

import com.diviso.graeshoppe.shopkeepergateway.client.order.model.aggregator.AuxilaryOrderLine;
import com.diviso.graeshoppe.shopkeepergateway.client.order.model.aggregator.Notification;
import com.diviso.graeshoppe.shopkeepergateway.client.order.model.aggregator.Offer;
import com.diviso.graeshoppe.shopkeepergateway.client.order.model.aggregator.Order;
import com.diviso.graeshoppe.shopkeepergateway.client.product.model.*;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.*;

import com.diviso.graeshoppe.shopkeepergateway.client.store.model.*;

import com.diviso.graeshoppe.shopkeepergateway.service.CustomerQueryService;
import com.diviso.graeshoppe.shopkeepergateway.service.OfferQueryService;
import com.diviso.graeshoppe.shopkeepergateway.service.OrderQueryService;
import com.diviso.graeshoppe.shopkeepergateway.service.ProductQueryService;
import com.diviso.graeshoppe.shopkeepergateway.service.ReportQueryService;
import com.diviso.graeshoppe.shopkeepergateway.service.StoreQueryService;
import com.diviso.graeshoppe.shopkeepergateway.service.dto.PdfDTO;
import com.diviso.graeshoppe.shopkeepergateway.client.customer.model.ContactDTO;
import com.diviso.graeshoppe.shopkeepergateway.client.customer.model.Customer;
import com.diviso.graeshoppe.shopkeepergateway.client.customer.model.CustomerDTO;

@RestController
@RequestMapping("/api/query")
public class QueryResource {

	@Autowired
	OfferQueryService offerQueryService;

	@Autowired
	OrderQueryService orderQueryService;

	@Autowired
	ProductQueryService productQueryService;

	@Autowired
	CustomerQueryService customerQueryService;

	@Autowired
	StoreQueryService storeQueryService;

	@Autowired
	ReportQueryService reportQueryService;

	

	@Autowired
	private OrderQueryResourceApi orderQueryResourceApi;


	private final Logger log = LoggerFactory.getLogger(QueryResource.class);

	/**************************
	 * Customer related End Points**********************
	 * 
	 * /**
	 * 
	 * @param name
	 * @param pageable
	 * @return
	 */
	@GetMapping("/findAllCustomersByName/{name}") // 26 11 19 its working
	public Page<Customer> findAllCustomersByName(@PathVariable String name, Pageable pageable) {
		log.debug("<<<<<<<< findAllCustomer by name >>>>>>>>>>", name);
		return customerQueryService.findAllCustomersByName(name, pageable);
	}

	@GetMapping("/findAllCustomers") // 26 11 19 its working
	Page<Customer> findAllCustomers(Pageable pageable) {
		log.debug("<<<<<<<<<< findAllCustomers >>>>>>>>>>");
		return customerQueryService.findAllCustomers(pageable);
	}

	@GetMapping("/findCustomerById/{id}") // 06 12 19 it's working
	public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable Long id) {
		CustomerDTO result = customerQueryService.findCustomerById(id);
		return ResponseEntity.ok().body(result);
		/*
		 * log.debug("<<<<<<<<< findCustomerById >>>>>>>>", id); return
		 * customerQueryService.findCustomerById(id);
		 */
	}

	@GetMapping("/findContactById/{id}") // 6 12 19 it's working
	public ResponseEntity<ContactDTO> findContactById(@PathVariable Long id) {
		ContactDTO result = customerQueryService.findContactById(id);
		return ResponseEntity.ok().body(result);
	}

	/*
	 * @GetMapping("/contact/{mobileNumber}") // 6 12 19 it,s working public
	 * List<Contact> findContacts(@PathVariable Long mobileNumber, Pageable page) {
	 * log.debug("<<<<<<<<<< findContacts >>>>>>>", mobileNumber);
	 * 
	 * return contactService.findContactsByMobileNumber(mobileNumber,page);
	 */
	/*
	 * SearchSourceBuilder ssb = new SearchSourceBuilder();
	 * ssb.query(termQuery("mobileNumber", mobileNumber)); SearchRequest sr =
	 * su.generateSearchRequest("contact", page.getPageSize(), page.getPageNumber(),
	 * ssb);
	 * 
	 * SearchResponse searchResponse = null;
	 * 
	 * try { rhlc.search(sr, RequestOptions.DEFAULT); } catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * return su.getPageResult(searchResponse, page, new Contact());
	 */

	// }

	/**
	 * 
	 * @return
	 * @deprecated
	 */
	@Deprecated
	@GetMapping("/customers/export") // not working
	public ResponseEntity<PdfDTO> exportCustomers() {
		PdfDTO pdf = new PdfDTO();
		// pdf.setPdf(this.customerResourceApi.getPdfAllCustomersUsingGET().getBody());
		pdf.setContentType("application/pdf");
		return ResponseEntity.ok().body(pdf);
	}

	// ******************************************Product Related end
	// points**********************

	/**
	 * @author Prince
	 * @param searchTerm
	 * @param storeId
	 * @param pageable
	 * @return page of orders
	 * 
	 * @description getting all products in page as input a name and storeId
	 */

	@GetMapping("/findAllProductByNameAndStoreId/{name}/{storeId}") // 26 11 19 it,s working
	public Page<Product> findAllProductByNameAndStoreId(@PathVariable String name, @PathVariable String storeId,
			Pageable pageable) {
		return productQueryService.findAllProductByNameAndIdpCode(name, storeId, pageable);
	}

	/**
	 * 
	 * @param iDPcode
	 * @param pageable
	 * @return products page
	 * 
	 * @description getting all products in page as input an idpcode
	 */
	@GetMapping("/findAllProductsByIdpCode/{idpCode}") // 26 11 19 it,s working
	public Page<Product> findAllProductsByIdpCode(@PathVariable String idpCode, Pageable pageable) {
		return productQueryService.findAllProductsByIdpCode(idpCode, pageable);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * 
	 * @description find a product as input an id
	 */

	@GetMapping("/findProductDTOById/{id}") // its working
	public ResponseEntity<ProductDTO> findProductDTOById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productQueryService.findProductDTOById(id));
	}

	/**
	 * 
	 * @param storeId
	 * @param pageable
	 * @return category page
	 * 
	 * @description findAll categories by storeId
	 */
	// findAllCategories
	@GetMapping("/findAllCategoriesByIdpCode/{idpCode}") // 6 12 19 it's working
	public ResponseEntity<Page<Category>> findAllCategoriesByIdpCode(@PathVariable String idpCode, Pageable pageable) {

		return ResponseEntity.ok().body(productQueryService.findAllCategoriesByIdpCode(idpCode, pageable));

	}

	/**
	 * 
	 * @param name
	 * @param storeId
	 * @param pageable
	 * @return category page
	 * 
	 * @description getting all category details as input a name and storeid
	 */
	@GetMapping("/findAllCategoriesByNameAndIdpCode/{name}/{idpCode}") // it's working
	public Page<Category> findAllCategoriesByNameAndIdpCode(@PathVariable String name, @PathVariable String idpCode,
			Pageable pageable) {
		log.debug("<<<<<<<<<<<< findAllCategoryByNameAndIdpCode >>>>>>>>>>>>", name, idpCode);
		return productQueryService.findAllCategoriesByNameAndIdpCode(name, idpCode, pageable);
	}

	/**
	 * 
	 * @param iDPcode
	 * @param pageable
	 * @return category list
	 * 
	 * @description findAll categories without image as input a idpcode
	 */
	// findAllCategorywithoutImage
	@GetMapping("/findAllCategoryDTOsByIdpCode/{idpCode}") // it's working
	public ResponseEntity<Page<CategoryDTO>> findAllCategoryDTOsByIdpCode(@PathVariable String idpCode,
			Pageable pageable) {
		return ResponseEntity.ok().body(productQueryService.findAllCategoryDTOsByIdpCode(idpCode, pageable));
	}

	@GetMapping("/findAllEntryLineItemsByIdpCode/{idpCode}") // no data
	public ResponseEntity<List<EntryLineItem>> findAllEntryLineItemsByIdpCode(@PathVariable String idpCode,
			Pageable pageable) {
		log.debug("<<<<<<<<<< findAllEntryLineItems >>>>>>>>>>", idpCode);
		return ResponseEntity.ok()
				.body(this.productQueryService.findAllEntryLineItemsByIdpCode(idpCode, pageable).getContent());
	}

	/**
	 * 
	 * @param storeId
	 * @param pageable
	 * @return stockEntry page
	 * 
	 * @description getting all stock entry as input a storeId
	 */
	@GetMapping("/findAllStockEntriesByIdpCode/{idpCode}") // no data
	public ResponseEntity<Page<StockEntry>> findAllStockEntriesByIdpcode(@PathVariable String idpCode,
			Pageable pageable) {
		log.debug("<<<<<< findAllStockEntries >>>>>>>>>", idpCode);
		return ResponseEntity.ok().body(productQueryService.findAllStockEntriesbyIdpCode(idpCode, pageable));
	}

	/**
	 * 
	 * @param id
	 * @return stock entry object
	 * 
	 * @description find one stock entries
	 */

	@GetMapping("/findStockEntryById/{id}") // not tested
	public ResponseEntity<StockEntryDTO> findStockEntryById(Long id) {

		return ResponseEntity.ok().body(productQueryService.findStockEntryDTOById(id));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getProductBundle/{id}") // its working
	public ResponseEntity<ProductBundle> getProductBundleById(@PathVariable Long id) {

		return ResponseEntity.ok().body(productQueryService.getProductBundleById(id));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getStockEntryBundleById/{id}") // not tested getStockEntryBundle
	public ResponseEntity<StockEntryBundle> getStockEntryBundleById(@PathVariable Long id) {

		return ResponseEntity.ok().body(productQueryService.getStockEntryBundleById(id));
	}

	/**
	 * 
	 * @param iDPcode
	 * @param pageable
	 * @return
	 */
	@GetMapping("/getAuxilaryLineItemsByIdpCode/{idpCode}") // its working
	public ResponseEntity<Page<AuxilaryLineItem>> getAuxilaryLineItemsByIdpCode(@PathVariable String idpCode,
			Pageable pageable) {
		log.debug("<<<<<<<<<<<< getAuxilaryLineItemsByStoreId >>>>>>>>>", idpCode);
		return ResponseEntity.ok().body(productQueryService.findAuxilaryLineItemsByIDPcode(idpCode, pageable));

	}

	/**
	 * 
	 * @param iDPcode
	 * @param pageable
	 * @return
	 */
	@GetMapping("/findUOMByIdpCode/{idpCode}") // 7 12 19 it's working
	public ResponseEntity<Page<UOM>> findUOMByIdpCode(@PathVariable String idpCode, Pageable pageable) {
		return ResponseEntity.ok().body(productQueryService.findUOMByIDPcode(idpCode, pageable));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findUOMById/{id}") // its working
	public ResponseEntity<UOMDTO> findUOMDTOById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productQueryService.findUOMDTOById(id));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findCategoryDTOById/{id}") // its working findCategory change findCategoryById
	public ResponseEntity<CategoryDTO> findCategoryDTOById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productQueryService.findCategoryDTOById(id));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findAuxilaryLineItemById/{id}") // its working
	public ResponseEntity<AuxilaryLineItemDTO> findAuxilaryLineItemById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productQueryService.findAuxilaryLineItemById(id));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findCombolineItemById/{id}") // its working
	public ResponseEntity<ComboLineItemDTO> findCombolineItemById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productQueryService.findCombolineItemById(id));
	}

	/**
	 * 
	 * @param iDPcode
	 * @param pageable
	 * @return
	 */
	@GetMapping("/getNotAuxNotComboProductsByIDPcode/{iDPcode}") // 26 11 19 it's working
	public ResponseEntity<Page<Product>> getNotAuxNotComboProductsByIDPcode(@PathVariable String iDPcode,
			Pageable pageable) {

		return ResponseEntity.ok().body(productQueryService.findNotAuxNotComboProductsByIDPcode(iDPcode, pageable));

	}

	/**
	 * 
	 * @param storeId
	 * @return
	 */
	@GetMapping("/auxilary-products/{storeId}") // 26 11 19 it's working
	public ResponseEntity<Page<Product>> getAllAuxilaryProduct(@PathVariable String storeId, Pageable pageable) {
		return ResponseEntity.ok().body(productQueryService.findAllAuxilaryProducts(storeId, pageable));

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findProductById/{id}") // 26 11 19 it's working
	public ResponseEntity<Product> findProductById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productQueryService.findProductById(id));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/categorybyid/{id}") // 26 11 19 it's working
	public ResponseEntity<Category> findCategoryById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productQueryService.findCategoryById(id));
	}

	/**
	 * 
	 * @param idpcode
	 * @param pageable
	 * @return
	 */
	@GetMapping("/location/{idpcode}") // not working
	public Page<Location> findLocationByRegNo(@PathVariable String idpcode, Pageable pageable) {
		return this.productQueryService.findLocationByIdpcode(idpcode, pageable);
	}

	/**
	 * 
	 * @param idpcode
	 * @param pageable
	 * @return
	 * 
	 * @document
	 */

	@GetMapping("/reason/{idpcode}") // not working
	public Page<Reason> findReasonByRegNo(@PathVariable String idpcode, Pageable pageable) {
		return this.productQueryService.findReasonByIdpcode(idpcode, pageable);
	}

	/**
	 * 
	 * @param id
	 * @param pageable
	 * @return
	 * 
	 * @document
	 */
	@GetMapping("/findallentrylineitems/{id}") // no data
	public Page<EntryLineItem> findAllEntryLineItemsByStockEntryId(@PathVariable String id, Pageable pageable) {

		return productQueryService.findAllEntryLineItemsByStockEntryId(id, pageable);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/uombyid/{id}") // 26 11 19 it's working
	public ResponseEntity<UOM> findUOMById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productQueryService.findUOMById(id));
	}


	// *****************Store related End Points***********************

	@GetMapping("/stores/{regNo}") // 07 12 19 it's working
	public Store findStoreByRegNo(@PathVariable String regNo) {
		return this.storeQueryService.findStoreByRegNo(regNo);
	}

	@GetMapping("/storeDTO/{regNo}") // it's working
	public StoreDTO findStoreDTOByRegNo(@PathVariable String regNo) {

		return storeQueryService.findStoreDTOByRegNo(regNo);
	}

	/**
	 * 
	 * @param regNo
	 * @param page
	 * @param size
	 * @param sort
	 * @return
	 */
	@GetMapping("/getStoreBundle/{regNo}") // its working
	public ResponseEntity<StoreBundleDTO> getStoreBundle(@PathVariable String regNo) {

		return storeQueryService.getStoreBundle(regNo);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/banner/{id}") // its working
	public ResponseEntity<BannerDTO> findBanner(@PathVariable Long id) {
		BannerDTO bannerDTO = storeQueryService.findBanner(id);
		return ResponseEntity.ok().body(bannerDTO);
	}

	// ADD Pageable for return page
	/**
	 * 
	 * @param storeId
	 * @return
	 */
	@GetMapping("/store-banners/{storeId}") // 26 11 19 its working
	public ResponseEntity<Page<Banner>> findBannerByStoreId(@PathVariable String storeId, Pageable pageable) {
		return ResponseEntity.ok().body(storeQueryService.findBannersByStoreId(storeId, pageable));
	}

	// *****************************Report related End Points**********************

	/**
	 * @deprecated
	 * @param assignee
	 * @param assigneeLike
	 * @param candidateGroup
	 * @param candidateGroups
	 * @param candidateUser
	 * @param createdAfter
	 * @param createdBefore
	 * @param createdOn
	 * @param name
	 * @param nameLike
	 * @return
	 */
	/*
	 * @GetMapping("/opentasks") public ResponseEntity<List<OpenTask>>
	 * getOpenTasks(@RequestParam(required = false) String assignee,
	 * 
	 * @RequestParam(required = false) String assigneeLike, @RequestParam(required =
	 * false) String candidateGroup,
	 * 
	 * @RequestParam(required = false) String candidateGroups,
	 * 
	 * @RequestParam(required = false) String candidateUser, @RequestParam(required
	 * = false) String createdAfter,
	 * 
	 * @RequestParam(required = false) String createdBefore, @RequestParam(required
	 * = false) String createdOn,
	 * 
	 * @RequestParam(required = false) String name, @RequestParam(required = false)
	 * String nameLike) { return orderQueryResourceApi.getTasksUsingGET(assignee,
	 * assigneeLike, candidateGroup, candidateGroups, candidateUser, createdAfter,
	 * createdBefore, createdOn, name, nameLike); }
	 */

	/**
	 * 
	 * @param orderLineId
	 * @param pageable
	 * @return
	 */
	@GetMapping("/findAuxItemByOrderLineId/{orderLineId}") // it's working
	public ResponseEntity<Page<AuxItem>> findAuxItemByOrderLineId(@PathVariable Long orderLineId, Pageable pageable) {
		Page<AuxItem> auxItem = reportQueryService.findAuxItemByOrderLineId(orderLineId, pageable);
		return ResponseEntity.ok().body(auxItem);
	}

	/**
	 * 
	 * @param orderLineId
	 * @param pageable
	 * @return
	 */
	@GetMapping("/findComboItemByOrderLineId/{orderLineId}") // 26 11 19 no data in databazse Not tested
	public ResponseEntity<Page<ComboItem>> findComboItemByOrderLineId(@PathVariable Long orderLineId,
			Pageable pageable) {
		Page<ComboItem> comboItem = reportQueryService.findComboItemByOrderLineId(orderLineId, pageable);
		return ResponseEntity.ok().body(comboItem);
	}

	/**
	 * 
	 * @param orderId
	 * @return
	 */
	@GetMapping("/orderMasterByOrderId/{orderId}") // 26 11 19 it's working
	public ResponseEntity<OrderMaster> findOrderMasterByOrderId(@PathVariable String orderId) {
		OrderMaster orderMaster = reportQueryService.findOrderMasterByOrderId(orderId);
		return ResponseEntity.ok().body(orderMaster);
	}

	/**
	 * 
	 * @param orderMasterId
	 * @param pageable
	 * @return
	 */
	@GetMapping("/orderLineByOrderMasterId/{orderMasterId}") // not tested no data in database
	public ResponseEntity<Page<OrderLine>> findOrderLineByOrderMasterId(@PathVariable Long orderMasterId,
			Pageable pageable) {
		Page<OrderLine> orderLine = reportQueryService.findOrderLineByOrderMasterId(orderMasterId, pageable);
		return ResponseEntity.ok().body(orderLine);
	}

	/**
	 * 
	 * @param orderNumber
	 * @return
	 */
	@GetMapping("/getOrderDocket/{orderNumber}") // its working
	public ResponseEntity<PdfDTO> getOrderDocket(@PathVariable String orderNumber) {

		return reportQueryService.getOrderDocket(orderNumber);
	}

	/**
	 * 
	 * @param orderNumber
	 * @return
	 */


	/**
	 * 
	 * @param date
	 * @param storeId
	 * @return
	 */
	@GetMapping("/ordersummary/{date}/{storeName}") // its working
	public PdfDTO getOrderSummary(@PathVariable String date, @PathVariable String storeName) {
		return reportQueryService.getOrderSummary(date, storeName);
	}

	/**
	 * 
	 * @param expectedDelivery
	 * @param storeName
	 * @return
	 */
	@GetMapping("/ordersummaryview/{date}/{storeId}") // its working
	public ResponseEntity<ReportSummary> createReportSummary(@PathVariable String date,@PathVariable String storeId) {
		log.debug("<<<<<<<<< createReportSummary >>>>>>>{}>",date,storeId);
		return reportQueryService.createReportSummary(date,storeId);
	}

	/**
	 * 
	 * @param idpcode
	 * @return
	 * 
	 * @document getting allproducts as pdf for input a idpcode
	 */
	@GetMapping("/report/getAllProductsByIdpCode/{idpcode}") // its working
	public ResponseEntity<PdfDTO> getAllProductsByIdpCode(@PathVariable String idpcode) {
		return reportQueryService.getAllProducts(idpcode);
	}

	/**
	 * 
	 * @param idpcode
	 * @return
	 * 
	 * @document getallcategories by idpcode
	 */
	@GetMapping("/report/getAllCategoriesByIdpCode/{idpcode}") // its working
	public ResponseEntity<PdfDTO> getAllCategoriesByIdpCode(@PathVariable String idpcode) {
		return reportQueryService.getAllCategories(idpcode);
	}

	/**
	 * 
	 * @param idpcode
	 * @return pdf details for
	 * 
	 * @document return a details from sockcurrentdetails
	 */
	@GetMapping("/report/getCurrentStockByIdpCode/{idpcode}") // its working
	public ResponseEntity<PdfDTO> getCurrentStockByIdpCode(@PathVariable String idpcode) {
		return reportQueryService.getCurrentStock(idpcode);

	}
	/*
	 * @GetMapping("/orderaggregator/{orderNumber}") public
	 * ResponseEntity<com.diviso.graeshoppe.client.report.model.OrderAggregator>
	 * getOrderAggregator(@PathVariable String orderNumber) { return
	 * reportQueryService.getOrderAggregator(orderNumber); }
	 */

	// ***********************Order related end Points*************************
	/**
	 * 
	 * @param assignee
	 * @param assigneeLike
	 * @param candidateGroup
	 * @param candidateGroups
	 * @param candidateUser
	 * @param createdAfter
	 * @param createdBefore
	 * @param createdOn
	 * @param name
	 * @param nameLike
	 * @return
	 */

	/*
	 * @GetMapping("/tasks") public ResponseEntity<List<Order>>
	 * getTasks(@RequestParam(required = false) String assignee,
	 * 
	 * @RequestParam(required = false) String assigneeLike, @RequestParam(required =
	 * false) String candidateGroup,
	 * 
	 * @RequestParam(required = false) String candidateGroups,
	 * 
	 * @RequestParam(required = false) String candidateUser, @RequestParam(required
	 * = false) String createdAfter,
	 * 
	 * @RequestParam(required = false) String createdBefore, @RequestParam(required
	 * = false) String createdOn,
	 * 
	 * @RequestParam(required = false) String name, @RequestParam(required = false)
	 * String nameLike) { List<OpenTask> openTasks =
	 * orderQueryResourceApi.getTasksUsingGET(assignee, assigneeLike,
	 * candidateGroup, candidateGroups, candidateUser, createdAfter, createdBefore,
	 * createdOn, name, nameLike).getBody();
	 * 
	 * log.info("...........openTasks...................." + openTasks); List<Order>
	 * orders = new ArrayList<Order>();
	 * 
	 * openTasks.forEach(opentask -> {
	 * 
	 * orders.add(orderQueryService.findOrderByOrderId(opentask.getOrderId()));
	 * 
	 * }); return ResponseEntity.ok().body(orders); }
	 */
	/**
	 * 
	 * @param taskName
	 * @param orderId
	 * @param storeId
	 * @return getTaskDetails
	 * 
	 * @description input a taskName ,orderId and storeId to get a task details
	 */

	/*
	 * @GetMapping("/getTaskDetails/{taskName}/{orderId}/{storeId}") public
	 * ResponseEntity<OpenTask> getTaskDetails(@PathVariable String
	 * taskName, @PathVariable String orderId,
	 * 
	 * @PathVariable String storeId) { return
	 * orderQueryService.getTaskDetails(taskName, orderId, storeId);
	 * 
	 * }
	 */

	/**
	 * @author Prince
	 * @param statusName
	 * @param storeId
	 * @param deliveryType
	 * @param pageable
	 * @return page of orders
	 * 
	 * @description if you input statusName,storeId and deliveryType to get Orders
	 *              in page
	 */
	// findOrderByStatusName
	@GetMapping("/findOrderByStatusNameAndStoreIdAndDeliveryType/{statusName}/{storeId}/{deliveryType}") // 27 11 19 //
																											// it's //
																											// working
	public Page<Order> findOrderByStatusNameAndStoreIdAndDeliveryType(@PathVariable String statusName,
			@PathVariable String storeId, @PathVariable String deliveryType, Pageable pageable) {
		return orderQueryService.findOrderByStatusNameAndStoreIdAndDeliveryType(statusName, storeId, deliveryType,
				pageable);
	}

	@GetMapping("orderCountByCustomerIdAndStoreId/{customerId}/{storeId}") // 07 12 19 it,s working
	public Long orderCountByCustomerIdAndStoreId(@PathVariable String customerId, @PathVariable String storeId) {
		log.debug("<<<<<<<<<<< OrderCount >>>>>>>>>>{}", customerId, storeId);
		return orderQueryService.orderCountByCustomerIdAndStoreId(customerId, storeId);

	}

	/**
	 * 
	 * @param orderId
	 * @return
	 */
	@GetMapping("/orderByOrderId/{orderId}") // 26 11 19 it's working
	public ResponseEntity<Order> findOrderByOrderId(@PathVariable String orderId) {
		Order order = orderQueryService.findOrderByOrderId(orderId);
		return ResponseEntity.ok().body(order);
	}

	/**
	 * 
	 * @param storeId
	 * @param pageable
	 * @return
	 */
	@GetMapping("/findOrderLineByStoreId/{storeId}") // 26 11 19 its working
	public Page<Order> findOrderLineByStoreId(@PathVariable String storeId, Pageable pageable) {
		log.debug("<<<<<<<< findOrderLineByStoreId >>>>>>>>>>{}", storeId);
		return orderQueryService.findOrderByStoreId(storeId, pageable);

	}

	/**
	 * 
	 * @param receiverId
	 * @param pageable
	 * @return
	 */
	@GetMapping("/notification/{receiverId}") // working
	public ResponseEntity<Page<Notification>> findNotificationByReceiverId(@PathVariable String receiverId,
			Pageable pageable) {
		return ResponseEntity.ok().body(orderQueryService.findNotificationByReceiverId(receiverId, pageable));

	}

	/**
	 * 
	 * @param status
	 * @param receiverId
	 * @return
	 */
	@GetMapping("/notification/{status}/{receiverId}") // working
	public Long getNotificationCountByReceiveridAndStatus(@PathVariable String status,
			@PathVariable String receiverId) {

		return orderQueryService.getNotificationCountByReceiveridAndStatus(status, receiverId);
	}

	/**
	 * 
	 * @param receiverId
	 * @param status
	 * @return
	 * 
	 * @document findnotification count
	 */
	@GetMapping("/findNotificationCountByReceiverIdAndStatusName/{receiverId}/{status}") // working
	Long findNotificationCountByReceiverIdAndStatusName(String receiverId, String status) {
		return orderQueryService.getNotificationCountByReceiveridAndStatus(receiverId, status);
	}

	@GetMapping("/findAllOrderLinesByOrderId/{orderId}")
	public Page<OrderLine> findAllOrderLinesByOrderId(@PathVariable Long orderId, Pageable pageable) {
		log.debug("<<<<<<<<<findAllOrderLinesByOrderId >>>>>>>>>>>{}", orderId);
		Page<OrderLine> page = orderQueryService.findAllOrderLinesByOrderId(orderId, pageable);
		return page;
	}

	@GetMapping("/findAuxilaryOrderLineByOrderLineId/{orderLineId}")
	public Page<AuxilaryOrderLine> findAuxilaryOrderLineByOrderLineId(@PathVariable Long orderLineId,
			Pageable pageable) {
		log.debug("<<<<<<<<findAuxilaryOrderLineByOrderLineId >>>>>>>>>>", orderLineId);
		return orderQueryService.findAuxilaryOrderLineByOrderLineId(orderLineId, pageable);
	}

	// ***********************Offer related end points**********************
	@GetMapping("/findOfferLinesByOrderId/{orderId}")
	public List<Offer> findOfferLinesByOrderId(@PathVariable Long orderId) {
		return offerQueryService.findOfferLinesByOrderId(orderId);
	}

	@GetMapping("/findOrderLinesByOrderNumber/{orderId}")
	public ResponseEntity<List<com.diviso.graeshoppe.shopkeepergateway.client.report.model.OrderLine>> findOrderLinesByOrderNumber(@PathVariable String orderId) {
		log.debug("<<<<<<<<< findOrderLinesByOrderNumber >>>>>>>{}", orderId);
		return reportQueryService.findOrderLinesByOrderNumber(orderId);

	}
	@GetMapping("/findOfferLinesByOrderNumber/{orderId}")
	public ResponseEntity<List<OfferLine>> findOfferLinesByOrderNumber(@PathVariable String orderId){
		log.debug("<<<<<<<<<findOfferLineByOrderNumber {} ",orderId);
		return reportQueryService.findOfferLineByOrderNumber(orderId);
		
	}
	@GetMapping("/findAuxItemsbyId/{id}")
	public ResponseEntity<List<AuxItem>> findAuxItemsById(@PathVariable Long id){
		log.debug("<<<<<<<<<< findAuxItem >>>>>>>",id);
		return reportQueryService.findAuxItemsById(id);
		
	}
	@GetMapping("/getOrderSummaryBetweenDatesAsPdf/{fromDate}/{toDate}/{storeId}")
	public ResponseEntity<PdfDTO> getOrderSummaryBetweenDatesAndStoreIdAsPdf(@PathVariable String fromDate,@PathVariable String toDate,@RequestParam (value="storeName")String storeId){
		log.debug("<<<<<<<<<< getOrderSummaryBetweenDatesAndStoreIdAsPdf >>>>>{}{}{}",fromDate,toDate,storeId,storeId);
		return reportQueryService.getOrderSummaryBetweenDatesAndStoreIdAsPdf(fromDate,toDate,storeId);
		
	}
	@GetMapping("/getDetailedOrderSummeryAsPdf/{date}/{storeId}")
	public ResponseEntity<PdfDTO> getOrderSummaryDetails(@PathVariable String date,@PathVariable String storeId){
		log.debug("<<<<<< getOrderSummaryDetails >>>>>>>>>",date);
		return reportQueryService.getOrderSummaryDetails(date,storeId);
	}
	@GetMapping("/getDetailedOrderSummery/{date}/{storeId}")
	public ResponseEntity<ReportSummary> getDetailedOrderSummery(@PathVariable String date,@PathVariable String storeId){
		log.debug("<<<<<< getOrderSummaryDetails >>>>>>>>>",date);
		return reportQueryService.getDetailedOrderSummery(date,storeId);
	}


}
