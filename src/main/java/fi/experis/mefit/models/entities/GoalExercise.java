package fi.experis.mefit.models.entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import fi.experis.mefit.models.dtos.idDtos.ExerciseIdDTO;

import javax.persistence.*;

@Entity(name = "goal_exercise")
public class GoalExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "goal_exercise_id")
    private Long goalExerciseId;

    @Column
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @JsonGetter("exercise")
    public ExerciseIdDTO workoutGetter() {
        if (exercise != null) {
            return new ExerciseIdDTO(exercise.getExerciseId());
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

    public GoalExercise(Long goalExerciseId, boolean completed, Exercise exercise, Goal goal) {
        this.goalExerciseId = goalExerciseId;
        this.completed = completed;
        this.exercise = exercise;
        this.goal = goal;
    }

    public Long getGoalExerciseId() {
        return goalExerciseId;
    }

    public void setGoalExerciseId(Long goalExerciseId) {
        this.goalExerciseId = goalExerciseId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
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
                ", completed=" + completed +
                ", exercise=" + exercise +
                ", goal=" + goal +
                '}';
    }
}
