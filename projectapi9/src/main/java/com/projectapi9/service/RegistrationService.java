package com.projectapi9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectapi9.entity.Registration;
import com.projectapi9.repository.RegistrationRepository;

@Service
public class RegistrationService {
@Autowired
private RegistrationRepository registrationRepository;

public void saveRegistration(Registration registration) {
	registrationRepository.save(registration);
	
}

public List<Registration> getAllRegistration() {
	List<Registration>regis=registrationRepository.findAll();
	return regis;
}

public void deleteRegistration(long id) {
	registrationRepository.deleteById(id);
	
}

public Registration getRegistrationById(long id) {
	Registration reg=registrationRepository.findById(id).get();
	return reg;
}
}
