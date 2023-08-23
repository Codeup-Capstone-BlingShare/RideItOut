package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.repositories.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/listyourride")
public class ListYourRideController {

    private final CarRepository carDao;

    public ListYourRideController(CarRepository carDao) {
        this.carDao = carDao;
    }

    @GetMapping
    public String listYourRide(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "Users/listyourride";
    }


    @PostMapping
    public String addCar(@ModelAttribute Car car) {
        carDao.save(car);
        return "redirect:/manage";
    }


}
