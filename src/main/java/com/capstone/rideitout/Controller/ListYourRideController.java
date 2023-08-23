package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.CarRepository;
import com.capstone.rideitout.repositories.UserRepository;
import jakarta.persistence.Id;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/listyourride")
public class ListYourRideController {


    private UserRepository userRepository;


    private final CarRepository carDao;

    public ListYourRideController(UserRepository userRepository, CarRepository carDao) {
        this.userRepository = userRepository;
        this.carDao = carDao;
    }

    @GetMapping
    public String listYourRide(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "Users/listyourride";
    }


    @PostMapping
    public String addCar(@ModelAttribute Car car, Principal principal) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        car.setUser(user);
        carDao.save(car);

        return "redirect:/manage";
    }



}
