package sbnz.model.drools;

import java.util.ArrayList;
import java.util.List;

public class PrioritizedWorkouts {

	private List<PrioritizedWorkout> workouts = new ArrayList<>();

	public PrioritizedWorkouts () {}

	public List<PrioritizedWorkout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<PrioritizedWorkout> workouts) {
		this.workouts = workouts;
	}
}
