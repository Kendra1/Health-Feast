package sbnz.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import sbnz.enumeration.WorkoutType;

@Entity
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	@JoinTable(
			 name = "workout_exercises_quantity", 
			 joinColumns = @JoinColumn(name = "workout_id"), 
			 inverseJoinColumns = @JoinColumn(name = "exercise_id"))
	private List<ExerciseQuantity> exercises;
	
	@Enumerated(EnumType.STRING)
	private WorkoutType workoutType;
	private int duration;
	private int caloriesBurnt;
	
	public Workout () {}
	
	public Workout(List<ExerciseQuantity> exercises, WorkoutType type, int duration, int caloriesBurnt) {
		this.exercises = exercises;
		this.setWorkoutType(type);
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

	public WorkoutType getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(WorkoutType workoutType) {
		this.workoutType = workoutType;
	}
	
	@Override
	public String toString() {
		return "Workout [id=" + id + ", exercises=" + exercises + ", workoutType=" + workoutType + ", duration="
				+ duration + ", caloriesBurnt=" + caloriesBurnt + "]";
	}

}
