package fi.experis.mefit.models.dtos.getDtos;

import fi.experis.mefit.models.dtos.nestedDtos.WorkoutProgramDTO;

import java.util.List;

public class ProgramGetDTO {
    private Long programId;
    private String name;
    private String category;
    private List<WorkoutGetDTO> workouts;

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

    public List<WorkoutGetDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutGetDTO> workouts) {
        this.workouts = workouts;
    }
}
