package sbnz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import sbnz.service.AuthUserService;

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
