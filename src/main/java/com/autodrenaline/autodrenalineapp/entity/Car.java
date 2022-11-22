package com.autodrenaline.autodrenalineapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;
    private short horsePower;
    private short yearOfProduction;
    private int mileage;
    boolean currentlyAvailable;

    public Car() {
    }

    public Car(String brand, String model, short horsePower, short yearOfProduction, int mileage, boolean currentlyAvailable) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
        this.yearOfProduction = yearOfProduction;
        this.mileage = mileage;
        this.currentlyAvailable = currentlyAvailable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public short getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(short horsePower) {
        this.horsePower = horsePower;
    }

    public short getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(short yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public boolean isCurrentlyAvailable() {
        return currentlyAvailable;
    }

    public void setCurrentlyAvailable(boolean currentlyAvailable) {
        this.currentlyAvailable = currentlyAvailable;
    }

}
