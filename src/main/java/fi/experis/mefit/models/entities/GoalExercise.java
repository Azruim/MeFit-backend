package fi.experis.mefit.models.entities;

import javax.persistence.*;

@Entity(name = "goal_exercise")
public class GoalExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_exericse_id")
    private Long goalExerciseId;

    @Column(columnDefinition = "boolean default false")
    private boolean complete;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    public Long getGoalExerciseId() {
        return goalExerciseId;
    }

    public void setGoalExerciseId(Long goalExerciseId) {
        this.goalExerciseId = goalExerciseId;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
