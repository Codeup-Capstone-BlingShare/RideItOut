package com.capstone.rideitout.Model;

import lombok.*;

import java.util.List;

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
    private List<String> carPhotoURL;

}
