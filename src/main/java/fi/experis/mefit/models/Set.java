package fi.experis.mefit.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int exercise_repetitions;

    @OneToOne
    @JoinColumn(name = "exercise_id")
    private Long exercise_id;


}
