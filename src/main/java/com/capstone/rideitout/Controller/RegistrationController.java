package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new Users());
        return "Users/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute Users user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }
}

