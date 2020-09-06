package sbnz.web.dto;

public class ExerciseQuantityDto {

	private ExerciseDto exercise;
	
	private int repetitions;

	public ExerciseQuantityDto () {}

	public ExerciseDto getExercise() {
		return exercise;
	}

	public void setExercise(ExerciseDto exercise) {
		this.exercise = exercise;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}
}
