package fi.experis.mefit.models;

import javax.persistence.*;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long exerciseId;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "target_muscle_group")
    private String targetMuscleGroup;

    @Column
    private String image;

    @Column(name = "vid_link")
    private String vidLink;
}
