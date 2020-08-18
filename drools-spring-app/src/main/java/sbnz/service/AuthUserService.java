package sbnz.service;

import sbnz.model.Person;

public interface AuthUserService {

	Person findByEmail(String email);
	
}
