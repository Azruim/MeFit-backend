package fi.experis.mefit.models;

import javax.persistence.*;

@Entity
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programId;

    @Column
    private String name;

    @Column
    private String category;
}
