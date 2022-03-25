package fi.experis.mefit.models.dtos.goalDto.post;

import fi.experis.mefit.models.dtos.idDtos.ProfileIdlDTO;
import fi.experis.mefit.models.dtos.idDtos.ProgramIdDTO;

import java.util.Date;
import java.util.List;

public class GoalPostDTO {

    private Date endDate;
    private Date startDate;
    private Boolean achieved;
    private ProfileIdlDTO profile;
    private ProgramIdDTO program;
    private List<GoalWorkoutDTO> workouts;
    private List<GoalExerciseDTO> exercises;

    public GoalPostDTO() {
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Boolean getAchieved() {
        return achieved;
    }

    public void setAchieved(Boolean achieved) {
        this.achieved = achieved;
    }

    public ProfileIdlDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileIdlDTO profile) {
        this.profile = profile;
    }

    public ProgramIdDTO getProgram() {
        return program;
    }

    public void setProgram(ProgramIdDTO program) {
        this.program = program;
    }

    public List<GoalWorkoutDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<GoalWorkoutDTO> workouts) {
        this.workouts = workouts;
    }

    public List<GoalExerciseDTO> getExercises() {
        return exercises;
    }

    public void setExercises(List<GoalExerciseDTO> exercises) {
        this.exercises = exercises;
    }
}