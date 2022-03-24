package fi.experis.mefit.models.dtos.postDtos;

import fi.experis.mefit.models.dtos.nestedDtos.WorkoutProgramDTO;

import java.util.List;

public class ProgramDTO {

    private String name;
    private String category;
    private List<WorkoutProgramDTO> workouts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<WorkoutProgramDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutProgramDTO> workouts) {
        this.workouts = workouts;
    }
}