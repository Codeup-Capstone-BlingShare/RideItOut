package com.capstone.rideitout.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "profile_photo_url")
    private String profilePhoto;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Car> listedCars;

    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessages;

    @OneToMany(mappedBy = "renter")
    private List<Trip> rentedTrips;

    @OneToMany(mappedBy = "user")
    private List<Rating> givenRatings;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Car> cars;

    public Users() {
    }

    public Users(String email, String firstName, String lastName, String password, String username) {
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Users(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public Users(long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Users(Users copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                '}';
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }
}
