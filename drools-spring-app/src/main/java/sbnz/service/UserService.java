package sbnz.service;

import java.util.Map;

import org.springframework.security.core.Authentication;

import sbnz.enumeration.UserStatus;
import sbnz.web.dto.DailyMealDto;
import sbnz.web.dto.UpdateUserDto;
import sbnz.web.dto.UserDto;


public interface UserService {

	String getRecommendedCalories(String goal, Authentication authentication);

	Map<String, String> getDailyCaloriesStatus(Authentication authentication, String date);

	UpdateUserDto updateUser(UpdateUserDto updatedUser, Authentication authentication);

	UserDto getLoggedUser(Authentication authentication);

	UserStatus getUserStatus(Authentication authentication);

	String getRecommendedIntake(Authentication authentication);

	Double saveDailyMeal(DailyMealDto dailyMealdDto, Authentication authentication);	
}
