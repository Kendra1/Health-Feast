package sbnz.integracija.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.enumeration.Activity;
import sbnz.integracija.enumeration.Gender;
import sbnz.integracija.enumeration.UserStatus;
import sbnz.integracija.facts.User;


@Service
public class UserService {
	
	private final KieContainer kieContainer;

	@Autowired
	public UserService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public UserStatus getUserStatus(int purchasePoints) {
		KieSession kieSession = kieContainer.newKieSession();
		
		User user = new User();
		user.setPurchasePoints(purchasePoints);
		
		kieSession.insert(user);
		kieSession.fireAllRules();		
		kieSession.dispose();
		
		return user.getUserStatus();
	}
	
	public String getGoalAndRecommendedIntake(int weight, String gender, String activity) {
		KieSession kieSession = kieContainer.newKieSession();
		
		User user = new User();
		
		user.setWeight(weight);
		user.setGender(Gender.valueOf(gender));
		user.setActivity(Activity.valueOf(activity));
		
		kieSession.insert(user);
		kieSession.fireAllRules();		
		kieSession.dispose();
		
		return String.format("Daily intake of calories is: %s", user.getDailyCalorieIntake());
	}
}
