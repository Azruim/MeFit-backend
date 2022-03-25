package fi.experis.mefit.models.dtos.getDtos;

import fi.experis.mefit.models.dtos.goalDto.GoalExerciseDTO;
import fi.experis.mefit.models.dtos.goalDto.GoalWorkoutDTO;
import fi.experis.mefit.models.dtos.goalDto.ProfileGoalDTO;
import fi.experis.mefit.models.dtos.goalDto.ProgramGoalDTO;

import java.util.Date;
import java.util.List;

public class GoalGetDTO {

    private Long goalId;
    private Date endDate;
    private Date startDate;
    private Boolean achieved;
    private ProfileGoalDTO profile;
    private ProgramGoalDTO program;
    private List<GoalWorkoutDTO> workouts;
    private List<GoalExerciseDTO> exercises;

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
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

    public ProfileGoalDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileGoalDTO profile) {
        this.profile = profile;
    }

    public ProgramGoalDTO getProgram() {
        return program;
    }

    public void setProgram(ProgramGoalDTO program) {
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
