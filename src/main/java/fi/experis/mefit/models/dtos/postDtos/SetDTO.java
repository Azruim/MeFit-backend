package fi.experis.mefit.models.dtos.postDtos;

import fi.experis.mefit.models.dtos.goalDto.ExerciseDTO;

public class SetDTO {

    private Long setId;
    private int exerciseRepetitions;
    private ExerciseDTO exercise;

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

    public ExerciseDTO getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseDTO exercise) {
        this.exercise = exercise;
    }
}