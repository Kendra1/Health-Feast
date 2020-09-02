package sbnz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import sbnz.enumeration.UserStatus;
import sbnz.security.annotations.LoggedUser;
import sbnz.service.UserService;
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
	public String getDailyCaloriesStatus(Authentication authentication) {
		return userService.getDailyCaloriesStatus(authentication);
	}

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    @LoggedUser
    public UpdateUserDto updateUser(@RequestPart(value = "user") UpdateUserDto updatedUser,
                                 	@RequestPart(value = "file", required = false) MultipartFile image,
                                 	Authentication authentication) {
        return userService.updateUser(updatedUser, image, authentication);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @LoggedUser
    public UserDto getLoggedUser(Authentication authentication) {
        return userService.getLoggedUser(authentication);
    }
}