package fi.experis.mefit.models.dtos.goalDto;

public class GoalExerciseDTO {

    private boolean completed;
    private ExerciseGoalDTO exercise;

    public GoalExerciseDTO() {
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ExerciseGoalDTO getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseGoalDTO exercise) {
        this.exercise = exercise;
    }
}
