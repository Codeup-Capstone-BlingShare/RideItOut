package com.capstone.rideitout.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarForm {
    private String make;
    private String model;
    private int year;
    private int mileage;
    private boolean isAvailable;
    private int pricePerDay;
    private int carLocationZip;
    private String carPhotoURL;
    private String carPhotoURL1;
    private String carPhotoURL2;
    private String carPhotoURL3;
}
