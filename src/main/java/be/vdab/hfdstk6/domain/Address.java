package be.vdab.hfdstk6.domain;

import org.hibernate.annotations.Cache;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "STREET")
    private String street;
    @Column(name = "NUMB")
    private String number;
    @Column(name = "ZIPCODE")
    private String zipCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY")
    private String country;

    public Address() {
    }

    public Address(String street, String number, String zipCode, String city, String country) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
