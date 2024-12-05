package intentoA.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import intentoA.demo.dto.RetreatCLDTO;
import intentoA.demo.model.RetreatCL;
import intentoA.demo.service.RetreatCLService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@RestController
@RequestMapping("retreats")
@Tag(name = "Cardless withdrawal", description = "Provides methods for managing Retreat CardLess table")
public class RetreatCLController {
    @Autowired
    RetreatCLService service; 
	@Autowired
	private ModelMapper modelMapper;

	//@Operation(summary="Get retreat cardless CU13----")
	//@ApiResponse(responseCode = "200", description = "Found recharge", content = {
    //@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class))) })
	//@GetMapping
	//public List<RetreatCL> getAll() {
	//	return service.getAll();
	//}

    @Operation(summary="Get list retreat with paginated")
    @GetMapping(value = "pagination", params = {"page", "size"})
    public List<RetreatCL> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false)int
    page,    

    @RequestParam(value = "size", defaultValue = "10", required = false)int size){
        List<RetreatCL> retreatCL = service.getAll(page,size);
        return retreatCL;
    }

	@Operation(summary="Get information retreat by Id")
	@GetMapping("{idRetreatCL}")
	public ResponseEntity<RetreatCLDTO> getByControlNumber(@PathVariable Integer idRetreatCL) {
		return new ResponseEntity<RetreatCLDTO>(convertToDTO(service.getByIdRetreat(idRetreatCL)), HttpStatus.OK);
	}
    
    @Operation(summary = "Create retreat cardless CU6")
	@ApiResponse(responseCode = "201", description = "Registered retreat cardless", content = {
		@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RetreatCLDTO.class))) })
	@PostMapping
	public ResponseEntity<RetreatCLDTO> add(@Valid @RequestBody RetreatCLDTO retreatCLDTO) {
		RetreatCLDTO saved = convertToDTO(service.save(convertToEntity(retreatCLDTO)));
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	private RetreatCLDTO convertToDTO(RetreatCL retreatCL) {
		return modelMapper.map(retreatCL, RetreatCLDTO.class);
	}

	public RetreatCL convertToEntity(RetreatCLDTO retreatCLDTO) {
		return modelMapper.map(retreatCLDTO, RetreatCL.class);
	}

	//@Tag(name = "Update user with Id", description="Update info user data: name, dateOfBirth, address")
	//@Operation(summary="Update information user")
	//@PutMapping("{idRetreatCL}")
	//public ResponseEntity<?> update(@RequestBody RetreatCL retreatCL, @PathVariable Integer idRetreatCL) {
	//	try {
	//		RetreatCL auxRetreatCL = service.getByIdRetreat(idRetreatCL);
      //      retreatCL.setIdRetreatCL(auxRetreatCL.getIdRetreatCL());
		//	service.save(retreatCL);
		//	return new ResponseEntity<>("Updated record", HttpStatus.OK);
		//}catch (NoSuchElementException e) {
	      //  return new ResponseEntity<String>("The record with the idUser provided is not found in the database", HttpStatus.NOT_FOUND);
	    //}
	//}

	//@Tag(name = "Delete user with Id", description="Delete user from database")
	//@Operation(summary="Delete user from database")
	//@DeleteMapping("{idRetreatCL}")
	//public void delete(@PathVariable Integer idRetreatCL) {
	//	service.delete(idRetreatCL);
	//}
    
}
