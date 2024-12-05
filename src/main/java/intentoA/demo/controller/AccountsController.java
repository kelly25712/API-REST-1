package intentoA.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import intentoA.demo.dto.AccountsDTO;
import intentoA.demo.model.Account;
import intentoA.demo.service.AccountsService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@Tag(name = "Accounts", description = "Provides methods for managing accounts")
public class AccountsController {
    @Autowired
	private AccountsService service;
	
	@Autowired
	private ModelMapper modelMapper;

	//@ApiResponse(responseCode = "200", description = "Found recharge", content = {
    //@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Account.class))) })
	//@GetMapping
	//public List<Account> getAll() {
	//	return service.getAll();
	//}

    @Operation(summary="Get accounts with pagination")
    @GetMapping(value = "pagination", params = {"page", "size"})
    public List<Account> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false)int
    page,    

    @RequestParam(value = "size", defaultValue = "10", required = false)int pageSize){
        List<Account> accounts = service.getAll(page,pageSize);
        return accounts;
    }

	@Operation(summary="Get information account by Id CU4----")
	@GetMapping("{idAccount}")
	public ResponseEntity<AccountsDTO> getByIdAccount(@PathVariable Integer idAccount) {
		return new ResponseEntity<AccountsDTO>(convertToDTO(service.getById(idAccount)), HttpStatus.OK);
	}

	@Operation(summary = "Get account balance by Id CU8----")
	@GetMapping("{idAccount}/balance")
	public ResponseEntity<Double> getAccountBalance(@PathVariable Integer idAccount) {
    Account account = service.getById(idAccount);
    if (account != null) {
        return new ResponseEntity<>(account.getBalance(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	}

	@Operation(summary = "Get BBVA points by account Id CU9----")
	@GetMapping("{idAccount}/pointsBBVA")
	public ResponseEntity<Integer> getAccountPointsBBVA(@PathVariable Integer idAccount) {
    Account account = service.getById(idAccount);
    if (account != null) {
        return new ResponseEntity<>(account.getpointBBVA(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	}

	@Operation(summary = "Login with account number and key CU1-----")
	@PostMapping("login")
	public ResponseEntity<String> login(@Valid @RequestParam Long accountNumber, @RequestParam String key) {
    Account account = service.getByAccountNumber(accountNumber);
    
    if (account != null && account.getKeyAccount().equals(key)) {
        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Invalid account number or key", HttpStatus.UNAUTHORIZED);
    }
	}

	@Operation(summary = "Create account")
	@ApiResponse(responseCode = "201", description = "Registered a account", content = {
		@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AccountsDTO.class))) })
	@PostMapping
	public ResponseEntity<AccountsDTO> add(@Valid @RequestBody AccountsDTO accountsDTO) {
		AccountsDTO savedAccount = convertToDTO(service.save(convertToEntity(accountsDTO)));
		return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
	}

	@Operation(summary="Update information account")
	@PutMapping("{idAccount}")
	public ResponseEntity<?> update(@RequestBody Account account, @PathVariable Integer idAccount) {
		try {
			Account auxAccount = service.getById(idAccount);
			account.setIdUser(auxAccount.getIdUser());
			service.save(account);
			return new ResponseEntity<>("Updated record", HttpStatus.OK);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("The record with the idUser provided is not found in the database", HttpStatus.NOT_FOUND);
	    }
	}

	//@Operation(summary="Delete account from database")
	//@DeleteMapping("{idAccount}")
	//	public void delete(@PathVariable Integer idAccount) {
	//	service.delete(idAccount);
	//}
	
	private AccountsDTO convertToDTO(Account account) {
		return modelMapper.map(account, AccountsDTO.class);
	}

	public Account convertToEntity(AccountsDTO accountsDTO) {
		return modelMapper.map(accountsDTO, Account.class);
	}
}