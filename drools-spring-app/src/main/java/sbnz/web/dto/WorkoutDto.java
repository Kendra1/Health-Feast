package sbnz.web.dto;

import java.util.List;

import sbnz.enumeration.WorkoutType;

public class WorkoutDto {
	
	private List<ExerciseDto> exercises;
	private WorkoutType workoutType;
	private int duration;
	private int caloriesBurnt;
	
	public WorkoutDto () {}
	
	public List<ExerciseDto> getExercises() {
		return exercises;
	}
	public void setExercises(List<ExerciseDto> exercises) {
		this.exercises = exercises;
	}
	public WorkoutType getWorkoutType() {
		return workoutType;
	}
	public void setWorkoutType(WorkoutType workoutType) {
		this.workoutType = workoutType;
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
