package be.vdab.hfdstk6.domain;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.xml.stream.FactoryConfigurationError;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Table(name = "PERSONS", indexes = {@Index(name = "LAST_NAME_INDEX", columnList = "LAST_NAME"),
    @Index(name = "BIRTHDAY_INDEX", columnList = "BIRTHDAY")})
@SecondaryTable(name = "URLS")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long personId;
    @Version
    @Column(name = "VERSION")
    private long version;
    @Column(name = "FIRST_NAME", length = 40, nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", length = 40, nullable = false)
    private String lastName;
    @Column(name = "BIRTHDAY")
    private LocalDate birthday;
    @Column(name = "GENDER", length = 10, nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    @Column(name = "PICTURE")
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] picture;
    @Column(name = "COMMNT")
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String comment;
    @Column(name = "MARRIED",columnDefinition = "BOOLEAN")
    private boolean married;
    @Transient
    private int age;
    @Column(name = "HOMEPAGE", length = 255, table = "URLS")
    private String homepage;

    public Person() {
    }

    public Person(String firstName, String lastName, GenderType gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public long getPersonId() {
        return personId;
    }

    public long getVersion() {
        return version;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public GenderType getGender() {
        return gender;
    }

    public byte[] getPicture() {
        return picture;
    }

    public String getComment() {
        return comment;
    }

    public boolean isMarried() {
        return married;
    }

    public int getAge() {
        return age;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", version=" + version +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", picture=" + Arrays.toString(picture) +
                ", comment='" + comment + '\'' +
                ", married=" + married +
                ", age=" + age +
                ", homepage='" + homepage + '\'' +
                '}';
    }
}
