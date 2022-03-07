package fi.experis.mefit.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goal_id;

    @Column
    private Date end_date;

    @Column
    private boolean archived;

    // TODO add program_id foreign key
}
