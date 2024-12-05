package intentoA.demo.controller;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import intentoA.demo.dto.RechargeDTO;
import intentoA.demo.model.Recharge;
import intentoA.demo.service.RechargeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("recharges")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })
@Tag(name = "Recharges", description = "Provides methods for managing recharge")

public class RechargeController {

    @Autowired
    private RechargeService service;
	@Autowired
	private ModelMapper modelMapper;
    //@ApiResponse(responseCode = "200", description = "Found recharge", content = {
    //@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Recharge.class))) })
	//@GetMapping
	//public List<Recharge> getAll() {
	//	return service.getAll();
	//}

    @Operation(summary="Get recahrges with pagination")
    @GetMapping(value = "pagination", params = {"page", "size"})
    public List<Recharge> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false)int
    page,    

    @RequestParam(value = "size", defaultValue = "10", required = false)int pageSize){
        List<Recharge> recharge = service.getAll(page,pageSize);
        return recharge;
    }

    @Operation(summary="Get Recharge information by Id")
    @GetMapping("{idRecharge}")
    public ResponseEntity<RechargeDTO> getById(@PathVariable Integer idRecharge) {
        return new ResponseEntity<RechargeDTO>(convertToDTO(service.getByIdRecharge(idRecharge)), HttpStatus.OK);
    }

    @Operation(summary = "Create a recharge CU11")
	@ApiResponse(responseCode = "201", description = "Registered a recharge", content = {
		@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RechargeDTO.class))) })
	@PostMapping
	public ResponseEntity<RechargeDTO> add(@Valid @RequestBody RechargeDTO rechargeDTO) {
		RechargeDTO saved = convertToDTO(service.save(convertToEntity(rechargeDTO)));
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

    private RechargeDTO convertToDTO(Recharge recharge) {
		return modelMapper.map(recharge, RechargeDTO.class);
	}

	public Recharge convertToEntity(RechargeDTO rechargeDTO) {
		return modelMapper.map(rechargeDTO, Recharge.class);
	}

    //@Operation(summary="Update rechage by Id")
    //@PutMapping("{idRecharge}")
    //public ResponseEntity<?> update(@RequestBody Recharge recharge, @PathVariable Integer idRecharge) {
      //  Recharge auxRecharge = service.getByIdRecharge(idRecharge);
      //  recharge.setIdRecharge(auxRecharge.getIdRecharge());
      //  service.save(recharge);
      //  return new ResponseEntity<String>("Updated record", HttpStatus.OK);
    //}

    //@Operation(summary="Delete recharge by Id")
    //@DeleteMapping("{idRecharge}")
    //public ResponseEntity<?> delete(@RequestBody Recharge recharge, @PathVariable Integer idRecharge) {
      //  service.delete(idRecharge);
       // return new ResponseEntity<String>("Deleted record", HttpStatus.OK);
    //}

}
