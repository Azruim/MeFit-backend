package fi.experis.mefit.models.dtos.idDtos;

public class ExerciseIdDTO {

    private Long exerciseId;

    public ExerciseIdDTO() {
    }

    public ExerciseIdDTO(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }
}
