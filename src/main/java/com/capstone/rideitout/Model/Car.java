package com.capstone.rideitout.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "cars")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

     @Column(name = "car_location_city")
    private String carLocationCity;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Photo> photos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "car")
    private List<Trip> trips;

    public Car(String make, String model, int year, int mileage, boolean isAvailable, int pricePerDay, int carLocationZip, String carLocationCity) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.isAvailable = isAvailable;
        this.pricePerDay = pricePerDay;
        this.carLocationZip = carLocationZip;
        this.carLocationCity = carLocationCity;
    }

    public Car(String make, String model, int year, int mileage, boolean isAvailable, boolean rented, int pricePerDay, int carLocationZip, String carLocationCity) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.isAvailable = isAvailable;
        this.rented = rented;
        this.pricePerDay = pricePerDay;
        this.carLocationZip = carLocationZip;
        this.carLocationCity = carLocationCity;
    }

    public Car(String make, String model, int year, int mileage, boolean isAvailable, int pricePerDay, int carLocationZip, String carLocationCity, List<Photo> photos) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.isAvailable = isAvailable;
        this.pricePerDay = pricePerDay;
        this.carLocationZip = carLocationZip;
        this.carLocationCity = carLocationCity;
        this.photos = photos;
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
                ", carLocationZip=" + carLocationZip +
                // Exclude photos field from toString()
                '}';
    }
}
