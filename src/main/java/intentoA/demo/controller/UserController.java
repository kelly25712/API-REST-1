package intentoA.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

import intentoA.demo.model.User;
import intentoA.demo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping ("users")
@CrossOrigin (origins= "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@Tag(name = "Users", description = "Provides methods for managing user")
public class UserController {
    @Autowired
	private UserService service;

	//@ApiResponse(responseCode = "200", description = "Found recharge", content = {
    //@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class))) })
	//@GetMapping
	//public List<User> getAll() {
	//	return service.getAll();
	//}

    @Operation(summary="Get users with pagination")
    @GetMapping(value = "pagination", params = {"page", "size"})
    public List<User> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false)int
    page,    

    @RequestParam(value = "size", defaultValue = "10", required = false)int pageSize){
        List<User> user = service.getAll(page,pageSize);
        return user;
    }

	
	@Operation(summary="Get information user by Id CU4----")
	@GetMapping("{idUser}")
	public ResponseEntity<User> getByControlNumber(@PathVariable Integer idUser) {
		User user = service.getByIdUser(idUser);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@Operation(summary="Create a user")
	@PostMapping
	public void registrar(@Valid @RequestBody User user) {
		service.save(user);
	}

	@Operation(summary="Update information user")
	@PutMapping("{idUser}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer idUser) {
		try {
			User auxUser = service.getByIdUser(idUser);
			user.setIdUser(auxUser.getIdUser());
			service.save(user);
			return new ResponseEntity<>("Updated record", HttpStatus.OK);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("The record with the idUser provided is not found in the database", HttpStatus.NOT_FOUND);
	    }
	}

	//@Tag(name = "Delete user with Id", description="Delete user from database")
	//@Operation(summary="Delete user from database")
	//@DeleteMapping("{idUser}")
	//public void delete(@PathVariable Integer idUser) {
	//	service.delete(idUser);
	//}
}

