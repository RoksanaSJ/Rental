package com.roxys.rental.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

public class CustomerDetails {
    long id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String adress;
    String city;

    public CustomerDetails(long id, String firstName, String lastName,
                           LocalDate dateOfBirth,String adress, String city){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.adress = adress;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
