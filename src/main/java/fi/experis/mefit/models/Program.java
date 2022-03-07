package fi.experis.mefit.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programId;

    @Column
    private String name;

    @Column
    private String category;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "program_workout", joinColumns = { @JoinColumn(name = "programId")}, inverseJoinColumns = {
            @JoinColumn(name = "workoutId")})
    private List<Workout> workouts;
}
