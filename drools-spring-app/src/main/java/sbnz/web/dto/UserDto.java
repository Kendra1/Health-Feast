package sbnz.web.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import sbnz.enumeration.Activity;
import sbnz.enumeration.Gender;
import sbnz.enumeration.Goal;

public class UserDto {
	
	private Long id;
	private String email;
	private String name;
	private String lastName;
	private Integer height;
	private Double weight;
	private Integer age;
	private Double accountBalance;
	private Double purchasePoints;
	private Double recommendedDailyCalories;
	private Double caloriesConsumed;
	private Activity activity;
	private Gender gender;
	private Goal goal;
	
	
	public UserDto() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Double getPurchasePoints() {
		return purchasePoints;
	}

	public void setPurchasePoints(Double purchasePoints) {
		this.purchasePoints = purchasePoints;
	}

	public Double getRecommendedDailyCalories() {
		return recommendedDailyCalories;
	}

	public void setRecommendedDailyCalories(Double recommendedDailyCalories) {
		this.recommendedDailyCalories = recommendedDailyCalories;
	}

	public Double getCaloriesConsumed() {
		return caloriesConsumed;
	}

	public void setCaloriesConsumed(Double caloriesConsumed) {
		this.caloriesConsumed = caloriesConsumed;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}
	
	
	
	
}
