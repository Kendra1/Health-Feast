package sbnz.service;

import org.springframework.web.multipart.MultipartFile;

import sbnz.web.dto.LoginRequestDto;
import sbnz.web.dto.LoginResponseDto;
import sbnz.web.dto.RegistrationDto;

public interface AuthUserService {
	
	LoginResponseDto login (LoginRequestDto loginRequest);

	RegistrationDto registerUser(RegistrationDto registrationDto, MultipartFile image);

	void confirmUserAccount(String confirmationToken);
}
