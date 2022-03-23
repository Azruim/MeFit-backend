package fi.experis.mefit.models.dtos;

import java.util.Date;
import java.util.List;

public class GoalDTO {

    private Long goalId;
    private Date endDate;
    private Date startDate;
    private Boolean achieved;
    private ProfileGoalDTO profile;
    private ProgramGoalDTO program;
    private List<WorkoutGoalDTO> workouts;
    private List<ExerciseGoalDTO> exercises;

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

    public List<WorkoutGoalDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutGoalDTO> workouts) {
        this.workouts = workouts;
    }

    public List<ExerciseGoalDTO> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseGoalDTO> exercises) {
        this.exercises = exercises;
    }
}
