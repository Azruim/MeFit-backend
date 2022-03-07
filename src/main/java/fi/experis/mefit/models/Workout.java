package fi.experis.mefit.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workoutId;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private boolean complete;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "program_workout", joinColumns = { @JoinColumn(name = "workoutId")},inverseJoinColumns = {
            @JoinColumn(name = "programId")})
    private List<Program> programs;

    @OneToMany(mappedBy = "workout")
    private List<GoalWorkout> goalWorkouts;

}
