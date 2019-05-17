/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.diviso.graeshoppe.client.product.api;

import com.diviso.graeshoppe.client.product.model.StockDTO;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-17T14:38:38.757+05:30[Asia/Kolkata]")

@Api(value = "StockResource", description = "the StockResource API")
public interface StockResourceApi {

    @ApiOperation(value = "createStock", nickname = "createStockUsingPOST", notes = "", response = StockDTO.class, tags={ "stock-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StockDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/stocks",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<StockDTO> createStockUsingPOST(@ApiParam(value = "stockDTO" ,required=true )  @Valid @RequestBody StockDTO stockDTO);


    @ApiOperation(value = "deleteStock", nickname = "deleteStockUsingDELETE", notes = "", tags={ "stock-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/api/stocks/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteStockUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "getAllStocks", nickname = "getAllStocksUsingGET", notes = "", response = StockDTO.class, responseContainer = "List", tags={ "stock-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StockDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/stocks",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<StockDTO>> getAllStocksUsingGET(@ApiParam(value = "eagerload", defaultValue = "false") @Valid @RequestParam(value = "eagerload", required = false, defaultValue="false") Boolean eagerload,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "getStock", nickname = "getStockUsingGET", notes = "", response = StockDTO.class, tags={ "stock-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StockDTO.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/stocks/{id}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<StockDTO> getStockUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "searchStocks", nickname = "searchStocksUsingGET", notes = "", response = StockDTO.class, responseContainer = "List", tags={ "stock-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StockDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/_search/stocks",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<StockDTO>> searchStocksUsingGET(@NotNull @ApiParam(value = "query", required = true) @Valid @RequestParam(value = "query", required = true) String query,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "updateStock", nickname = "updateStockUsingPUT", notes = "", response = StockDTO.class, tags={ "stock-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StockDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/stocks",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<StockDTO> updateStockUsingPUT(@ApiParam(value = "stockDTO" ,required=true )  @Valid @RequestBody StockDTO stockDTO);

}
