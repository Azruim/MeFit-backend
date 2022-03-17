package fi.experis.mefit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Long goalId;

    @Column(name = "end_date")
    private Date endDate;

    @Column
    private boolean achieved;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @ManyToMany
    @JoinTable(
            name = "goal_workout",
            joinColumns = { @JoinColumn(name = "goal_id")},
            inverseJoinColumns = {@JoinColumn(name = "workout_id")})
    private List<Workout> workouts;

    @ManyToMany
    @JoinTable(
            name = "goal_exercise",
            joinColumns = { @JoinColumn(name = "goal_id")},
            inverseJoinColumns = {@JoinColumn(name = "exercise_id")})
    private List<Exercise> exercises;

    public Goal() {
        super();
    }

    public Goal(Long goalId, Date endDate, boolean achieved, Profile profile, Program program, List<Workout> workouts, List<Exercise> exercises) {
        this.goalId = goalId;
        this.endDate = endDate;
        this.achieved = achieved;
        this.profile = profile;
        this.program = program;
        this.workouts = workouts;
        this.exercises = exercises;
    }

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

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goalId=" + goalId +
                ", endDate=" + endDate +
                ", achieved=" + achieved +
                ", profile=" + profile +
                ", program=" + program +
                ", workouts=" + workouts +
                ", exercises=" + exercises +
                '}';
    }
}

