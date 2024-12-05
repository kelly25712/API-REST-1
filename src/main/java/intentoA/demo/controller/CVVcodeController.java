package intentoA.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
import intentoA.demo.model.CVVcode;
import intentoA.demo.service.CvvcodeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping ("cvvcodes")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@Tag(name = "CVV codes", description = "Provides methods for managing cvvcode")

public class CVVcodeController {
    @Autowired
    CvvcodeService service;

    //@ApiResponse(responseCode = "200", description = "Found recharge", content = {
    //@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CVVcode.class))) })
	  //@GetMapping
	//public List<CVVcode> getAll() {
		//return service.getAll();
	//}

    @Operation(summary="Get list CVVcodes with pagination")
    @GetMapping(value = "pagination", params = {"page","size"})
    public List<CVVcode> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false)int
    page,    

    @RequestParam(value = "size", defaultValue = "10", required = false)int pageSize){
        List<CVVcode> cvvcode = service.getAll(page,pageSize);
        return cvvcode;
    }


    @Operation(summary="Get CVVcode by Id")
    @GetMapping("{idCvv}")
    public ResponseEntity<?> getById(@PathVariable Integer idCvv) {
        CVVcode code = service.getByIdCVVcode(idCvv);
        return new ResponseEntity<CVVcode>(code, HttpStatus.OK);
    }

    @Operation(summary="Create CVVcode CU12------")
    @PostMapping
	  public void registrar(@Valid @RequestBody CVVcode cvVcode) {
		  service.save(cvVcode);
	  }
    
    //@Operation(summary="Update CVVcode by Id")
    //@PutMapping("{idCvv}")
    //public ResponseEntity<?> update(@RequestBody CVVcode code, @PathVariable Integer idCvv) {
      //  CVVcode auxcvv = service.getByIdCVVcode(idCvv);
      //  code.setIdCvv(auxcvv.getIdCvv());
      //  service.save(code);
      //  return new ResponseEntity<String>("Updated record", HttpStatus.OK);
    //}
    //@Operation(summary="Delete CVVcode by Id")
      //@DeleteMapping("{id}")
    //public ResponseEntity<?> delete(@RequestBody CVVcode code, @PathVariable Integer idCvv) {
      //  service.delete(idCvv);
       // return new ResponseEntity<String>("Deleted record", HttpStatus.OK);
    //|}


}
