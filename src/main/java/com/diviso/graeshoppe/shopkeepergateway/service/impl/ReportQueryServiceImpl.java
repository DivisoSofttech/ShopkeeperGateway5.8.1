package com.diviso.graeshoppe.shopkeepergateway.service.impl;

import static org.elasticsearch.index.query.QueryBuilders.termQuery;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.Resource;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.diviso.graeshoppe.shopkeepergateway.client.product.api.CategoryResourceApi;
import com.diviso.graeshoppe.shopkeepergateway.client.product.api.ProductResourceApi;
import com.diviso.graeshoppe.shopkeepergateway.client.product.api.StockCurrentResourceApi;
import com.diviso.graeshoppe.shopkeepergateway.client.report.api.QueryResourceApi;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.AuxItem;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.ComboItem;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.OfferLine;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.OrderMaster;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.ReportSummary;
import com.diviso.graeshoppe.shopkeepergateway.service.ReportQueryService;
import com.diviso.graeshoppe.shopkeepergateway.service.dto.PdfDTO;
import com.diviso.graeshoppe.shopkeepergateway.web.rest.util.ServiceUtility;

//import com.diviso.graeshoppe.client.order.model.aggregator.OrderLine;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.OrderLine;

/**
 * 
 * @author Prince
 *
 */
@Service
public class ReportQueryServiceImpl implements ReportQueryService {

	private final Logger log = LoggerFactory.getLogger(ReportQueryServiceImpl.class);

	@Autowired
	private ServiceUtility serviceUtility;

	private RestHighLevelClient restHighLevelClient;
	@Autowired
	CategoryResourceApi categoryResourceApi;
	@Autowired
	ProductResourceApi productResourceApi;
	@Autowired
	StockCurrentResourceApi stockCurrentResourceApi;

	@Autowired
	QueryResourceApi queryResourceApi;
	
	/*
	 * @Autowired
	 * 
	 * @Qualifier(value="queResourceApi")
	 */
	/*
	 * @Autowired com.diviso.graeshoppe.clQueryResourceApi queResourceApi;
	 */

	public ReportQueryServiceImpl(RestHighLevelClient restHighLevelClient) {

		this.restHighLevelClient = restHighLevelClient;
	}

	/**
	 * @param orderId
	 */
	@Override
	public OrderMaster findOrderMasterByOrderId(String orderId) {

		SearchSourceBuilder builder = new SearchSourceBuilder();

		/*
		 * String[] include = new String[] { "" };
		 * 
		 * String[] exclude = new String[] {};
		 * 
		 * builder.fetchSource(include, exclude);
		 */

		builder.query(termQuery("orderNumber.keyword", orderId));

		SearchRequest searchRequest = new SearchRequest("ordermaster");

		searchRequest.source(builder);
		SearchResponse searchResponse = null;

		try {
			searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) { // TODO Auto-generated
			e.printStackTrace();
		}

		return serviceUtility.getObjectResult(searchResponse, new OrderMaster());

	}

	/**
	 * @param orderLineId
	 * @param pageable
	 */
	@Override
	public Page<AuxItem> findAuxItemByOrderLineId(Long orderLineId, Pageable pageable) {
		log.debug("<<<<<<<<<<<<<< findAuxItemByOrderLineId >>>>>>>>>{}",orderLineId);
		QueryBuilder dslBuilder = QueryBuilders.boolQuery()
				.must(QueryBuilders.matchAllQuery()).filter(QueryBuilders.termQuery("orderline.id", orderLineId));
		SearchSourceBuilder builder = new SearchSourceBuilder();
		SearchResponse response = serviceUtility.searchResponseForPage("auxitem", builder, pageable);
		return serviceUtility.getPageResult(response, pageable, new AuxItem());

	}

	/**
	 * @param orderLineId
	 */
	@Override
	public Page<ComboItem> findComboItemByOrderLineId(Long orderLineId, Pageable pageable) {
		log.debug("<<<<<<<<<<<<< findComboItemByOrderLineId >>>>>>>>>{}",orderLineId);
		QueryBuilder dslBuilder = QueryBuilders.boolQuery()
				.must(QueryBuilders.matchAllQuery()).filter(QueryBuilders.termQuery("orderline.id", orderLineId));
		SearchSourceBuilder builder = new SearchSourceBuilder();
		SearchResponse response = serviceUtility.searchResponseForPage("comboitem", builder, pageable);
		return serviceUtility.getPageResult(response, pageable, new ComboItem());

	}

	/**
	 * @param orderMasterId
	 */
	/*
	 * @Override public Page<com.diviso.graeshoppe.client.report.model.OrderLine>
	 * findOrderLineByOrderMasterId(Long orderMasterId, Pageable pageable) {
	 * 
	 * 
	 * SearchSourceBuilder builder = new SearchSourceBuilder();
	 * 
	 * 
	 * String[] include = new String[] { "" };
	 * 
	 * String[] exclude = new String[] {};
	 * 
	 * builder.fetchSource(include, exclude);
	 * 
	 * 
	 * builder.query(termQuery("orderMaster.id", orderMasterId));
	 * 
	 * SearchRequest searchRequest =
	 * serviceUtility.generateSearchRequest("comboitem", pageable.getPageSize(),
	 * pageable.getPageNumber(), builder);
	 * 
	 * SearchResponse searchResponse = null;
	 * 
	 * try { searchResponse = restHighLevelClient.search(searchRequest,
	 * RequestOptions.DEFAULT); } catch (IOException e) { // TODO Auto-generated
	 * e.printStackTrace(); }
	 * 
	 * return serviceUtility.getPageResult(searchResponse, pageable, new
	 * com.diviso.graeshoppe.client.report.model.OrderLine());
	 * 
	 * 
	 * }
	 */
	@Override
	public ResponseEntity<PdfDTO> getAllCategories(String idpcode) {
		PdfDTO pdf = new PdfDTO();
		pdf.setPdf(this.categoryResourceApi.exportCategoryListAsPdfUsingGET(idpcode).getBody());
		pdf.setContentType("application/pdf");
		return ResponseEntity.ok().body(pdf);
	}

	@Override
	public ResponseEntity<PdfDTO> getAllProducts(String idpcode) {
		PdfDTO pdf = new PdfDTO();
		pdf.setPdf(this.productResourceApi.exportProductListAsPdfUsingGET(idpcode).getBody());
		pdf.setContentType("application/pdf");
		return ResponseEntity.ok().body(pdf);
	}

	@Override
	public ResponseEntity<PdfDTO> getCurrentStock(String idpcode) {
		PdfDTO pdf = new PdfDTO();
		pdf.setPdf(this.stockCurrentResourceApi.exportStockCurrentListAsPdfUsingGET(idpcode).getBody());
		pdf.setContentType("application/pdf");
		return ResponseEntity.ok().body(pdf);
	}



	@Override
	public ResponseEntity<PdfDTO> getOrderDocket(String orderNumber) {
		PdfDTO pdf = new PdfDTO();
		pdf.setPdf(this.queryResourceApi.getReportWithAuxAndComboAsPdfUsingGET(orderNumber).getBody());
		pdf.setContentType("application/pdf");
		return ResponseEntity.ok().body(pdf);
	}

	@Override
	public PdfDTO getOrderSummary(String date, String storeId) {
		PdfDTO pdf = new PdfDTO();
		pdf.setPdf(this.queryResourceApi.getOrderSummaryByDateAndStoreNameAsPdfUsingGET(date, storeId).getBody());
		pdf.setContentType("application/pdf");
		return pdf;
	}

	/*
	 * @Override public ResponseEntity<ReportSummary> createReportSummary(String
	 * fromDate,String toDate, String storeName) {
	 * log.debug("< <<<<<<<<<createReportSummary >>>>>>{}{}{}",fromDate,storeName,
	 * toDate);
	 * 
	 * return queryResourceApi.createReportSummaryUsingGET(fromDate, toDate,
	 * storeName); }
	 */

	/*
	 * @Override public ResponseEntity<OrderAggregator> getOrderAggregator(String
	 * orderNumber) {
	 * 
	 * return queryResourceApi.getOrderAggregatorUsingGET(orderNumber); }
	 */
	@Override
	public Page<com.diviso.graeshoppe.shopkeepergateway.client.order.model.aggregator.OrderLine> findOrderLineByOrderMasterId(Long orderMasterId, Pageable pageable) {
		QueryBuilder queryBuilder = QueryBuilders.termQuery("ordermaster.id", orderMasterId);
		SearchSourceBuilder builder = new SearchSourceBuilder();
		builder.query(queryBuilder);
		SearchResponse response = serviceUtility.searchResponseForPage("comboitem", builder, pageable);
		// please check indexname(entity class name)may be change please change
		// searchResponsePage 'indexname
		// and getPageresult classname
		return serviceUtility.getPageResult(response, pageable, new OrderLine());
	}

	@Override
	public ResponseEntity<List<OrderLine>> findOrderLinesByOrderNumber(String orderId) {
		log.debug("<<<<<<<< findOrderLinesByOrderNumber >>>>>>{}", orderId);
		return queryResourceApi.findOrderLineByOrderNumberUsingGET(orderId);
	}

	@Override
	public ResponseEntity<List<OfferLine>> findOfferLineByOrderNumber(String orderId) {
		log.debug("<<<<< findOfferLineByOrderNumber >>>>>>>>{}",orderId);
		return queryResourceApi.findOfferLinesByOrderNumberUsingGET(orderId);
	}

	@Override
	public ResponseEntity<List<AuxItem>> findAuxItemsById(Long id) {
		log.debug("<<<<<<<findAuxItemsById >>>>>>>{}",id);
		return queryResourceApi.findAuxItemByidUsingGET(id);
	}

	@Override
	public ResponseEntity<ReportSummary> createReportSummary(String date, String storeId) {
		log.debug("<<<<<<<<<<< createReportSummary >>>>>>{}{}",date,storeId);
		return queryResourceApi.createReportSummaryUsingGET(date, storeId);
	}

	/*
	 * @Override public ResponseEntity<PdfDTO>
	 * getOrderSummaryBetweenDatesAndStoreIdAsPdf(String fromDate, String toDate,
	 * String storeName) {
	 * log.debug("<<<<<<<<<< getOrderSummaryBetweenDatesAndStoreIdAsPdf>>>>>{}{}{}"
	 * ,fromDate,storeName,toDate); PdfDTO pdfDto= new PdfDTO();
	 * pdfDto.setPdf(queryResourceApi.getOrderSummaryBetweenDatesAsPdfUsingGET(
	 * fromDate, storeName, toDate).getBody()); return
	 * ResponseEntity.ok().body(pdfDto); }
	 */

	@Override
	public ResponseEntity<PdfDTO> getOrderSummaryDetails(String date,String storeId) {
	
		PdfDTO pdf = new PdfDTO();
		pdf.setPdf(this.queryResourceApi.getDetailedOrderSummaryAsPdfUsingGET(date, storeId).getBody());
		pdf.setContentType("application/pdf");
		return ResponseEntity.ok().body(pdf);
	}

	@Override
	public ResponseEntity<ReportSummary> getDetailedOrderSummery(String date, String storeId) {
		log.debug("<<<<<<<<<< getDetailedOrderSummery >>>>>>>>{}{}",date,storeId);
		return null;//ResponseEntity.ok().body(queryResourceApi.getDetailedOrderSummaryAsPdfUsingGET(date, storeId));
	}

	@Override
	public ResponseEntity<String> createDocketHeader(String orderNumber) {
		log.debug("<<<<<<<<<createDocketHeader >>>>>>>>>{}",orderNumber);
		return queryResourceApi.createDocketHeaderViewUsingGET(orderNumber);
	}

	@Override
	public ResponseEntity<String> createDocketNumber(String orderNumber) {
		log.debug("<<<<<<<  createDocketNumber >>>>>>>{}",orderNumber);
		return queryResourceApi.createDocketContentUsingGET(orderNumber);
	}

}
