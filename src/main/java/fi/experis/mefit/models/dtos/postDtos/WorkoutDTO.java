package fi.experis.mefit.models.dtos.postDtos;

import fi.experis.mefit.models.entities.Workout;

import java.util.List;

public class WorkoutDTO {

    private Long workoutId;
    private String name;
    private String type;
    private List<SetDTO> sets;

    public WorkoutDTO(Workout workout) {
        this.workoutId = workout.getWorkoutId();
        this.name = workout.getName();
        this.type = workout.getType();
    }

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

    public List<SetDTO> getSets() {
        return sets;
    }

    public void setSets(List<SetDTO> sets) {
        this.sets = sets;
    }
}