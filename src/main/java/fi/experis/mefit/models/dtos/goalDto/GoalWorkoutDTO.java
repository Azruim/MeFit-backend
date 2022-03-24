package fi.experis.mefit.models.dtos.goalDto;

public class GoalWorkoutDTO {

    private boolean completed;
    private WorkoutGoalDTO workout;

    public GoalWorkoutDTO() {
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public WorkoutGoalDTO getWorkout() {
        return workout;
    }

    public void setWorkout(WorkoutGoalDTO workout) {
        this.workout = workout;
    }
}
