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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import intentoA.demo.dto.TransactionDTO;
import intentoA.demo.model.Transaction;
import intentoA.demo.service.TransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping ("transactions")
@CrossOrigin (origins= "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@Tag(name = "Transactions", description = "Provides methods for managing transaction")
public class TransactionController {
    @Autowired
	private TransactionService service;
	@Autowired
	private ModelMapper modelMapper;
	//@Operation(summary="Get all Transaction CU7-----")
	//@ApiResponse(responseCode = "200", description = "Found recharge", content = {
    //@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Transaction.class))) })
	//@GetMapping
	//public List<Transaction> getAll() {
	//	return service.getAll();
	//}

	//@Tag(name="Get all transactions",description="Get record of transactions")
	//@Operation(summary="Get record of transactions")
	@ApiResponse(responseCode = "200", description = "Found recharge", content = {
       		@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Transaction.class))) })
   @Operation(summary="Get transactions with pagination")
    @GetMapping(value = "pagination", params = {"page", "size"})
    public List<Transaction> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false)int
    page,    

    @RequestParam(value = "size", defaultValue = "10", required = false)int pageSize){
        List<Transaction> transaction = service.getAll(page,pageSize);
        return transaction;
    }

	//@Tag(name="Get transaction by Id",description="get information of transaction")
	@Operation(summary="Get transactions by Id")
	@GetMapping("{idTransaction}")
	public ResponseEntity<TransactionDTO> getByIdTransaction(@PathVariable Integer idTransaction) {
		return new ResponseEntity<TransactionDTO>(convertToDTO(service.getByIdTransaction(idTransaction)), HttpStatus.OK);
	}

	@Operation(summary = "Create transaction CU3")
	@ApiResponse(responseCode = "201", description = "Registered transaction", content = {
		@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TransactionDTO.class))) })
	@PostMapping
	public ResponseEntity<TransactionDTO> add(@Valid @RequestBody TransactionDTO transactionDTO) {
		TransactionDTO saved = convertToDTO(service.save(convertToEntity(transactionDTO)));
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	private TransactionDTO convertToDTO(Transaction transaction) {
		return modelMapper.map(transaction, TransactionDTO.class);
	}

	public Transaction convertToEntity(TransactionDTO transactionDTO) {
		return modelMapper.map(transactionDTO, Transaction.class);
	}	

	//@Tag(name="Update transaction with Id",description="IT'S NOT SURE ")
	//@Operation(summary="Update transaction by Id")
	//@PutMapping("{idTransaction}")
	//public ResponseEntity<?> update(@RequestBody Transaction transaction, @PathVariable Integer idTransaction) {
	//	try {
	//		Transaction auxUser = service.getByIdTransaction(idTransaction);
    //        transaction.setIdTransaction(auxUser.getIdTransaction());
	//		service.save(transaction);
	//		return new ResponseEntity<>("Updated record", HttpStatus.OK);
	//	}catch (NoSuchElementException e) {
	//        return new ResponseEntity<String>("The record with the idTransaction provided is not found in the database", HttpStatus.NOT_FOUND);
	  //  }
	//}

	//@Tag(name="Delete transaction with Id",description="IT'S NOT SURE delete transaction")
	//@Operation(summary="IT'S NO SURE THIS ACTION")
	//@DeleteMapping("{idTransaction}")
	//public void delete(@PathVariable Integer idTransaction) {
	//	service.delete(idTransaction);
	//}

}
