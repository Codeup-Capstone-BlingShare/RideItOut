package com.capstone.rideitout.Controller;


import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.Model.Search;
import com.capstone.rideitout.Model.Trip;
import com.capstone.rideitout.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String showListingsPage(Model model) {
        model.addAttribute("mapBoxKey", MB_KEY);
        model.addAttribute("search", new Search());

        List<Car> cars = carDoa.findAll();

        model.addAttribute("listings", cars);

        return "Users/listing"; // return the name of the listings page template file
    }

    @GetMapping("/listings/{id}")
    public String showIndividualPage(@PathVariable long id, Model model) {
        model.addAttribute("car", carDoa.getReferenceById(id));
        return "Users/individual";
    }
}