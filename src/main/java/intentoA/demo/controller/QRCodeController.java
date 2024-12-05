package intentoA.demo.controller;

import java.util.List;
//import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import intentoA.demo.dto.AccountsDTO;
import intentoA.demo.dto.QRCodeDTO;
import intentoA.demo.model.QRCode;
import intentoA.demo.service.QRCodeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping ("qrCodes")
@CrossOrigin (origins= "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@Tag(name = "QR Codes", description = "Provides methods for managing QR code")
public class QRCodeController {
    @Autowired
	private QRCodeService service;
	@Autowired
	private ModelMapper modelMapper;
	//@ApiResponse(responseCode = "200", description = "Found recharge", content = {
    //@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = QRCode.class))) })
	//@GetMapping
	//public List<QRCode> getAll() {
	//	return service.getAll();
	//}


	//@Tag(name = "Get all QRCode generated", description="Get list of QR")
	//@Operation(summary="Get list of QR codes generated")
	@ApiResponse(responseCode = "200", description = "Found recharge", content = {
       		@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = QRCode.class))) })

	@Operation(summary = "Get all QR code with pagination")
	@GetMapping(value = "pagination", params = {"page", "size"})
    public List<QRCode> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false)int
    page,    
    @RequestParam(value = "size", defaultValue = "10", required = false)int pageSize){
        List<QRCode> qrcode = service.getAll(page,pageSize);
        return qrcode;
    }

	//@Tag(name = "Get QR by Id", description="Get info QRCodes with Id or confirm his existence")
	@Operation(summary="Get QR by Id")
	@GetMapping("{idCode}")
	public ResponseEntity<QRCodeDTO> getByControlNumber(@PathVariable Integer idCode) {
		return new ResponseEntity<QRCodeDTO>(convertToDTO(service.getByIdQRCode(idCode)), HttpStatus.OK);
	}

	@Operation(summary = "Create a QR code CU5")
	@ApiResponse(responseCode = "201", description = "Registered a qr code", content = {
		@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AccountsDTO.class))) })
	@PostMapping
	public ResponseEntity<QRCodeDTO> add(@Valid @RequestBody QRCodeDTO qrCodeDTO) {
		QRCodeDTO saved = convertToDTO(service.save(convertToEntity(qrCodeDTO)));
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	private QRCodeDTO convertToDTO(QRCode qrcode) {
		return modelMapper.map(qrcode, QRCodeDTO.class);
	}

	public QRCode convertToEntity(QRCodeDTO qrCodeDTO) {
		return modelMapper.map(qrCodeDTO, QRCode.class);
	}

	//@Tag(name = "Update QR with Id", description="Update info QR")
	//@Operation(summary="Update QR by Id")
	//@PutMapping("{idCode}")
	//public ResponseEntity<?> update(@RequestBody QRCode qrCode, @PathVariable Integer idCode) {
	//	try {
	//		QRCode auxUser = service.getByIdQRCode(idCode);
	//		qrCode.setIdCode(auxUser.getIdCode());
	//		service.save(qrCode);
	//		return new ResponseEntity<>("Updated record", HttpStatus.OK);
	//	}catch (NoSuchElementException e) {
	  //      return new ResponseEntity<String>("The record with the idCode provided is not found in the database", HttpStatus.NOT_FOUND);
	    //}
	//}

	//@Tag(name = "Delete QR with Id", description="Delete QR code from database")
	//@Operation(summary="IT'S NO SURE THIS ACTION")
	//@DeleteMapping("{idCode}")
	//public void delete(@PathVariable Integer idCode) {
	//	service.delete(idCode);
	//}


}
