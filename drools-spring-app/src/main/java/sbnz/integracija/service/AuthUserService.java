package sbnz.integracija.service;

import sbnz.integracija.facts.Person;

public interface AuthUserService {

	Person findByEmail(String email);
	
}
