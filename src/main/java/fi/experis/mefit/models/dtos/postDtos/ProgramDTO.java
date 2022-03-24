package fi.experis.mefit.models.dtos.postDtos;

import fi.experis.mefit.models.dtos.goalDto.WorkoutGoalDTO;

import java.util.List;

public class ProgramDTO {

    private Long programId;
    private String name;
    private String category;
    private List<WorkoutGoalDTO> workouts;

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

    public List<WorkoutGoalDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutGoalDTO> workouts) {
        this.workouts = workouts;
    }
}