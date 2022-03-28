package fi.experis.mefit.models.dtos.programDtos;

import fi.experis.mefit.models.dtos.workoutDtos.GetWorkoutDTO;

import java.util.List;

public class GetProgramDTO {
    private Long programId;
    private String name;
    private String category;
    private List<GetWorkoutDTO> workouts;

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

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

    public List<GetWorkoutDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<GetWorkoutDTO> workouts) {
        this.workouts = workouts;
    }
}
