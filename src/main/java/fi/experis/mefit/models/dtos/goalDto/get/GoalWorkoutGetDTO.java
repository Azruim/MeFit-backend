package fi.experis.mefit.models.dtos.goalDto.get;

import fi.experis.mefit.models.dtos.workoutDtos.get.WorkoutGetDTO;

public class GoalWorkoutGetDTO {

    private boolean completed;
    private WorkoutGetDTO workout;

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public WorkoutGetDTO getWorkout() {
        return workout;
    }

    public void setWorkout(WorkoutGetDTO workout) {
        this.workout = workout;
    }
}
