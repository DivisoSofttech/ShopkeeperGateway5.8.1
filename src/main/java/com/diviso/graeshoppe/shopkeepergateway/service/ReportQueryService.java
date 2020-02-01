package com.diviso.graeshoppe.shopkeepergateway.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.AuxItem;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.ComboItem;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.OfferLine;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.OrderLine;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.OrderMaster;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.ReportSummary;
import com.diviso.graeshoppe.shopkeepergateway.service.dto.PdfDTO;

/*import com.diviso.graeshoppe.client.report.model.OrderLine;
//import com.diviso.graeshoppe.client.order.model.aggregator.OrderLine;
import com.diviso.graeshoppe.client.product.model.UOMDTO;
import com.diviso.graeshoppe.client.report.model.AuxItem;
import com.diviso.graeshoppe.client.report.model.ComboItem;
import com.diviso.graeshoppe.client.report.model.OfferLine;
import com.diviso.graeshoppe.client.report.model.OrderAggregator;
import com.diviso.graeshoppe.client.report.model.OrderMaster;
import com.diviso.graeshoppe.client.report.model.ReportSummary;
import com.diviso.graeshoppe.service.dto.PdfDTO;*/

public interface ReportQueryService {

	
	public OrderMaster findOrderMasterByOrderId(String orderId);
	
	public Page<AuxItem> findAuxItemByOrderLineId(Long orderLineId, Pageable pageable);
	
	public Page<ComboItem> findComboItemByOrderLineId(Long orderLineId,Pageable pageable);
	
	public Page<com.diviso.graeshoppe.shopkeepergateway.client.order.model.aggregator.OrderLine> findOrderLineByOrderMasterId(Long orderMasterId,
			Pageable pageable);
	
	public ResponseEntity<PdfDTO> getAllCategories(String idpcode); 

	public ResponseEntity<PdfDTO> getAllProducts(String idpcode);
	public ResponseEntity<PdfDTO> getCurrentStock(String idpcode);
	
	public ResponseEntity<PdfDTO> getOrderDocket( String orderNumber);
	public PdfDTO getOrderSummary(String fromDate, String toDate);
	public ResponseEntity<ReportSummary> createReportSummary( String date, String storeId);

	public ResponseEntity<List<OrderLine>> findOrderLinesByOrderNumber(String orderId);

	public ResponseEntity<List<OfferLine>> findOfferLineByOrderNumber(String orderId);

	public ResponseEntity<List<AuxItem>> findAuxItemsById(Long id);

	/*
	 * public ResponseEntity<PdfDTO>
	 * getOrderSummaryBetweenDatesAndStoreIdAsPdf(String fromDate, String toDate,
	 * String storeName);
	 */

	public ResponseEntity<PdfDTO> getOrderSummaryDetails(String date,String storeId);

	public ResponseEntity<ReportSummary> getDetailedOrderSummery(String date, String storeId);

	public ResponseEntity<String> createDocketHeader(String orderNumber);

	public ResponseEntity<String> createDocketNumber(String orderNumber);

	public ResponseEntity<String> getProduct(String orderNumber);

	public ResponseEntity<String> getDiscountAndTotal(String orderNumber);

	public ResponseEntity<String> getPaymentStatusForDocket(String orderNumber);

	public ResponseEntity<String> getCustomerOrderDetails(String orderNumber);

	public ResponseEntity<String> getCustomerDetails(String orderNumber);

	public ResponseEntity<String> getAttentionForFirstOrder(String orderNumber);

	public ResponseEntity<String> getFooter(String orderNumber);

	//public ResponseEntity<String> EscPosDocket(String orderNumber);

//	public ResponseEntity<OrderAggregator> getOrderAggregator(String orderNumber);
}
