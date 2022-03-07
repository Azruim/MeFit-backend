package fi.experis.mefit.models;

import javax.persistence.*;

@Entity
public class GoalWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goalWorkoutId;

    @ManyToOne
    @JoinColumn(name = "workoutId")
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "goalId")
    private Workout goal;
}
