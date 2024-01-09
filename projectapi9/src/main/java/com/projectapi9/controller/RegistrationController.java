package com.projectapi9.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectapi9.dto.RegistrationDto;
import com.projectapi9.entity.Registration;
import com.projectapi9.service.RegistrationService;

@Controller
public class RegistrationController {
	@Autowired
	private RegistrationService  registrationService;
@RequestMapping("/babu")
public String ViewsRegistrationPage() {
	return "newregistration";
}
@RequestMapping("/saveReg")
public String saveRegistration(RegistrationDto dto,Model model) {
	Registration registration=new Registration();
	registration.setFirstName(dto.getFirstName());
	registration.setLastName(dto.getLastName());
	registration.setEmail(dto.getEmail());
	registration.setMobile(dto.getMobile());
	registrationService.saveRegistration(registration);
	model.addAttribute("msg", "Record is saved");
	return "newregistration";
	
}
@RequestMapping("/getAllReg")
public String getAllRegistration(Model model) {
	List<Registration>registration=registrationService.getAllRegistration();
	model.addAttribute("registrations", registration);
	return "listregistration";
	
}
@RequestMapping("/delete")
public String deleteRegistration(@RequestParam("id")long id,Model model) {
	registrationService.deleteRegistration(id);
	List<Registration>registration1=registrationService.getAllRegistration();
	model.addAttribute("registrations", registration1);
	return "listregistration";
	
}
@RequestMapping("/getRegistrationById")
public String getRegistrationById(@RequestParam("id") long id, Model model) {
	Registration registration=registrationService.getRegistrationById(id);
	model.addAttribute("reg", registration);
	return "updateregistration";
}
@RequestMapping("/updateReg")
public String updateRegistration(RegistrationDto dto,Model model) {
	Registration registration=new Registration();
	registration.setId(dto.getId());
	registration.setFirstName(dto.getFirstName());
	registration.setLastName(dto.getLastName());
	registration.setEmail(dto.getEmail());
	registration.setMobile(dto.getMobile());
	registrationService.saveRegistration(registration);
	List<Registration>registration1=registrationService.getAllRegistration();
	model.addAttribute("registrations", registration1);
	return "listregistration";
}
}