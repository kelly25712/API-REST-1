package intentoA.demo.controller;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import intentoA.demo.dto.SectionsDTO;
import intentoA.demo.model.Sections;
import intentoA.demo.service.SectionsService;
import java.util.List;


@Validated
@RestController
@RequestMapping("sections")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@Tag(name = "Sections", description = "Provides methods for managing sections")

public class SectionsController {
    
    @Autowired
	private SectionsService service;

	@Autowired
	private ModelMapper modelMapper;

	  @Operation(summary="Get list retreat with paginated")
    @GetMapping(value = "pagination", params = {"page", "size"})
    public List<Sections> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false)int
    page,    

    @RequestParam(value = "size", defaultValue = "10", required = false)int size){
        List<Sections> sections = service.getAllPagination(page,size);
        return sections;
    }


	@Operation(summary="Get information section by Id CU14.7--------")
	@GetMapping("{idSections}")
	public ResponseEntity<SectionsDTO> getById(@PathVariable  Integer idSections) {
		return new ResponseEntity<SectionsDTO>(convertToDTO(service.getById(idSections)), HttpStatus.OK);
	}

	@Operation(summary = "Create a section CU14.1----")
	@ApiResponse(responseCode = "201", description = "Registered fabric type", content = {
		@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SectionsDTO.class))) })
	@PostMapping
	public ResponseEntity<SectionsDTO> add(@Valid @RequestBody SectionsDTO sectionsDTO) {
		SectionsDTO savedFabricType = convertToDTO(service.save(convertToEntity(sectionsDTO)));
		return new ResponseEntity<>(savedFabricType, HttpStatus.CREATED);
	}

	@Operation(summary="Update Section CU14.2----")
	@PutMapping("{idSections}")
	public ResponseEntity<?> update(@RequestBody Sections sections, @PathVariable Integer idSections) {
		try {
			Sections auxSection = service.getById(idSections);
			sections.setIdSections(auxSection.getIdSections());
			service.save(sections);
			return new ResponseEntity<>("Updated record", HttpStatus.OK);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("The record with the idUser provided is not found in the database", HttpStatus.NOT_FOUND);
	    }
	}
	
	@Operation(summary="Delete section CU14.4------------")
	@DeleteMapping("{idSections}")
	public void delete(@PathVariable Integer idSections) {
		service.delete(idSections);
	}

	private SectionsDTO convertToDTO(Sections sections) {
		return modelMapper.map(sections, SectionsDTO.class);
	}

	public Sections convertToEntity(SectionsDTO sectionsDTO) {
		return modelMapper.map(sectionsDTO, Sections.class);
	}
}