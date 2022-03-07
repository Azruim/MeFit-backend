package fi.experis.mefit.models;

import javax.persistence.*;

@Entity
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "set_id")
    private Long setId;

    @Column(name = "exercise_repetitions")
    private int exerciseRepetitions;

    @OneToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;


}
