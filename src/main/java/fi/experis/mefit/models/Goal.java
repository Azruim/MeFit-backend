package fi.experis.mefit.models;

import javax.persistence.*;
import java.util.Date;

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

    // TODO add program_id foreign key
}
