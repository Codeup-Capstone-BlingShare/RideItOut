package com.capstone.rideitout.Controller;


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
    private List<String> carListings;

    public ListingController() {
        carListings = new ArrayList<>();
        carListings.add("Car Listing 1");
        carListings.add("Car Listing 2");
        carListings.add("Car Listing 3");
        carListings.add("Car Listing 4");
        carListings.add("Car Listing 5");
    }

    @GetMapping
    public String showListingsPage(Model model) {
        model.addAttribute("listings", carListings);
        return "Users/listing"; // return the name of the listings page template file
    }

    @GetMapping("/search")
    public String searchListings(@RequestParam("query") String query, Model model) {
        List<String> matchedListings = new ArrayList<>();

        // Perform search functionality
        for (String listing : carListings) {
            if (listing.contains(query)) {
                matchedListings.add(listing);
            }
        }

        model.addAttribute("listings", matchedListings);
        return "listings"; // return the name of the listings page template file
    }
}