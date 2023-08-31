package com.capstone.rideitout.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
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
        this.id = copy.id;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.username = copy.username;
        this.email = copy.email;
        this.password = copy.password;
        this.profilePhoto = copy.profilePhoto;
        this.listedCars = copy.listedCars;
        this.sentMessages = copy.sentMessages;
        this.rentedTrips = copy.rentedTrips;
        this.givenRatings = copy.givenRatings;
        this.cars = copy.cars;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public List<Car> getListedCars() {
        return listedCars;
    }

    public void setListedCars(List<Car> listedCars) {
        this.listedCars = listedCars;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<Trip> getRentedTrips() {
        return rentedTrips;
    }

    public void setRentedTrips(List<Trip> rentedTrips) {
        this.rentedTrips = rentedTrips;
    }

    public List<Rating> getGivenRatings() {
        return givenRatings;
    }

    public void setGivenRatings(List<Rating> givenRatings) {
        this.givenRatings = givenRatings;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
