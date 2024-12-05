package intentoA.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import intentoA.demo.model.RechargeCompanies;
import intentoA.demo.service.CompanyService;

import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping ("companies")
@CrossOrigin (origins= "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@Tag(name = "Companies", description = "Provides methods for managing recharge company")
public class CompanyController {
    @Autowired
	private CompanyService service;

	//@ApiResponse(responseCode = "200", description = "Found recharge", content = {
    //@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RechargeCompanies.class))) })
	//@GetMapping
	//public List<RechargeCompanies> getAll() {
	//	return service.getAll();
	//}

	@Operation(summary = "Get all recharge companies with pagination")
	@GetMapping(value = "pagination", params = {"page", "size"})
	public List<RechargeCompanies> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false)int
	page, 
	 @RequestParam(value = "size", defaultValue = "10", required = false) int pageSize){
		List<RechargeCompanies> rechargeCompanies = service.getALL(page, pageSize);
		return rechargeCompanies;
	 }                                                                                                     
	//@Tag(name="Get a recharge company with Id",description="Get a information of a recharge company")
	@Operation(summary="Get a recharge company by Id")
	@GetMapping("{idCompany}")
	public ResponseEntity<RechargeCompanies> getByControlNumber(@PathVariable Integer idCompany) {
		RechargeCompanies rechargeCompanies = service.getByIdCompany(idCompany);
		return new ResponseEntity<RechargeCompanies>(rechargeCompanies, HttpStatus.OK);
	}

	//@Tag(name="Create a Recharge Company",description="Create a recharge comapny data: name")
	@Operation(summary="Create a Recharge Company")
	@PostMapping
	public void registrar(@Valid @RequestBody RechargeCompanies rechargeCompanies) {
		service.save(rechargeCompanies);
	}

	//@Tag(name="Update Recharge company",description="Update name of Recharge company")
	@Operation(summary="Update Recharge company by Id")
	@PutMapping("{idCompany}")
	public ResponseEntity<?> update(@RequestBody RechargeCompanies rechargeCompanies, @PathVariable Integer idCompany) {
		try {
			RechargeCompanies auxUser = service.getByIdCompany(idCompany);
			rechargeCompanies.setIdCompany(auxUser.getIdCompany());
			service.save(rechargeCompanies);
			return new ResponseEntity<>("Updated record", HttpStatus.OK);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("The record with the idCompany provided is not found in the database", HttpStatus.NOT_FOUND);
	    }
	}

	//@Tag(name="Delete Recharge Company by Id",description="IT'S NO SURE delete recharge company ")
	//@Operation(summary="Delete Recharge Company by Id")
	//@DeleteMapping("{idCompany}")
	//public void delete(@PathVariable Integer idCompany) {
	//	service.delete(idCompany);
	//}
}
