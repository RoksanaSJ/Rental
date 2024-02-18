package com.roxys.rental.model;

public class CarDetails {
    long id;
    String brand;
    String model;
    String type;
    String registrationNumber;
    String gearboxType;
    String fuelType;

    public CarDetails(long id, String brand, String model, String type, String registrationNumber, String gearboxType, String fuelType) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.gearboxType = gearboxType;
        this.fuelType = fuelType;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "CarDetails{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", gearboxType='" + gearboxType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
