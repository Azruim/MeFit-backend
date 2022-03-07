package fi.experis.mefit.models;

import javax.persistence.*;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private Long workoutId;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private boolean complete;

    // TODO add set_id foreign key
}
