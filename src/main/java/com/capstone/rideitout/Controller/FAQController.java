package com.capstone.rideitout.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FAQController {

    @GetMapping("/faq")
    public String faqPage() {
        return "faq";
    }

//    @PostMapping("/Landing")
//    public String handlePostRequest(@RequestParam("name") String name, Model) {
//        // Handle the POST request and perform any necessary processing
//
//        // Add the processed data to the model for display in the view
//        model.addAttribute("name", name);
//
//        return "landing";
//    }

}