package sbnz.web.dto;

import java.util.List;

public class WorkoutFilterDto {
	
	private List<String> exercises;
	private String workoutType;
	private Integer fromDuration;
	private Integer toDuration;
	private Integer fromCaloriesBurnt;
	private Integer toCaloriesBurnt;
	
	public WorkoutFilterDto () {}

	public List<String> getExercises() {
		return exercises;
	}
	public void setExercises(List<String> exercises) {
		this.exercises = exercises;
	}
	public String getWorkoutType() {
		return workoutType;
	}
	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}
	public Integer getFromDuration() {
		return fromDuration;
	}
	public void setFromDuration(Integer fromDuration) {
		this.fromDuration = fromDuration;
	}
	public Integer getToDuration() {
		return toDuration;
	}
	public void setToDuration(Integer toDuration) {
		this.toDuration = toDuration;
	}
	public Integer getFromCaloriesBurnt() {
		return fromCaloriesBurnt;
	}
	public void setFromCaloriesBurnt(Integer fromCaloriesBurnt) {
		this.fromCaloriesBurnt = fromCaloriesBurnt;
	}
	public Integer getToCaloriesBurnt() {
		return toCaloriesBurnt;
	}
	public void setToCaloriesBurnt(Integer toCaloriesBurnt) {
		this.toCaloriesBurnt = toCaloriesBurnt;
	}
}
