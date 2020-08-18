package sbnz.service;

import org.springframework.stereotype.Service;

import sbnz.model.Person;

@Service
public class AuthUserServiceImpl implements AuthUserService {

//	@Autowired
//	private PersonRepository personRepository;
	
	@Override
	public Person findByEmail(String email) {
		return new Person();
	}

}
