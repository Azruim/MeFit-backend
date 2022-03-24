package fi.experis.mefit.models.dtos.postDtos;

import fi.experis.mefit.models.dtos.postDtos.SetDTO;

import java.util.List;

public class WorkoutDTO {

    private String name;
    private String type;
    private List<SetDTO> sets;

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