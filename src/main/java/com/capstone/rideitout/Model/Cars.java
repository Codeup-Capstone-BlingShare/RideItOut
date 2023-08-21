package com.capstone.rideitout.Model;

import jakarta.persistence.*;

@Entity
@Table(name= "cars")
public class Cars {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
         private long id;

     @Column(name="make")
    private String make;

     @Column(name="model")
    private String model;

     @Column(name = "year")
     private int year;

     @Column(name = "mileage")
     private int mileage;

     @Column(name = "is_available")
    private boolean isAvailable;

     @Column(name = "rented")
    private boolean rented;

     @Column(name = "price_per_day")
    private int pricePerDay;

     @Column(name = "car_location_zip")
    private int CarLocationZip;

     @Column(name = "user_id")
    private long userID;

    public Cars() {
    }

    public Cars(long id, String make, String model, int year, int mileage, boolean isAvailable, boolean rented, int pricePerDay, int carLocationZip, long userID) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.isAvailable = isAvailable;
        this.rented = rented;
        this.pricePerDay = pricePerDay;
        CarLocationZip = carLocationZip;
        this.userID = userID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getCarLocationZip() {
        return CarLocationZip;
    }

    public void setCarLocationZip(int carLocationZip) {
        CarLocationZip = carLocationZip;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
