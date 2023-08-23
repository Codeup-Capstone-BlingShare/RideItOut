package com.capstone.rideitout.Model;
import com.capstone.rideitout.Model.Trip;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "cars")
public class Car {
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
    private int carLocationZip;

//     @Column(name = "user_id")
//    private long userID;


     //*** This is giving me issues
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "car")
    private List<Trip> trips;

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public Car() {
    }

    public Car(long id, String make, String model, int year, int mileage, boolean isAvailable, boolean rented, int pricePerDay, int carLocationZip, Users user) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.isAvailable = isAvailable;
        this.rented = rented;
        this.pricePerDay = pricePerDay;
        this.carLocationZip = carLocationZip;
        this.user = user;
    }

    public Car(String make, String model, int year, int mileage, boolean isAvailable, int pricePerDay, int carLocationZip) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.isAvailable = isAvailable;
        this.pricePerDay = pricePerDay;
        this.carLocationZip = carLocationZip;
    }

    public Car(String make) {
        this.make = make;
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
        return carLocationZip;
    }

    public void setCarLocationZip(int carLocationZip) {
        this.carLocationZip = carLocationZip;
    }

    public Users getUserID() {
        return user;
    }

    public void setUserID(Users user) {
        this.user = user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
  
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", isAvailable=" + isAvailable +
                ", rented=" + rented +
                ", pricePerDay=" + pricePerDay +
                ", CarLocationZip=" + carLocationZip +
                ", userID=" + user.getId() +
                '}';
    }
}
