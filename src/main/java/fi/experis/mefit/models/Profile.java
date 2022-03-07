package fi.experis.mefit.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column
    private double weight;

    @Column
    private double height;

    @Column
    private String medicalConditions;

    @Column
    private String disabilities;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    @JoinColumn(name = "addressId")
    private Address address;

    @OneToMany
    @JoinColumn(name = "setId")
    List<Set> sets;

    @OneToMany
    @JoinColumn(name = "workoutId")
    List<Workout> workouts;

    @OneToMany
    @JoinColumn(name = "programId")
    List<Program> programs;

}
