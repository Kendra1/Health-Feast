package sbnz.integracija.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.facts.Person;
//import sbnz.integracija.repository.PersonRepository;

@Service
public class AuthUserServiceImpl implements AuthUserService {

//	@Autowired
//	private PersonRepository personRepository;
	
	@Override
	public Person findByEmail(String email) {
		return new Person();
	}

}
