package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.Model.Trip;
import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.CarRepository;
import com.capstone.rideitout.repositories.TripsRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TripsController {
    private final CarRepository carDoa;
    private final TripsRepository tripDoa;

    public TripsController(CarRepository carDoa, TripsRepository tripDoa) {
        this.carDoa = carDoa;
        this.tripDoa = tripDoa;
    }

    @GetMapping("/create/{id}")
    public String createTrip(@PathVariable long id, Model model){
        model.addAttribute("trip", new Trip());
        model.addAttribute("car", carDoa.getReferenceById(id));

        return "Users/createTrip";
    }

    @PostMapping ("/create/{id}")
    public String saveTrip(@ModelAttribute Trip trip, @PathVariable long id) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Car car = carDoa.getReferenceById(id);
        trip.setCar(car);
        trip.setRenter(user);
        trip.setTotalCost((trip.getStartDate().getTime() - trip.getEndDate().getTime()) / -86400000 * car.getPricePerDay());

        tripDoa.save(trip);

        return "redirect:/profile";
    }
}
