package com.capstone.rideitout.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @GetMapping("/search")
    public String search(@RequestParam("query") String query) {
        // Perform search functionality
        return "Searching for: " + query;
    }

    @GetMapping("/cars")
    public String getCars() {
        // Get all cars available for rental
        return "List of cars";
    }

    @GetMapping("/login/{username}")
    public String login(@PathVariable String username) {
        // Perform login functionality
        return "Logged in as: " + username;
    }

    @GetMapping("/logout")
    public String logout() {
        // Perform logout functionality
        return "Logged out successfully";
    }
}
