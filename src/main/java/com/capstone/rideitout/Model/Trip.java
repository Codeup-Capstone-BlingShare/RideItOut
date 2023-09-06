package com.capstone.rideitout.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "pickup_location_zip")
    private int pickupLocationZip;

    @Column(name = "total_cost")
    private long totalCost;
    @Column(name = "is_approved")
    private boolean approved;

    @Column(name = "want_staged")
    private boolean wantStaged;

    @Column(name = "confirmation", nullable = true)
    private long confirmationNumber;

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

    public Trip(Date startDate, Date endDate, Car car) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.car = car;
    }

    public Trip(long id, Date startDate, Date endDate, int pickupLocationZip, int totalCost, long renterId, long carId, boolean approved, boolean wantStaged, int staged_zip, long confirmationNumber) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickupLocationZip = pickupLocationZip;
        this.totalCost = totalCost;
        this.approved = approved;
        this.wantStaged = wantStaged;
        this.staged_zip = staged_zip;
        this.confirmationNumber = confirmationNumber;
    }

    public Trip(Date startDate, Date endDate, int pickupLocationZip, int totalCost, boolean approved, boolean wantStaged, int staged_zip) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickupLocationZip = pickupLocationZip;
        this.totalCost = totalCost;
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

    @DateTimeFormat(pattern="MM-dd-YYYY")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @DateTimeFormat(pattern="MM-dd-YYYY")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPickupLocationZip() {
        return pickupLocationZip;
    }

    public void setPickupLocationZip(int pickupLocationZip) {
        this.pickupLocationZip = pickupLocationZip;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
    }

    public Users getRenter() {
        return renter;
    }

    public void setRenter(Users renter) {
        this.renter = renter;
    }

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

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    public long getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(long confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
}
