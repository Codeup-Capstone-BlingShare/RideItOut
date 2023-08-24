package com.capstone.rideitout.Model;
import com.capstone.rideitout.Model.Trip;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name= "cars")
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

//    @Column(name = "photo_urls")
//    @ElementCollection
//    private List<String> photoUrls;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "car")
    private List<Trip> trips;

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }


    public Car(String make, String model, int year, int mileage, boolean isAvailable, boolean rented, int pricePerDay, int carLocationZip, List<String> photoUrls) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.isAvailable = isAvailable;
        this.rented = rented;
        this.pricePerDay = pricePerDay;
        this.carLocationZip = carLocationZip;
//        this.photoUrls = photoUrls;
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
}
