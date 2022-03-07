package fi.experis.mefit.models;

import javax.persistence.*;

@Entity
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long setId;

    @Column
    private int exerciseRepetitions;

    @OneToOne
    @JoinColumn(name = "exerciseId")
    private Exercise exercise;


}
