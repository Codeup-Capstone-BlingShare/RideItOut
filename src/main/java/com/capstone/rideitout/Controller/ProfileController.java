package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);

        return "Users/profile";
    }
}
