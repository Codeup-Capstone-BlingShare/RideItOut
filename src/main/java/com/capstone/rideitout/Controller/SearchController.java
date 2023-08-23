package com.capstone.rideitout.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @Value("${mapBoxKey}")
    private String MB_KEY;
    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("mapBoxKey", MB_KEY);
        // Perform search functionality
        return "Users/search";
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
