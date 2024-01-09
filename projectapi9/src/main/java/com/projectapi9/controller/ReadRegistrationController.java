package com.projectapi9.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.projectapi9.dto.ReadRegistrationDto;
import com.projectapi9.dto.RegistrationDto;
import com.projectapi9.entity.Registration;
import com.projectapi9.exception.ResourceNotFoundException;
import com.projectapi9.repository.RegistrationRepository;

@RestController
@RequestMapping("/projectapi9")
public class ReadRegistrationController {
	@Autowired
	private RegistrationRepository registrationRepository;
//@PostMapping()
//public void saveRegistration(@RequestBody RegistrationDto dto) {
//	Registration registration=new Registration();
//	registration.setFirstName(dto.getFirstName());
//	registration.setLastName(dto.getLastName());
//	registration.setEmail(dto.getEmail());
//	registration.setMobile(dto.getMobile());
//	registrationRepository.save(registration);
//}
//	@PostMapping()
//	public ResponseEntity<Registration> saveRegistration(@RequestBody RegistrationDto dto) {
//		Registration registration=new Registration();
//		registration.setFirstName(dto.getFirstName());
//		registration.setLastName(dto.getLastName());
//		registration.setEmail(dto.getEmail());
//		registration.setMobile(dto.getMobile());
//		Registration saved=registrationRepository.save(registration);
//		return new ResponseEntity<>(saved,HttpStatus.CREATED);
//	}
//	@PostMapping()
//	public ResponseEntity<String> saveRegistration(@RequestBody RegistrationDto dto) {
//		Registration registration=new Registration();
//		registration.setFirstName(dto.getFirstName());
//		registration.setLastName(dto.getLastName());
//		registration.setEmail(dto.getEmail());
//		registration.setMobile(dto.getMobile());
//		registrationRepository.save(registration);
//		return new ResponseEntity<>("Record is saved",HttpStatus.CREATED);
//	}
//	@PostMapping()
//	public void saveRegistration(@RequestBody Registration registration) {
//		registrationRepository.save(registration);
//		
//	}
//	@PostMapping()
//	public ResponseEntity<Registration> saveRegistration(@RequestBody Registration registration) {
//		Registration saved=registrationRepository.save(registration);
//		return new ResponseEntity<>(saved,HttpStatus.CREATED);
//		
//	}
//	@PostMapping()
//	public ResponseEntity<String> saveRegistration(@RequestBody Registration registration) {
//		registrationRepository.save(registration);
//		return new ResponseEntity<>("Record is saved",HttpStatus.CREATED);
//		
//	}
	@PostMapping()
	public ResponseEntity<String> saveRegistration(@Valid @RequestBody Registration registration,BindingResult result) {
		
		if(result.hasErrors()) {
		return new 	ResponseEntity<>( result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		registrationRepository.save(registration);
		return new ResponseEntity<>("Record is saved",HttpStatus.CREATED);
		
	}
//	@PutMapping()
//	public void updateRegistration(@RequestBody RegistrationDto dto,@RequestParam ("id")long id) {
//		Registration registration=registrationRepository.findById(id).get();
//		registration.setFirstName(dto.getFirstName());
//		registration.setLastName(dto.getLastName());
//		registration.setEmail(dto.getEmail());
//		registration.setMobile(dto.getMobile());
//		registrationRepository.save(registration);
//	}
//	@PutMapping()
//	public ResponseEntity<Registration> updateRegistration(@RequestBody RegistrationDto dto,@RequestParam ("id")long id) {
//		Registration registration=registrationRepository.findById(id).get();
//		registration.setFirstName(dto.getFirstName());
//		registration.setLastName(dto.getLastName());
//		registration.setEmail(dto.getEmail());
//		registration.setMobile(dto.getMobile());
//		Registration update=registrationRepository.save(registration);
//		return new ResponseEntity<>(update,HttpStatus.OK);
//	}
	@PutMapping()
	public ResponseEntity<String> updateRegistration(@RequestBody RegistrationDto dto,@RequestParam ("id")long id) {
		Registration registration=registrationRepository.findById(id).get();
		registration.setFirstName(dto.getFirstName());
		registration.setLastName(dto.getLastName());
		registration.setEmail(dto.getEmail());
		registration.setMobile(dto.getMobile());
		registrationRepository.save(registration);
		return new ResponseEntity<>("Record is updated",HttpStatus.OK);
	}
//	@DeleteMapping("/{id}")
//	public void deleteRegistration(@PathVariable long id) {
//		registrationRepository.deleteById(id);
//	}
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Registration> deleteRegistration(@PathVariable long id) {
//		registrationRepository.deleteById(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRegistration(@PathVariable long id) {
		Optional<Registration> findById = registrationRepository.findById(id);
		if(findById.isPresent()) {
			registrationRepository.deleteById(id);
		}else {
			throw new ResourceNotFoundException("Registration Not Found with Id:+id");
		}
		
		return new ResponseEntity<>("Record is deleted",HttpStatus.OK);
	}
//	@GetMapping
//	public List<Registration> getAllRegistration() {
//		List<Registration>reg=registrationRepository.findAll();
//		return reg;
//		
//	}
//	@GetMapping
//	public ResponseEntity<List<Registration>>getAllRegistration() {
//		List<Registration>reg=registrationRepository.findAll();
//		return new ResponseEntity<>(reg,HttpStatus.OK);
//}
	@GetMapping
	public ResponseEntity<ReadRegistrationDto>getAllRegistration() {
		List<Registration>reg=registrationRepository.findAll();
		ReadRegistrationDto dto=new ReadRegistrationDto();
		dto.setRegistration(reg);
		dto.setMessage("Reading is complet");
		return new ResponseEntity<>(dto,HttpStatus.OK);
}
}