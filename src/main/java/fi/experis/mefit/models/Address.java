package fi.experis.mefit.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;

    @Column
    private String address_line_1;

    @Column
    private String address_line_2;

    @Column
    private String address_line_3;

    @Column
    private String postal_code;

    @Column
    private String city;

    @Column
    private String country;

}
