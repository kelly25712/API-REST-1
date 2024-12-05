package intentoA.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import intentoA.demo.dto.ContactDTO;
import intentoA.demo.model.Contact;
import intentoA.demo.service.ContactService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping ("contacts")
@CrossOrigin (origins= "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@Tag(name = "Contacts", description = "Provides methods for managing contacts")
public class ContactController {
    @Autowired
	private ContactService service;

	@Autowired
	private ModelMapper modelMapper;
	//@ApiResponse(responseCode = "200", description = "Found recharge", content = {
    //@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Contact.class))) })
	//@GetMapping
	//public List<Contact> getAll() {
	//	return service.getAll();
	//}
	
	@Operation(summary = "Get all contacts with pagination 	CU15.5-----")
	@GetMapping(value = "pagination", params = {"page", "size"})
	public List<Contact> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false)int 
	page,
 	@RequestParam(value = "size", defaultValue = "10", required = false) int size){
		List<Contact> contact = service.getALL(page, size);
		return contact;
	}   
	
	@Operation(summary = "Get contact information by Id CU15.3-----")
	@GetMapping("{idContact}")
	public ResponseEntity<ContactDTO> getByContact(@PathVariable Integer idContact) {
		return new ResponseEntity<ContactDTO>(convertToDTO(service.getByIdContact(idContact)), HttpStatus.OK);
	}

	@Operation(summary = "Create Contact CU15.1")
	@ApiResponse(responseCode = "201", description = "Registered a contact ", content = {
		@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ContactDTO.class))) })
	@PostMapping
	public ResponseEntity<ContactDTO> add( @Valid @RequestBody ContactDTO contactDTO) {
		ContactDTO savedContact = convertToDTO(service.save(convertToEntity(contactDTO)));
		return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
	}

	@Operation(summary = "Update information contact by Id CU15.2")
	@PutMapping("{idContact}")
	public ResponseEntity<?> update(@RequestBody Contact contact, @PathVariable Integer idContact) {
		try {
			Contact auxUser = service.getByIdContact(idContact);
			contact.setIdContact(auxUser.getIdContact());
			service.save(contact);
			return new ResponseEntity<>("Updated record", HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("The record with the idUser provided is not found in the database",
					HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Delete contact of user's list CU15.4------")
	@DeleteMapping("{idContact}")
	public void delete(@PathVariable Integer idContact) {
		service.delete(idContact);
	}

	@Operation(summary = "Get contact by name")
	@ApiResponse(responseCode = "200", description = "Found fabric", content = {
	@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Contact.class))) })
	@GetMapping("/search/{name}")
	public List getContactsByName(@PathVariable String name) {
	return service.getContactsByName(name);
	}

	private ContactDTO convertToDTO(Contact contact) {
		return modelMapper.map(contact, ContactDTO.class);
	}

	public Contact convertToEntity(ContactDTO contactDTO) {
		return modelMapper.map(contactDTO, Contact.class);
	}
	
}
