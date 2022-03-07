package fi.experis.mefit.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goalId;

    @Column
    private Date endDate;

    @Column
    private boolean archived;

    @OneToOne
    @JoinColumn(name = "programId")
    private Program program;

    @OneToMany(mappedBy = "goal")
    private List<GoalWorkout> goalWorkouts;
}
