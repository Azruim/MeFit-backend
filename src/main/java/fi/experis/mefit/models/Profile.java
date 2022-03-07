package fi.experis.mefit.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profile_id;

    @Column
    private double weight;

    @Column
    private double height;

    @Column
    private String medical_conditions;

    @Column
    private String disabilities;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Long user_id;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Long address_id;

    @OneToMany
    @JoinColumn(name = "set_id")
    List<Set> sets;

    @OneToMany
    @JoinColumn(name = "workout_id")
    List<Workout> workouts;

    @OneToMany
    @JoinColumn(name = "program_id")
    List<Program> programs;

}
