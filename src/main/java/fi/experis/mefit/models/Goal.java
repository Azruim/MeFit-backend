package fi.experis.mefit.models;

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

    @OneToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @OneToMany(mappedBy = "goal")
    private List<GoalWorkout> goalWorkouts;

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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public List<GoalWorkout> getGoalWorkouts() {
        return goalWorkouts;
    }

    public void setGoalWorkouts(List<GoalWorkout> goalWorkouts) {
        this.goalWorkouts = goalWorkouts;
    }
}
