package fi.experis.mefit.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int exerciseRepetitions;


}
