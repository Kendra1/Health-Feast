package sbnz.service;

import sbnz.web.dto.LoginRequestDto;
import sbnz.web.dto.LoginResponseDto;
import sbnz.web.dto.RegistrationDto;

public interface AuthUserService {
	
	LoginResponseDto login (LoginRequestDto loginRequest);

	RegistrationDto registerUser(RegistrationDto registrationDto);

	void confirmUserAccount(String confirmationToken);
}
