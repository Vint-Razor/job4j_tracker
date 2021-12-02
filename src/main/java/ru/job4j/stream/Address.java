package ru.job4j.stream;

import java.util.Objects;

public class Address implements Comparable<Address> {
    private String city;
    private String street;
    private String home;
    private int apartment;

    public Address(String city, String street, String home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street)
                && Objects.equals(home, address.home);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

    @Override
    public int compareTo(Address o) {
        return city.compareTo(o.getCity());
    }
}
