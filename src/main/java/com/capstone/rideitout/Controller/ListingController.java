package com.capstone.rideitout.Controller;


import com.capstone.rideitout.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/listings")
public class ListingController {

    // Sample data for car listings
    private final CarRepository carDoa;

    @Value("${mapBoxKey}")
    private String MB_KEY;

    public ListingController(CarRepository carDoa) {
        this.carDoa = carDoa;
    }

    @GetMapping
    public String showListingsPage(Model model) {
        model.addAttribute("mapBoxKey", MB_KEY);
        model.addAttribute("listings", carDoa.findAll());
        return "Users/listing"; // return the name of the listings page template file
    }

//    @GetMapping("/search")
//    public String searchListings(@RequestParam("query") String query, Model model) {
//        List<String> matchedListings = new ArrayList<>();
//
//        // Perform search functionality
//        for (String listing : carListings) {
//            if (listing.contains(query)) {
//                matchedListings.add(listing);
//            }
//        }
//
//        model.addAttribute("listings", matchedListings);
//        return "listings"; // return the name of the listings page template file
//    }
}