package fi.experis.mefit.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exercise_id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String target_muscle_group;

    @Column
    private String image;

    @Column
    private String vid_link;
}
