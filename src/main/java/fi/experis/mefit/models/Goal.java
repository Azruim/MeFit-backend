package fi.experis.mefit.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goalId;

    @Column
    private Date endDate;

    @Column
    private boolean archived;

    // TODO add program_id foreign key
}
