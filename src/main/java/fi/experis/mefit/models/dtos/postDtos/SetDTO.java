package fi.experis.mefit.models.dtos.postDtos;

import fi.experis.mefit.models.dtos.nestedDtos.ExerciseGoalDTO;

public class SetDTO {

    private Long setId;
    private int exerciseRepetitions;
    private ExerciseGoalDTO exercise;

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

    public ExerciseGoalDTO getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseGoalDTO exercise) {
        this.exercise = exercise;
    }
}