package fi.experis.mefit.models.dtos.goalDto;

public class ExerciseGoalDTO {

    private Long exerciseId;

    public ExerciseGoalDTO() {
    }

    public ExerciseGoalDTO(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }
}
