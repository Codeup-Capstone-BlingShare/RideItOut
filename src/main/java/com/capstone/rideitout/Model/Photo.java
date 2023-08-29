package com.capstone.rideitout.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "photos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;


    @Column(name = "car_photo_url")
//    @ElementCollection
    private String carPhotoURL;

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", carPhotoURL='" + carPhotoURL + '\'' +
                // Exclude car field from toString()
                '}';
    }

    public Photo(Car car, String carPhotoURL) {
        this.car = car;
        this.carPhotoURL = carPhotoURL;
    }

    public Photo(String carPhotoURL) {
        this.carPhotoURL = carPhotoURL;
    }

    //request API object

}
