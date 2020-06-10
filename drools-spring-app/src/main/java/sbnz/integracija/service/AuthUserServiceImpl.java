package sbnz.integracija.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.PersonRepository;
import sbnz.integracija.facts.Person;

@Service
public class AuthUserServiceImpl implements AuthUserService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Person findByEmail(String email) {
		return personRepository.findByEmail(email);
	}

}
