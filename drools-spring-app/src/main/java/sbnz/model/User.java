package sbnz.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import sbnz.enumeration.Activity;
import sbnz.enumeration.Gender;
import sbnz.enumeration.Goal;
import sbnz.enumeration.Role;
import sbnz.enumeration.UserStatus;

@Entity
public class User extends Person {
	
	private Integer height;
	private Double weight;
	private Integer age;
	private Double accountBalance;
	private Double purchasePoints;
	private Double recommendedDailyCalories;
	private Double caloriesForStagnate;
	private Double caloriesConsumed;
	
	@Enumerated(EnumType.STRING)
	private Activity activity;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Enumerated(EnumType.STRING)
	private Goal goal;
	
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;
	
	private boolean enabled;
	
	@Transient
	private double activityCount;
	@Transient
	private String warningForCalories;
	
	@OneToMany(mappedBy = "user")
	private List<MealHistory> mealHistories;
	
	@OneToMany(mappedBy = "user")
	private List<WorkoutHistory> workoutHistory;

	public User() {}
	
	public User(String name, String lastName, String email, String username, String password, LocalDate birthDate, Role role,
			Integer height, Double weight, Integer age, Gender gender, Goal goal, Double accountBalance, Double purchasePoints,
			UserStatus accountStatus, Double dailyCalorieIntake, List<MealHistory> mealHistory,
			List<WorkoutHistory> workoutHistory, Double recommendedDailyCalories) {
		super(name, lastName, email, username, password, birthDate, role);
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
		this.goal = goal;
		this.accountBalance = accountBalance;
		this.purchasePoints = purchasePoints;
		this.userStatus = accountStatus;
		this.recommendedDailyCalories = recommendedDailyCalories;
		this.mealHistories = mealHistory;
		this.workoutHistory = workoutHistory;
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

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
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

	public List<MealHistory> getMealHistories() {
		return mealHistories;
	}

	public void setMealHistories(List<MealHistory> mealHistories) {
		this.mealHistories = mealHistories;
	}

	public List<WorkoutHistory> getWorkoutHistory() {
		return workoutHistory;
	}

	public void setWorkoutHistory(List<WorkoutHistory> workoutHistory) {
		this.workoutHistory = workoutHistory;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Double getActivityCount() {
		return activityCount;
	}

	public void setActivityCount(Double activityCount) {
		this.activityCount = activityCount;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Double getCaloriesForStagnate() {
		return caloriesForStagnate;
	}

	public void setCaloriesForStagnate(Double caloriesForStagnate) {
		this.caloriesForStagnate = caloriesForStagnate;
	}

	public String getWarningForCalories() {
		return warningForCalories;
	}

	public void setWarningForCalories(String warningForCalories) {
		this.warningForCalories = warningForCalories;
	}
	
}
