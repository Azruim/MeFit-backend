package fi.experis.mefit.models.dtos.goalDto.post;

import fi.experis.mefit.models.dtos.idDtos.ExerciseIdDTO;

public class GoalExerciseDTO {

    private boolean completed;
    private ExerciseIdDTO exercise;

    public GoalExerciseDTO() {
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ExerciseIdDTO getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseIdDTO exercise) {
        this.exercise = exercise;
    }
}
