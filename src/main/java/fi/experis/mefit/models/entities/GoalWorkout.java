package fi.experis.mefit.models.entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import fi.experis.mefit.models.dtos.idDtos.WorkoutIdDTO;

import javax.persistence.*;

@Entity(name = "goal_workout")
public class GoalWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "goal_workout_id")
    private Long goalWorkoutId;

    @Column
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @JsonGetter("workout")
    public WorkoutIdDTO workoutGetter() {
        if (workout != null) {
            return new WorkoutIdDTO(workout.getWorkoutId());
        }
        return null;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "goal_id")
    private Goal goal;

    public GoalWorkout() {
        super();
    }

    public GoalWorkout(Long goalWorkoutId, boolean completed, Workout workout, Goal goal) {
        this.goalWorkoutId = goalWorkoutId;
        this.completed = completed;
        this.workout = workout;
        this.goal = goal;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "GoalWorkout{" +
                "goalWorkoutId=" + goalWorkoutId +
                ", complete=" + completed +
                ", workout=" + workout +
                ", goal=" + goal +
                '}';
    }

    public Long getGoalWorkoutId() {
        return goalWorkoutId;
    }

    public void setGoalWorkoutId(Long goalWorkoutId) {
        this.goalWorkoutId = goalWorkoutId;
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

}
