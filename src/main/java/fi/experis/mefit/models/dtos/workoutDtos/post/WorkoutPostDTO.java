package fi.experis.mefit.models.dtos.workoutDtos.post;

import java.util.List;

public class WorkoutPostDTO {

    private String name;
    private String type;
    private List<WorkoutPostSetDTO> sets;

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

    public List<WorkoutPostSetDTO> getSets() {
        return sets;
    }

    public void setSets(List<WorkoutPostSetDTO> sets) {
        this.sets = sets;
    }
}
