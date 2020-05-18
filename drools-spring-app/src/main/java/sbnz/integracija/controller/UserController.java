package sbnz.integracija.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.enumeration.UserStatus;
import sbnz.integracija.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@GetMapping("/userStatus")
	public UserStatus getUserStatus(@RequestParam ("purchasePoints") int purchasePoints) {
		return userService.getUserStatus(purchasePoints);
	}
	
	@GetMapping("/calories")
	public String getRecommendedIntake(@RequestParam ("weight") int weight, 
			@RequestParam ("gender") String gender, @RequestParam ("activity") String activity) {
		return userService.getGoalAndRecommendedIntake(weight, gender, activity);
	}
}
