package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        // Simulate user data retrieval (replace with actual user data retrieval logic)
        Users user = new Users(1L, "John", "Doe", "johndoe@example.com", "password123");

        // Add user object to the model
        model.addAttribute("user", user);

        return "profile";
    }
}
