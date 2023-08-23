package com.capstone.rideitout.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "pickup_location_zip")
    private int pickupLocationZip;

    @Column(name = "total_cost")
    private int totalCost;

//    @Column(name = "renter_id")
//    private long renterId;

//    @Column(name = "car_id")
//    private long carId;

    @Column(name = "is_approved")
    private boolean approved;

    @Column(name = "want_staged")
    private boolean wantStaged;

    @Column(name = "Staged_zip")
    private int staged_zip;

    @ManyToOne
    @JoinColumn(name = "renter_id")
    private Users renter;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Trip() {
    }

    public Trip(long id, String startDate, String endDate, int pickupLocationZip, int totalCost, long renterId, long carId, boolean approved, boolean wantStaged, int staged_zip) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickupLocationZip = pickupLocationZip;
        this.totalCost = totalCost;
//        this.renterId = renterId;
//        this.carId = carId;
        this.approved = approved;
        this.wantStaged = wantStaged;
        this.staged_zip = staged_zip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getPickupLocationZip() {
        return pickupLocationZip;
    }

    public void setPickupLocationZip(int pickupLocationZip) {
        this.pickupLocationZip = pickupLocationZip;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

//    public long getRenterId() {
//        return renterId;
//    }
//
//    public void setRenterId(long renterId) {
//        this.renterId = renterId;
//    }

//    public long getCarId() {
//        return carId;
//    }
//
//    public void setCarId(long carId) {
//        this.carId = carId;
//    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isWantStaged() {
        return wantStaged;
    }

    public void setWantStaged(boolean wantStaged) {
        this.wantStaged = wantStaged;
    }

    public int getStaged_zip() {
        return staged_zip;
    }

    public void setStaged_zip(int staged_zip) {
        this.staged_zip = staged_zip;
    }
}
