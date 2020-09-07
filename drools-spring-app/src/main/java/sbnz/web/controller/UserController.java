	package sbnz.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sbnz.enumeration.UserStatus;
import sbnz.security.annotations.LoggedUser;
import sbnz.service.UserService;
import sbnz.web.dto.DailyMealDto;
import sbnz.web.dto.UpdateUserDto;
import sbnz.web.dto.UserDto;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/userStatus")
    @LoggedUser
	public UserStatus getUserStatus(Authentication authentication) {
		return userService.getUserStatus(authentication);
	}
	
	@GetMapping("/calories")
    @LoggedUser
	public String getRecommendedIntake (Authentication authentication) {
		return userService.getRecommendedIntake(authentication);
	}
	
	@GetMapping("/recommendedCalories")
    @LoggedUser
	public String getRecommendedCalories(@RequestParam ("goal") String goal, Authentication authentication) {
		return userService.getRecommendedCalories(goal, authentication);
	}
	
	@GetMapping("/dailyCaloriesStatus")
    @LoggedUser
	public Map<String, String> getDailyCaloriesStatus(Authentication authentication, @RequestParam("date") String date) {
		return userService.getDailyCaloriesStatus(authentication, date);
	}
	
	@PostMapping("/dailyMeal")
	@LoggedUser
	public DailyMealDto saveDailyMeal(@RequestBody DailyMealDto dailyMealDto, Authentication authentication) {
		return userService.saveDailyMeal(dailyMealDto, authentication);	
	}

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    @LoggedUser
    public UpdateUserDto updateUser(@RequestBody UpdateUserDto updatedUser,
                                 	Authentication authentication) {
        return userService.updateUser(updatedUser, authentication);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @LoggedUser
    public UserDto getLoggedUser(Authentication authentication) {
        return userService.getLoggedUser(authentication);
    }
}
