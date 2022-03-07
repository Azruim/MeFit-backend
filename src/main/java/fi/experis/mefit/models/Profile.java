package fi.experis.mefit.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long profileId;

    @Column
    private double weight;

    @Column
    private double height;

    @Column(name = "medical_conditions")
    private String medicalConditions;

    @Column
    private String disabilities;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

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
