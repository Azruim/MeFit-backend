package fi.experis.mefit.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
}
