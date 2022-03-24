package fi.experis.mefit.models.entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import fi.experis.mefit.models.dtos.goalDto.ExerciseDTO;

import javax.persistence.*;

@Entity(name = "goal_exercise")
public class GoalExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "goal_exercise_id")
    private Long goalExerciseId;

    @Column(columnDefinition = "boolean default false")
    private boolean complete;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @JsonGetter("exercise")
    public ExerciseDTO workoutGetter() {
        if (exercise != null) {
            return new ExerciseDTO(exercise.getExerciseId());
        }
        return null;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "goal_id")
    private Goal goal;

    public GoalExercise() {
        super();
    }

    public GoalExercise(Long goalExerciseId, boolean complete, Exercise exercise, Goal goal) {
        this.goalExerciseId = goalExerciseId;
        this.complete = complete;
        this.exercise = exercise;
        this.goal = goal;
    }

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

    @Override
    public String toString() {
        return "GoalExercise{" +
                "goalExerciseId=" + goalExerciseId +
                ", complete=" + complete +
                ", exercise=" + exercise +
                ", goal=" + goal +
                '}';
    }
}
