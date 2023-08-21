package com.capstone.rideitout.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @GetMapping
    public String showRegistrationForm() {
        return "registration"; // return the name of the registration form template file
    }

    @PostMapping
    public ModelAndView registerUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Save user registration information to the database or perform necessary actions
        ModelAndView modelAndView = new ModelAndView("registration-success"); // return the name of the registration success template file
        modelAndView.addObject("username", username);
        return modelAndView;
    }
}
