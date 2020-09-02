package sbnz.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import sbnz.enumeration.UserStatus;
import sbnz.web.dto.UpdateUserDto;
import sbnz.web.dto.UserDto;


public interface UserService {

	String getRecommendedCalories(String goal, Authentication authentication);

	String getDailyCaloriesStatus(Authentication authentication);

	UpdateUserDto updateUser(UpdateUserDto updatedUser, MultipartFile image, Authentication authentication);

	UserDto getLoggedUser(Authentication authentication);

	UserStatus getUserStatus(Authentication authentication);

	String getRecommendedIntake(Authentication authentication);	
}
