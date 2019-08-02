package ch.mlz.preg.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.data.annotation.Id;

public class Person {
    private long id;
    private String name;
    private String firstName;
    private Gender gender;
    private Address address;

    public Person(long id, String name, String firstName, Gender gender) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.gender = gender;
    }

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
}
