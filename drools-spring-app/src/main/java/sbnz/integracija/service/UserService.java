package sbnz.integracija.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.enumeration.Activity;
import sbnz.integracija.enumeration.Gender;
import sbnz.integracija.enumeration.Goal;
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
		user.setActivity(Activity.VERY_LIGHT);
		kieSession.insert(user);
		kieSession.getAgenda().getAgendaGroup("status").setFocus();
		kieSession.fireAllRules();		
		kieSession.dispose();
		return user.getUserStatus();
	}
	
	public String getRecommendedIntake(int weight, String gender, String activity) {
		KieSession kieSession = kieContainer.newKieSession();
		
		User user = new User();
		
		user.setWeight(weight);
		user.setGender(Gender.valueOf(gender));
		user.setActivity(Activity.valueOf(activity));
		
		kieSession.insert(user);
		kieSession.getAgenda().getAgendaGroup("activity").setFocus();
		kieSession.fireAllRules();		
		kieSession.dispose();
		
		return String.format("Daily intake of calories is: %s", user.getDailyCalorieIntake());
	}
	
	public String getRecommendedCalories(String goal) {
		KieSession kieSession = kieContainer.newKieSession();
		
		User user = new User();
		
		user.setWeight(150);
		user.setGender(Gender.MALE);
		user.setActivity(Activity.HEAVY);
		
		kieSession.insert(user);
		kieSession.getAgenda().getAgendaGroup("activity").setFocus();
		kieSession.fireAllRules();	

		if (user.getDailyCalorieIntake() != 0) {
			user.setGoal(Goal.valueOf(goal));
			kieSession.insert(user);
			kieSession.getAgenda().getAgendaGroup("activity").setFocus();
			kieSession.fireAllRules();	
			kieSession.dispose();
		}
		
		return String.format("Recommended intake of calories for your goal is: %s", user.getDailyCalorieIntake());
	}
}
