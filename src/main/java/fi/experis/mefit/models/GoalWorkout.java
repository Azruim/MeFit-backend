package fi.experis.mefit.models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "goal_workout")
public class GoalWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_workout_id")
    private Long goalWorkoutId;

    @Column
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    public GoalWorkout() {
        super();
    }

    public GoalWorkout(Long goalWorkoutId, Date endDate, Workout workout, Goal goal) {
        this.goalWorkoutId = goalWorkoutId;
        this.endDate = endDate;
        this.workout = workout;
        this.goal = goal;
    }

    public Long getGoalWorkoutId() {
        return goalWorkoutId;
    }

    public void setGoalWorkoutId(Long goalWorkoutId) {
        this.goalWorkoutId = goalWorkoutId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "GoalWorkout{" +
                "goalWorkoutId=" + goalWorkoutId +
                ", endDate=" + endDate +
                ", workout=" + workout +
                ", goal=" + goal +
                '}';
    }
}
