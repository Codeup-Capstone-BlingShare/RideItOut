package com.capstone.rideitout.repositories;

import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findById(long id);


}