package fi.experis.mefit.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Long goalId;

    @Column(name = "end_date")
    private Date endDate;

    @Column
    private boolean achieved;

    @OneToOne
    @JoinColumn(name = "programId")
    private Program program;

    @OneToMany(mappedBy = "goal")
    private List<GoalWorkout> goalWorkouts;
}
