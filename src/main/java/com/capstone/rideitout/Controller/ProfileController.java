package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Photo;
import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.PhotoRepository;
import com.capstone.rideitout.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProfileController {
    @Value("fileStackKey")
    private String fileStackKey;
    private final UserRepository userRepository;

    private final PhotoRepository photoDao;

    public ProfileController(UserRepository userRepository, PhotoRepository photoDao) {
        this.userRepository = userRepository;
        this.photoDao = photoDao;
    }

    @PostMapping("/profile")
    public String addProfilePicture(@ModelAttribute Users user){
        Users currentUser = userRepository.getById(user.getId());
        currentUser.setProfilePhoto(user.getProfilePhoto());
        userRepository.save(currentUser);
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("fileStackKey", fileStackKey);
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