package com.capstone.rideitout.Controller;
import com.capstone.rideitout.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class ProfileController {

    private UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        Users user = userService.getUser(); // Retrieve user data from the userService
        model.addAttribute("user", user); // Add user object to the model
        return "profile";
    }

    @PostMapping("/save-profile")
    public String saveProfile(@ModelAttribute Users user) {
        userService.saveUser(user); // Save profile changes to the database using userService
        return "redirect:/profile"; // Redirect back to the profile page after saving
    }

    // Other methods for managing cars and displaying past trips
}