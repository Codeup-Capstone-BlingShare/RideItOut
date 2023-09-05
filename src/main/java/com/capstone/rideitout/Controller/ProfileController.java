package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Photo;
import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.PhotoRepository;
import com.capstone.rideitout.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProfileController {
    private final UserRepository userRepository;

    private final PhotoRepository photoDao;

    private PasswordEncoder passwordEncoder;

    public ProfileController(UserRepository userRepository, PhotoRepository photoDao, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.photoDao = photoDao;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/profile")
    public String addProfilePicture(@ModelAttribute Users user){
        Users currentUser = userRepository.getById(user.getId());
        currentUser.setProfilePhoto(user.getProfilePhoto());
//        System.out.println(user.getProfilePhoto());
        userRepository.save(currentUser);
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // I have to instantiate a new obj to access the DB values instead of the session values
        Users user1 = userRepository.getById(user.getId());
        model.addAttribute("photo", user1.getProfilePhoto());
        model.addAttribute("user", user1);
//        model.addAttribute("fileStackKey", fileStackKey);
        return "Users/profile";
    }

@GetMapping("/profile/update")
public String showUpdateProfileForm(Model model) {
    Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    model.addAttribute("user", user);
    return "Users/profile";
}
    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute("user") Users updatedUser, Model model) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user1 = userRepository.getById(user.getId());
        user1.setEmail(updatedUser.getEmail());
        String hashedPassword = passwordEncoder.encode(updatedUser.getPassword());
        user1.setPassword(hashedPassword);
//        user1.setPassword(updatedUser.getPassword());
        userRepository.save(user1);
        return "redirect:/profile";}
    @PostMapping("/profile/delete")
    public String deleteProfile(HttpServletRequest request) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user1 = userRepository.getReferenceById(user.getId());
        if (user1 != null) {
            userRepository.delete(user1);
            new SecurityContextLogoutHandler().logout(request, null, null);
            return "redirect:/";
        }
        return "redirect:/profile";
    }
}