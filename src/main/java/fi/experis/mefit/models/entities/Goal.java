package fi.experis.mefit.models.entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Long goalId;

    @Column(columnDefinition = "timestamp")
    private Date endDate;

    @Column(columnDefinition = "timestamp")
    private Date startDate;

    @Column
    private Boolean achieved;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<GoalExercise> goalExercises;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<GoalWorkout> goalWorkouts;

    public Goal() {
    }

    public Goal(Long goalId, Date endDate, Date startDate, Boolean achieved, Profile profile,
                Program program, List<GoalExercise> goalExercises, List<GoalWorkout> goalWorkouts) {
        this.goalId = goalId;
        this.endDate = endDate;
        this.startDate = startDate;
        this.achieved = achieved;
        this.profile = profile;
        this.program = program;
        this.goalExercises = goalExercises;
        this.goalWorkouts = goalWorkouts;
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

    public List<GoalExercise> getGoalExercises() {
        return goalExercises;
    }

    public void setGoalExercises(List<GoalExercise> goalExercises) {
        this.goalExercises = goalExercises;
    }

    public List<GoalWorkout> getGoalWorkouts() {
        return goalWorkouts;
    }

    public void setGoalWorkouts(List<GoalWorkout> goalWorkouts) {
        this.goalWorkouts = goalWorkouts;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goalId=" + goalId +
                ", endDate=" + endDate +
                ", startDate=" + startDate +
                ", achieved=" + achieved +
                ", profile=" + profile +
                ", program=" + program +
                ", goalExercises=" + goalExercises +
                ", goalWorkouts=" + goalWorkouts +
                '}';
    }
}

