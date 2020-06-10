package sbnz.integracija.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dtos.LoginDTO;
import sbnz.integracija.facts.Person;
import sbnz.integracija.service.AuthUserService;

public class AuthUserController {

	@Autowired
	private AuthUserService authUserService;
	
//	@PostMapping(
//			value = "/login",
//			consumes = MediaType.APPLICATION_JSON_VALUE,
//			produces = MediaType.APPLICATION_JSON_VALUE
//	)public ResponseEntity login(@RequestBody LoginDTO userCredentials) {
//		
//		Person user = authUserService.findByEmail(userCredentials.getEmail());
//		
//	}
	
}
