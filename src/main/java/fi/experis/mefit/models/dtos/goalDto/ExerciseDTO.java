package fi.experis.mefit.models.dtos.goalDto;

public class ExerciseDTO {

    private Long exerciseId;

    public ExerciseDTO(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }
}
