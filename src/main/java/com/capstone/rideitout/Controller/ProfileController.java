package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProfileController {
    private final UserRepository userRepository;

    public ProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);

        return "Users/profile";
    }

    @PostMapping("/profile/edit")
    public String updateProfile(@ModelAttribute("updatedUser") Users updatedUser) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        userRepository.save(user);
        return "redirect:/profile";
    }

    @PostMapping("/profile/delete")
    public String deleteProfile() {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userRepository.delete(user);
        return "redirect:/logout";
    }
}