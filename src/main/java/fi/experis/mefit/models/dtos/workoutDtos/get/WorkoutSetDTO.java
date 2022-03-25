package fi.experis.mefit.models.dtos.workoutDtos.get;

import fi.experis.mefit.models.entities.Exercise;

public class WorkoutSetDTO {

    private Long setId;
    private int exerciseRepetitions;
    private Exercise exercise;

    public Long getSetId() {
        return setId;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
    }

    public int getExerciseRepetitions() {
        return exerciseRepetitions;
    }

    public void setExerciseRepetitions(int exerciseRepetitions) {
        this.exerciseRepetitions = exerciseRepetitions;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
