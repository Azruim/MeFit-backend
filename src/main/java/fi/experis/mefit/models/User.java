package fi.experis.mefit.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column
    private String password;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private boolean isContributor;

    @Column
    private boolean isAdmin;



}
