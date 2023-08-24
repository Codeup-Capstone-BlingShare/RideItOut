package com.capstone.rideitout.repositories;

import com.capstone.rideitout.Model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TripsRepository  extends JpaRepository<Trip, Long> {

}
