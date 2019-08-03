package ch.mlz.preg.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("street")
    private String street;
    @JsonProperty("place")
    private String place;
    @JsonProperty("zip")
    private Long zipCode;
    @JsonProperty("housenr")
    private Long houseNumber;

    public Address(String street, Long houseNumber, Long zipCode, String place) {
        this.street = street;
        this.place = place;
        this.zipCode = zipCode;
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getPlace() {
        return place;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public Long getHouseNumber() {
        return houseNumber;
    }
}
