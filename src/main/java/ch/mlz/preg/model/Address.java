package ch.mlz.preg.model;


public class Address {
    private String street;
    private String place;
    private Long zipCode;
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
