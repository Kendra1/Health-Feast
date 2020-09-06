package sbnz.model.drools;

import sbnz.model.Workout;

public class PrioritizedWorkout {
	
	private Workout workout;
	
	private int priority;

	public PrioritizedWorkout () {}
	
	public PrioritizedWorkout (Workout workout, int priority) {
		this.workout = workout;
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	@Override
	public String toString() {
		return "PrioritizedWorkout [workout=" + workout + ", priority=" + priority + "]";
	}
}
