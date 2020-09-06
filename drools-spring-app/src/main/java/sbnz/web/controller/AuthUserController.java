package sbnz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import sbnz.service.AuthUserService;
import sbnz.web.dto.LoginRequestDto;
import sbnz.web.dto.LoginResponseDto;
import sbnz.web.dto.RegistrationDto;

@RestController
@RequestMapping("/api/auth")
public class AuthUserController {

	@Autowired
	private AuthUserService authUserService;
	
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseDto login(@RequestBody LoginRequestDto loginDto) {
        return authUserService.login(loginDto);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistrationDto registerUser(@RequestBody RegistrationDto registrationDto) {
        return authUserService.registerUser(registrationDto);
    }

    @GetMapping("/confirmAccount")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void confirmUserAccount(@RequestParam("token") String confirmationToken) {
    	authUserService.confirmUserAccount(confirmationToken);
    }
	
}
