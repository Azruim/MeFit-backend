package fi.experis.mefit.models;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column
    private String addressLine1;

    @Column
    private String addressLine2;

    @Column
    private String addressLine3;

    @Column
    private String postalCode;

    @Column
    private String city;

    @Column
    private String country;

}
