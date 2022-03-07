package fi.experis.mefit.models;

import javax.persistence.*;

@Entity(name = "goal_workout")
public class GoalWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goalWorkoutId;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;
}
