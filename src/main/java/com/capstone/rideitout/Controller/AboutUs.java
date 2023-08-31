package com.capstone.rideitout.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUs {

    @GetMapping("/aboutus")
    public String showAboutUs(){
        return "Users/aboutus";
    }
}
