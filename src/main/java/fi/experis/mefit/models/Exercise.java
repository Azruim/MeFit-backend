package fi.experis.mefit.models;

import javax.persistence.*;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exerciseId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String targetMuscleGroup;

    @Column
    private String image;

    @Column
    private String vidLink;
}
