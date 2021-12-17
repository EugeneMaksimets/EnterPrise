package entity;

public class Address {
    private long id;

    private String street;
    private int houseNumber;
    private int apartment;

    public Address() {

    }

    public Address(long id, String street, int houseNumber, int apartment) {
        this.id = id;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartment = apartment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartment=" + apartment +
                '}';
    }

}
