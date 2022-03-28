package fi.experis.mefit.models.dtos.workoutDtos;

import fi.experis.mefit.models.entities.Exercise;

import java.util.List;

public class GetWorkoutDTO {

    private Long workoutId;
    private String name;
    private String type;
    private List<WorkoutSetDTO> sets;

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<WorkoutSetDTO> getSets() {
        return sets;
    }

    public void setSets(List<WorkoutSetDTO> sets) {
        this.sets = sets;
    }

    public static class WorkoutSetDTO {

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
}
