/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.diviso.graeshoppe.shopkeepergateway.client.report.api;

import com.diviso.graeshoppe.shopkeepergateway.client.report.model.AuxItem;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.CancellationSummary;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.EscPosDocket;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.OfferLine;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.OrderLine;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.OrderMasterDTO;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.PageOfOrderMaster;
import com.diviso.graeshoppe.shopkeepergateway.client.report.model.ReportSummary;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-02-10T13:29:41.284+05:30[Asia/Kolkata]")

@Api(value = "QueryResource", description = "the QueryResource API")
public interface QueryResourceApi {

    @ApiOperation(value = "createCancellationReportSummaryView", nickname = "createCancellationReportSummaryViewUsingGET", notes = "", response = CancellationSummary.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CancellationSummary.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/cancellationReportview/{date}/{storeName}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<CancellationSummary> createCancellationReportSummaryViewUsingGET(@ApiParam(value = "date",required=true) @PathVariable("date") String date,@ApiParam(value = "storeName",required=true) @PathVariable("storeName") String storeName);


    @ApiOperation(value = "createDetailedReportSummaryView", nickname = "createDetailedReportSummaryViewUsingGET", notes = "", response = ReportSummary.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ReportSummary.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/detailedReportview/{fromDate}/{toDate}/{storeName}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<ReportSummary> createDetailedReportSummaryViewUsingGET(@ApiParam(value = "fromDate",required=true) @PathVariable("fromDate") String fromDate,@ApiParam(value = "storeName",required=true) @PathVariable("storeName") String storeName,@ApiParam(value = "toDate",required=true) @PathVariable("toDate") String toDate);


    @ApiOperation(value = "createReportSummary", nickname = "createReportSummaryUsingGET", notes = "", response = ReportSummary.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ReportSummary.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/reportview/{date}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<ReportSummary> createReportSummaryUsingGET(@ApiParam(value = "date",required=true) @PathVariable("date") String date,@ApiParam(value = "storeName") @Valid @RequestParam(value = "storeName", required = false) String storeName);


    @ApiOperation(value = "findAll", nickname = "findAllUsingGET", notes = "", response = EscPosDocket.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = EscPosDocket.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/allEscDocket",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<EscPosDocket> findAllUsingGET();


    @ApiOperation(value = "findAuxItemByid", nickname = "findAuxItemByidUsingGET", notes = "", response = AuxItem.class, responseContainer = "List", tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AuxItem.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/findAuxItemByid/{id}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<AuxItem>> findAuxItemByidUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "findGrandTotalBetweenAndStoreName", nickname = "findGrandTotalBetweenAndStoreNameUsingGET", notes = "", response = Double.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Double.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/grandTotalOfAStore/{fromDate}/{toDate}/{storeName}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Double> findGrandTotalBetweenAndStoreNameUsingGET(@ApiParam(value = "fromDate",required=true) @PathVariable("fromDate") String fromDate,@ApiParam(value = "storeName",required=true) @PathVariable("storeName") String storeName,@ApiParam(value = "toDate",required=true) @PathVariable("toDate") String toDate);


    @ApiOperation(value = "findOfferLinesByOrderNumber", nickname = "findOfferLinesByOrderNumberUsingGET", notes = "", response = OfferLine.class, responseContainer = "List", tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = OfferLine.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/findOfferLinesByOrderNumber/{orderId}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<OfferLine>> findOfferLinesByOrderNumberUsingGET(@ApiParam(value = "orderId",required=true) @PathVariable("orderId") String orderId);


    @ApiOperation(value = "findOrderByDatebetweenAndStoreId", nickname = "findOrderByDatebetweenAndStoreIdUsingGET", notes = "", response = PageOfOrderMaster.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PageOfOrderMaster.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/findOrderByDatebetweenAndStoreId/{from}/{to}/{storeId}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<PageOfOrderMaster> findOrderByDatebetweenAndStoreIdUsingGET(@ApiParam(value = "from",required=true) @PathVariable("from") String from,@ApiParam(value = "storeId",required=true) @PathVariable("storeId") String storeId,@ApiParam(value = "to",required=true) @PathVariable("to") String to,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "findOrderCountByDateAndStatusName", nickname = "findOrderCountByDateAndStatusNameUsingGET", notes = "", response = Long.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Long.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/findOrderCountByDateAndStatusName/{date}/{statusName}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Long> findOrderCountByDateAndStatusNameUsingGET(@ApiParam(value = "date",required=true) @PathVariable("date") String date,@ApiParam(value = "statusName",required=true) @PathVariable("statusName") String statusName);


    @ApiOperation(value = "findOrderCountByStatusName", nickname = "findOrderCountByStatusNameUsingGET", notes = "", response = Long.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Long.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/findOrderCountByStatusName/{statusName}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Long> findOrderCountByStatusNameUsingGET(@ApiParam(value = "statusName",required=true) @PathVariable("statusName") String statusName);


    @ApiOperation(value = "findOrderLineByOrderNumber", nickname = "findOrderLineByOrderNumberUsingGET", notes = "", response = OrderLine.class, responseContainer = "List", tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = OrderLine.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/findOrderLinesByOrderNumber/{orderNumber}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<OrderLine>> findOrderLineByOrderNumberUsingGET(@ApiParam(value = "orderNumber",required=true) @PathVariable("orderNumber") String orderNumber);


    @ApiOperation(value = "findOrderMasterByExpectedDeliveryBetween", nickname = "findOrderMasterByExpectedDeliveryBetweenUsingGET", notes = "", response = PageOfOrderMaster.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PageOfOrderMaster.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/findOrderMasterByExpectedDeliveryBetween/{from}/{to}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<PageOfOrderMaster> findOrderMasterByExpectedDeliveryBetweenUsingGET(@ApiParam(value = "from",required=true) @PathVariable("from") String from,@ApiParam(value = "to",required=true) @PathVariable("to") String to,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "findOrderMasterByOrderNumber", nickname = "findOrderMasterByOrderNumberUsingGET", notes = "", response = OrderMasterDTO.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = OrderMasterDTO.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/findOrderMasterByOrderNumber/{orderNumber}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<OrderMasterDTO> findOrderMasterByOrderNumberUsingGET(@ApiParam(value = "orderNumber",required=true) @PathVariable("orderNumber") String orderNumber);


    @ApiOperation(value = "findOrderMasterCountByExpectedDeliveryBetween", nickname = "findOrderMasterCountByExpectedDeliveryBetweenUsingGET", notes = "", response = Long.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Long.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/countOrderMasterByDeliveryBetween/{from}/{to}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Long> findOrderMasterCountByExpectedDeliveryBetweenUsingGET(@ApiParam(value = "from",required=true) @PathVariable("from") String from,@ApiParam(value = "to",required=true) @PathVariable("to") String to);


    @ApiOperation(value = "findWeakOrderCount", nickname = "findWeakOrderCountUsingGET", notes = "", response = Long.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Long.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/findWeakOrderCount/{date}/{statusName}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Long> findWeakOrderCountUsingGET(@ApiParam(value = "date",required=true) @PathVariable("date") String date,@ApiParam(value = "statusName",required=true) @PathVariable("statusName") String statusName);


    @ApiOperation(value = "getAttentionForOrder", nickname = "getAttentionForOrderUsingGET", notes = "", response = String.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/docketAttentionForOrder/{orderNumber}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<String> getAttentionForOrderUsingGET(@ApiParam(value = "orderNumber",required=true) @PathVariable("orderNumber") String orderNumber);


    @ApiOperation(value = "getCancellationSummaryAsPdf", nickname = "getCancellationSummaryAsPdfUsingGET", notes = "", response = byte[].class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = byte[].class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/cancellationSummary/{date}/{storeName}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<byte[]> getCancellationSummaryAsPdfUsingGET(@ApiParam(value = "date",required=true) @PathVariable("date") String date,@ApiParam(value = "storeName",required=true) @PathVariable("storeName") String storeName);


    @ApiOperation(value = "getCustomerDetails", nickname = "getCustomerDetailsUsingGET", notes = "", response = String.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/docketCustomerDetails/{orderNumber}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<String> getCustomerDetailsUsingGET(@ApiParam(value = "orderNumber",required=true) @PathVariable("orderNumber") String orderNumber);


    @ApiOperation(value = "getCustomerOrderDetails", nickname = "getCustomerOrderDetailsUsingGET", notes = "", response = String.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/docketCustomerOrder/{orderNumber}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<String> getCustomerOrderDetailsUsingGET(@ApiParam(value = "orderNumber",required=true) @PathVariable("orderNumber") String orderNumber);


    @ApiOperation(value = "getDetailedOrderSummaryAsPdf", nickname = "getDetailedOrderSummaryAsPdfUsingGET", notes = "", response = byte[].class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = byte[].class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/detailedOrderSummary/{date}/{storeName}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<byte[]> getDetailedOrderSummaryAsPdfUsingGET(@ApiParam(value = "date",required=true) @PathVariable("date") String date,@ApiParam(value = "storeName",required=true) @PathVariable("storeName") String storeName);


    @ApiOperation(value = "getDocketContent", nickname = "getDocketContentUsingGET", notes = "", response = String.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/docketContent/{orderNumber}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<String> getDocketContentUsingGET(@ApiParam(value = "orderNumber",required=true) @PathVariable("orderNumber") String orderNumber);


    @ApiOperation(value = "getDocketDiscountAndTotal", nickname = "getDocketDiscountAndTotalUsingGET", notes = "", response = String.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/docketDiscountAndTotal/{orderNumber}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<String> getDocketDiscountAndTotalUsingGET(@ApiParam(value = "orderNumber",required=true) @PathVariable("orderNumber") String orderNumber);


    @ApiOperation(value = "getDocketHeader", nickname = "getDocketHeaderUsingGET", notes = "", response = String.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/docketHeader/{orderNumber}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<String> getDocketHeaderUsingGET(@ApiParam(value = "orderNumber",required=true) @PathVariable("orderNumber") String orderNumber);


    @ApiOperation(value = "getDocketPaymentStatus", nickname = "getDocketPaymentStatusUsingGET", notes = "", response = String.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/docketPaymentStatus/{orderNumber}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<String> getDocketPaymentStatusUsingGET(@ApiParam(value = "orderNumber",required=true) @PathVariable("orderNumber") String orderNumber);


    @ApiOperation(value = "getDocketProducts", nickname = "getDocketProductsUsingGET", notes = "", response = String.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/docketProducts/{orderNumber}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<String> getDocketProductsUsingGET(@ApiParam(value = "orderNumber",required=true) @PathVariable("orderNumber") String orderNumber);


    @ApiOperation(value = "getFooters", nickname = "getFootersUsingGET", notes = "", response = String.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/docketFooters/{orderNumber}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<String> getFootersUsingGET(@ApiParam(value = "orderNumber",required=true) @PathVariable("orderNumber") String orderNumber);


    @ApiOperation(value = "getOrderSummaryBetweenDatesAsPdf", nickname = "getOrderSummaryBetweenDatesAsPdfUsingGET", notes = "", response = byte[].class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = byte[].class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/orderSummaryBetweenDatesAndStoreId/{fromDate}/{toDate}/{storeId}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<byte[]> getOrderSummaryBetweenDatesAsPdfUsingGET(@ApiParam(value = "fromDate",required=true) @PathVariable("fromDate") String fromDate,@ApiParam(value = "storeId",required=true) @PathVariable("storeId") String storeId,@ApiParam(value = "toDate",required=true) @PathVariable("toDate") String toDate);


    @ApiOperation(value = "getOrderSummaryByDateAndStoreNameAsPdf", nickname = "getOrderSummaryByDateAndStoreNameAsPdfUsingGET", notes = "", response = byte[].class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = byte[].class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/ordersummarybydateandstorename/{date}/{storeId}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<byte[]> getOrderSummaryByDateAndStoreNameAsPdfUsingGET(@ApiParam(value = "date",required=true) @PathVariable("date") String date,@ApiParam(value = "storeId",required=true) @PathVariable("storeId") String storeId);


    @ApiOperation(value = "getOrderTimes", nickname = "getOrderTimesUsingGET", notes = "", response = String.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/docketOrderTime/{orderNumber}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<String> getOrderTimesUsingGET(@ApiParam(value = "orderNumber",required=true) @PathVariable("orderNumber") String orderNumber);


    @ApiOperation(value = "getOrdersByFilter", nickname = "getOrdersByFilterUsingGET", notes = "", response = PageOfOrderMaster.class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PageOfOrderMaster.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/allOrdersByFiltering/{fromDate}/{toDate}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<PageOfOrderMaster> getOrdersByFilterUsingGET(@ApiParam(value = "fromDate",required=true) @PathVariable("fromDate") String fromDate,@ApiParam(value = "toDate",required=true) @PathVariable("toDate") String toDate,@ApiParam(value = "methodOfOrder") @Valid @RequestParam(value = "methodOfOrder", required = false) String methodOfOrder,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "paymentStatus") @Valid @RequestParam(value = "paymentStatus", required = false) String paymentStatus,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort,@ApiParam(value = "storeId") @Valid @RequestParam(value = "storeId", required = false) String storeId);


    @ApiOperation(value = "getOrdersPdfByFilter", nickname = "getOrdersPdfByFilterUsingGET", notes = "", response = byte[].class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = byte[].class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/allOrdersPdfByFiltering/{fromDate}/{toDate}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<byte[]> getOrdersPdfByFilterUsingGET(@ApiParam(value = "fromDate",required=true) @PathVariable("fromDate") String fromDate,@ApiParam(value = "toDate",required=true) @PathVariable("toDate") String toDate,@ApiParam(value = "methodOfOrder") @Valid @RequestParam(value = "methodOfOrder", required = false) String methodOfOrder,@ApiParam(value = "paymentStatus") @Valid @RequestParam(value = "paymentStatus", required = false) String paymentStatus,@ApiParam(value = "storeId") @Valid @RequestParam(value = "storeId", required = false) String storeId);


    @ApiOperation(value = "getReportSummaryAsPdf", nickname = "getReportSummaryAsPdfUsingGET", notes = "", response = byte[].class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = byte[].class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/reportSummary/{date}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<byte[]> getReportSummaryAsPdfUsingGET(@ApiParam(value = "date",required=true) @PathVariable("date") String date,@ApiParam(value = "storeName") @Valid @RequestParam(value = "storeName", required = false) String storeName);


    @ApiOperation(value = "getReportWithAuxAndComboAsPdf", nickname = "getReportWithAuxAndComboAsPdfUsingGET", notes = "", response = byte[].class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = byte[].class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/auxcombo/{orderNumber}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<byte[]> getReportWithAuxAndComboAsPdfUsingGET(@ApiParam(value = "orderNumber",required=true) @PathVariable("orderNumber") String orderNumber);


    @ApiOperation(value = "getSaleReportAsPdf", nickname = "getSaleReportAsPdfUsingGET", notes = "", response = byte[].class, tags={ "query-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = byte[].class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/salereport/{storeidpcode}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<byte[]> getSaleReportAsPdfUsingGET(@ApiParam(value = "storeidpcode",required=true) @PathVariable("storeidpcode") String storeidpcode);

}
