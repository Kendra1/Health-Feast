package sbnz.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import sbnz.enumeration.WorkoutType;

@Entity
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	private List<ExerciseQuantity> exercises;
	
	private WorkoutType type;
	private int duration;
	private int caloriesBurnt;
	
	public Workout(List<ExerciseQuantity> exercises, WorkoutType type, int duration, int caloriesBurnt) {
		this.exercises = exercises;
		this.type = type;
		this.duration = duration;
		this.caloriesBurnt = caloriesBurnt;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<ExerciseQuantity> getExercises() {
		return exercises;
	}
	public void setExercises(List<ExerciseQuantity> exercises) {
		this.exercises = exercises;
	}
	public WorkoutType getType() {
		return type;
	}
	public void setType(WorkoutType type) {
		this.type = type;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCaloriesBurnt() {
		return caloriesBurnt;
	}
	public void setCaloriesBurnt(int caloriesBurnt) {
		this.caloriesBurnt = caloriesBurnt;
	}
	
	
}
