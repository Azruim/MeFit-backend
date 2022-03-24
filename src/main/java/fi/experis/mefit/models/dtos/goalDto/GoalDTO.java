package fi.experis.mefit.models.dtos.goalDto;

import fi.experis.mefit.models.entities.GoalExercise;
import fi.experis.mefit.models.entities.GoalWorkout;

import java.util.Date;
import java.util.List;

public class GoalDTO {

    private Date endDate;
    private Date startDate;
    private Boolean achieved;
    private ProfileGoalDTO profile;
    private ProgramGoalDTO program;
    private List<GoalWorkout> workouts;
    private List<GoalExercise> exercises;

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

    public List<GoalWorkout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<GoalWorkout> workouts) {
        this.workouts = workouts;
    }

    public List<GoalExercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<GoalExercise> exercises) {
        this.exercises = exercises;
    }
}
