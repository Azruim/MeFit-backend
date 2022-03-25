package fi.experis.mefit.models.dtos.workoutDtos.post;

import fi.experis.mefit.models.dtos.idDtos.ExerciseIdDTO;

public class WorkoutPostSetDTO {

    private Long setId;
    private int exerciseRepetitions;
    private ExerciseIdDTO exercise;

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

    public ExerciseIdDTO getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseIdDTO exercise) {
        this.exercise = exercise;
    }
}
