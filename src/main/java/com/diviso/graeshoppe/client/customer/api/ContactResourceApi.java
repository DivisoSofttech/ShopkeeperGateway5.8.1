/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.diviso.graeshoppe.client.customer.api;

import com.diviso.graeshoppe.client.customer.model.ContactDTO;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-02T11:06:23.898839200+05:30[Asia/Calcutta]")

@Api(value = "ContactResource", description = "the ContactResource API")
public interface ContactResourceApi {

    @ApiOperation(value = "createContact", nickname = "createContactUsingPOST", notes = "", response = ContactDTO.class, tags={ "contact-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ContactDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/contacts",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<ContactDTO> createContactUsingPOST(@ApiParam(value = "contactDTO" ,required=true )  @Valid @RequestBody ContactDTO contactDTO);


    @ApiOperation(value = "deleteContact", nickname = "deleteContactUsingDELETE", notes = "", tags={ "contact-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/api/contacts/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteContactUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "getAllContacts", nickname = "getAllContactsUsingGET", notes = "", response = ContactDTO.class, responseContainer = "List", tags={ "contact-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ContactDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/contacts",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<ContactDTO>> getAllContactsUsingGET(@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "getContact", nickname = "getContactUsingGET", notes = "", response = ContactDTO.class, tags={ "contact-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ContactDTO.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/contacts/{id}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<ContactDTO> getContactUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "searchContacts", nickname = "searchContactsUsingGET", notes = "", response = ContactDTO.class, responseContainer = "List", tags={ "contact-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ContactDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/_search/contacts",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<ContactDTO>> searchContactsUsingGET(@NotNull @ApiParam(value = "query", required = true) @Valid @RequestParam(value = "query", required = true) String query,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "updateContact", nickname = "updateContactUsingPUT", notes = "", response = ContactDTO.class, tags={ "contact-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ContactDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/contacts",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<ContactDTO> updateContactUsingPUT(@ApiParam(value = "contactDTO" ,required=true )  @Valid @RequestBody ContactDTO contactDTO);

}
