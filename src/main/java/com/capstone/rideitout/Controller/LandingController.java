package com.capstone.rideitout.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class LandingController {

    @GetMapping("/landing")
    public String landingPage() {
        return "landing";
    }

    @PostMapping("/Landing")
    public String handlePostRequest(@RequestParam("name") String name, Model model) {
        // Handle the POST request and perform any necessary processing

        // Add the processed data to the model for display in the view
        model.addAttribute("name", name);

        return "landing";
    }

}

