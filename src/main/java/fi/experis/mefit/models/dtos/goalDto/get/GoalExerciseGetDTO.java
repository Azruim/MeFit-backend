package fi.experis.mefit.models.dtos.goalDto.get;

import fi.experis.mefit.models.entities.Exercise;

public class GoalExerciseGetDTO {
    private boolean completed;
    private Exercise exercise;

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
