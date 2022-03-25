package fi.experis.mefit.models.dtos.getDtos;

import fi.experis.mefit.models.dtos.nestedDtos.SetExerciseDTO;

import java.util.List;

public class WorkoutGetDTO {

    private Long workoutId;
    private String name;
    private String type;
    private List<SetExerciseDTO> sets;

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

    public List<SetExerciseDTO> getSets() {
        return sets;
    }

    public void setSets(List<SetExerciseDTO> sets) {
        this.sets = sets;
    }
}
