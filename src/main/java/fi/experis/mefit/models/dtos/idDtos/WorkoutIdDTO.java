package fi.experis.mefit.models.dtos.idDtos;

public class WorkoutIdDTO {

    private Long workoutId;

    public WorkoutIdDTO() {
    }

    public WorkoutIdDTO(Long workoutId) {
        this.workoutId = workoutId;
    }

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }
}
