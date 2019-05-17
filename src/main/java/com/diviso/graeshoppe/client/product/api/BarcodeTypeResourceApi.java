/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.diviso.graeshoppe.client.product.api;

import com.diviso.graeshoppe.client.product.model.BarcodeTypeDTO;
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

@Api(value = "BarcodeTypeResource", description = "the BarcodeTypeResource API")
public interface BarcodeTypeResourceApi {

    @ApiOperation(value = "createBarcodeType", nickname = "createBarcodeTypeUsingPOST", notes = "", response = BarcodeTypeDTO.class, tags={ "barcode-type-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = BarcodeTypeDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/barcode-types",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<BarcodeTypeDTO> createBarcodeTypeUsingPOST(@ApiParam(value = "barcodeTypeDTO" ,required=true )  @Valid @RequestBody BarcodeTypeDTO barcodeTypeDTO);


    @ApiOperation(value = "deleteBarcodeType", nickname = "deleteBarcodeTypeUsingDELETE", notes = "", tags={ "barcode-type-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/api/barcode-types/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteBarcodeTypeUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "getAllBarcodeTypes", nickname = "getAllBarcodeTypesUsingGET", notes = "", response = BarcodeTypeDTO.class, responseContainer = "List", tags={ "barcode-type-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = BarcodeTypeDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/barcode-types",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<BarcodeTypeDTO>> getAllBarcodeTypesUsingGET(@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "getBarcodeType", nickname = "getBarcodeTypeUsingGET", notes = "", response = BarcodeTypeDTO.class, tags={ "barcode-type-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = BarcodeTypeDTO.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/barcode-types/{id}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<BarcodeTypeDTO> getBarcodeTypeUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "searchBarcodeTypes", nickname = "searchBarcodeTypesUsingGET", notes = "", response = BarcodeTypeDTO.class, responseContainer = "List", tags={ "barcode-type-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = BarcodeTypeDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/_search/barcode-types",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<BarcodeTypeDTO>> searchBarcodeTypesUsingGET(@NotNull @ApiParam(value = "query", required = true) @Valid @RequestParam(value = "query", required = true) String query,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "updateBarcodeType", nickname = "updateBarcodeTypeUsingPUT", notes = "", response = BarcodeTypeDTO.class, tags={ "barcode-type-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = BarcodeTypeDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/barcode-types",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<BarcodeTypeDTO> updateBarcodeTypeUsingPUT(@ApiParam(value = "barcodeTypeDTO" ,required=true )  @Valid @RequestBody BarcodeTypeDTO barcodeTypeDTO);

}
