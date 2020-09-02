package sbnz.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import sbnz.event.RegistrationSuccessEvent;
import sbnz.exception.InvalidLoginException;
import sbnz.exception.InvalidTokenException;
import sbnz.model.ConfirmationToken;
import sbnz.model.Person;
import sbnz.model.User;
import sbnz.repository.ConfirmationTokenRepository;
import sbnz.repository.UserRepository;
import sbnz.security.JwtUtil;
import sbnz.web.dto.LoginRequestDto;
import sbnz.web.dto.LoginResponseDto;
import sbnz.web.dto.RegistrationDto;

@Service
public class AuthUserServiceImpl implements AuthUserService {
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
    private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;


	@Override
	public LoginResponseDto login(LoginRequestDto loginRequest) {
		try {
	           UsernamePasswordAuthenticationToken authenticationToken =
	                   new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
	           Authentication authentication = authenticationManager.authenticate(authenticationToken);
	
	           User user = (User) authentication.getPrincipal();
	           String token = jwtUtil.createJwt(user);

	           return new LoginResponseDto(user.getId(), user.getEmail(), user.getName(), user.getLastName(), token);
	           
	     	} catch (Exception ex) {
	     		throw new InvalidLoginException("Login failed. " + ex.getMessage());
	        }
	}

	@Override
	public RegistrationDto registerUser(RegistrationDto registrationDto, MultipartFile image) {
		User user = objectMapper.convertValue(registrationDto, User.class);

        userRepository.save(user);
        eventPublisher.publishEvent(new RegistrationSuccessEvent(user));

        return objectMapper.convertValue(user, RegistrationDto.class);	
	}

    private void enableConfirmation(Long userId, ConfirmationToken confirmationToken) {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        user.setEnabled(true);

        //delete token
        user.setConfirmationToken(null);
        userRepository.save(user);
        confirmationTokenRepository.deleteById(confirmationToken.getId());
    }

    private boolean hasTokenExpired(ConfirmationToken confirmationToken) {
        return LocalDate.now().isAfter(confirmationToken.getCreatedDate().plusDays(1));
    }

	@Override
	public void confirmUserAccount(String token) {
		ConfirmationToken confirmationToken =
                confirmationTokenRepository.findByToken(token).orElseThrow(EntityNotFoundException::new);
        Long userId;

        try {
            userId = confirmationToken.getUser().getId();
        } catch (NullPointerException ex) {
            throw new IllegalArgumentException("Id of user must exist.");
        }

        if (hasTokenExpired(confirmationToken)) {
            userRepository.deleteById(userId);
            throw new InvalidTokenException("Given token has expired.");
        }

        enableConfirmation(userId, confirmationToken);		
	}

}
