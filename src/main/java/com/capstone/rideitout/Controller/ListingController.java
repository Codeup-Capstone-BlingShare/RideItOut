package com.capstone.rideitout.Controller;


import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.Model.Trip;
import com.capstone.rideitout.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListingController {
    private final CarRepository carDoa;

    @Value("${mapBoxKey}")
    private String MB_KEY;

    public ListingController(CarRepository carDoa) {
        this.carDoa = carDoa;
    }

    @GetMapping("/listings")
    public String showListingsPage(Model model, @ModelAttribute Trip trip) {
        model.addAttribute("mapBoxKey", MB_KEY);
        List<Car> cars = carDoa.findAll();
        List<Car> available = new ArrayList<>();

        if (trip.getStartDate() == null && trip.getEndDate() == null) {
            model.addAttribute("trip", new Trip());
            model.addAttribute("listings", cars);
        } else {
            for (Car car : cars) {
                boolean notAvailable = false;
                List<Trip> trips = car.getTrips();
                    for (Trip planned : trips) {
                        if (trip.getStartDate().after(planned.getStartDate()) &&
                                trip.getStartDate().before(planned.getEndDate())) {
                            notAvailable = true;
                            break;
                        } else if (trip.getEndDate().after(planned.getStartDate())) {
                            notAvailable = true;
                            break;
                        }
                    }
                    if (!notAvailable) {
                        available.add(car);
                    }
            }
            model.addAttribute("listings", available);
        }
        return "Users/listing"; // return the name of the listings page template file
    }

    @GetMapping("/listings/{id}")
    public String showIndividualPage(@PathVariable long id, Model model) {
        model.addAttribute("car", carDoa.getReferenceById(id));
        return "Users/individual";
    }
}