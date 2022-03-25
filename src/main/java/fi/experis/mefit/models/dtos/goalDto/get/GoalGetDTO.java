package fi.experis.mefit.models.dtos.goalDto.get;

import fi.experis.mefit.models.dtos.goalDto.post.GoalExerciseDTO;
import fi.experis.mefit.models.dtos.goalDto.post.GoalWorkoutDTO;
import fi.experis.mefit.models.dtos.idDtos.ProfileIdlDTO;
import fi.experis.mefit.models.dtos.idDtos.ProgramIdDTO;

import java.util.Date;
import java.util.List;

public class GoalGetDTO {

    private Long goalId;
    private Date endDate;
    private Date startDate;
    private Boolean achieved;
    private ProfileIdlDTO profile;
    private ProgramIdDTO program;
    private List<GoalWorkoutGetDTO> workouts;
    private List<GoalExerciseGetDTO> exercises;

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

    public List<GoalWorkoutGetDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<GoalWorkoutGetDTO> workouts) {
        this.workouts = workouts;
    }

    public List<GoalExerciseGetDTO> getExercises() {
        return exercises;
    }

    public void setExercises(List<GoalExerciseGetDTO> exercises) {
        this.exercises = exercises;
    }
}
