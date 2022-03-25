package fi.experis.mefit.models.dtos.goalDto.post;

import fi.experis.mefit.models.dtos.idDtos.WorkoutIdDTO;

public class GoalWorkoutDTO {

    private boolean completed;
    private WorkoutIdDTO workout;

    public GoalWorkoutDTO() {
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public WorkoutIdDTO getWorkout() {
        return workout;
    }

    public void setWorkout(WorkoutIdDTO workout) {
        this.workout = workout;
    }
}
