package fi.experis.mefit.models.dtos.goalDto;

public class WorkoutGoalDTO {

    private Long workoutId;

    public WorkoutGoalDTO(Long workoutId) {
        this.workoutId = workoutId;
    }

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }
}
