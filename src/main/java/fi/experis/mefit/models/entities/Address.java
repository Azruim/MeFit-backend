package fi.experis.mefit.models.entities;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(columnDefinition = "varchar(100)")
    private String addressLine_1;

    @Column(columnDefinition = "varchar(100)")
    private String addressLine_2;

    @Column(columnDefinition = "varchar(100)")
    private String addressLine_3;

    @Column(columnDefinition = "varchar(10)")
    private String postalCode;

    @Column(columnDefinition = "varchar(60)")
    private String city;

    @Column(columnDefinition = "varchar(60)")
    private String country;

    public Address() {
        super();
    }

    public Address(Long addressId, String addressLine_1, String addressLine_2, String addressLine_3, String postalCode, String city, String country) {
        this.addressId = addressId;
        this.addressLine_1 = addressLine_1;
        this.addressLine_2 = addressLine_2;
        this.addressLine_3 = addressLine_3;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressLine_1() {
        return addressLine_1;
    }

    public void setAddressLine_1(String addressLine_1) {
        this.addressLine_1 = addressLine_1;
    }

    public String getAddressLine_2() {
        return addressLine_2;
    }

    public void setAddressLine_2(String addressLine_2) {
        this.addressLine_2 = addressLine_2;
    }

    public String getAddressLine_3() {
        return addressLine_3;
    }

    public void setAddressLine_3(String addressLine_3) {
        this.addressLine_3 = addressLine_3;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", addressLine1='" + addressLine_1 + '\'' +
                ", addressLine2='" + addressLine_2 + '\'' +
                ", addressLine3='" + addressLine_3 + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
