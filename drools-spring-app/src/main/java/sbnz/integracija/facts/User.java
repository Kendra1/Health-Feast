package sbnz.integracija.facts;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

import sbnz.integracija.enumeration.Activity;
import sbnz.integracija.enumeration.Gender;
import sbnz.integracija.enumeration.Goal;
import sbnz.integracija.enumeration.Role;
import sbnz.integracija.enumeration.UserStatus;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class User extends Person {
	
	private int height;
	private double weight;
	private int age;
	private Gender gender;
	private Goal goal;
	private double accountBalance;
	private double purchasePoints;
	private UserStatus userStatus;
	private double dailyCalorieIntake;
	private Activity activity;
	
	@Transient
	private double activityCount;
	
	@OneToMany(mappedBy = "user")
	private List<MealHistory> mealHistory;
	
	@OneToMany(mappedBy = "user")
	private List<WorkoutHistory> workoutHistory;

	public User() {}
	
	public User(String name, String lastName, String email, String username, String password, Date birthDate, Role role,
			int height, int weight, int age, Gender gender, Goal goal, double accountBalance, double purchasePoints,
			UserStatus accountStatus, double dailyCalorieIntake, List<MealHistory> mealHistory,
			List<WorkoutHistory> workoutHistory) {
		super(name, lastName, email, username, password, birthDate, role);
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
		this.goal = goal;
		this.accountBalance = accountBalance;
		this.purchasePoints = purchasePoints;
		this.userStatus = accountStatus;
		this.dailyCalorieIntake = dailyCalorieIntake;
		this.mealHistory = mealHistory;
		this.workoutHistory = workoutHistory;
	}


	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getPurchasePoints() {
		return purchasePoints;
	}

	public void setPurchasePoints(double purchasePoints) {
		this.purchasePoints = purchasePoints;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}


	public double getDailyCalorieIntake() {
		return dailyCalorieIntake;
	}

	public void setDailyCalorieIntake(double dailyCalorieIntake) {
		this.dailyCalorieIntake = dailyCalorieIntake;
	}

	public List<MealHistory> getMealHistory() {
		return mealHistory;
	}

	public void setMealHistory(List<MealHistory> mealHistory) {
		this.mealHistory = mealHistory;
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

	public double getActivityCount() {
		return activityCount;
	}

	public void setActivityCount(double activityCount) {
		this.activityCount = activityCount;
	}
}
