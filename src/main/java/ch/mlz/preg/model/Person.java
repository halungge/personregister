package ch.mlz.preg.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Person {
    private long id;
    @JsonProperty("lastname")
    private String name;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("gender")
    private Gender gender;
    @JsonProperty("address")
    private Address address;
    private LocalDate birthday;

    public Person(long id, String name, String firstName, Gender gender, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.gender = gender;
        this.birthday = birthday;
    }

    //Default constructor for libraries (Jackson, hibernate, etc
    private Person(){}

    @Id
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
