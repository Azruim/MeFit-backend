package fi.experis.mefit.models.dtos.programDtos.post;

import fi.experis.mefit.models.dtos.idDtos.WorkoutIdDTO;

import java.util.List;

public class ProgramPostDTO {

    private String name;
    private String category;
    private List<WorkoutIdDTO> workouts;

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

    public List<WorkoutIdDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutIdDTO> workouts) {
        this.workouts = workouts;
    }
}