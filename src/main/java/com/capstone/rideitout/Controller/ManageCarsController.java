package com.capstone.rideitout.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/managecars")
public class ManageCarsController {

    @GetMapping
    public String showManageCarsPage() {
        return "managecars"; // return the name of the manage cars page template file
    }

    @PostMapping("/add")
    public ModelAndView addCar(@RequestParam("make") String make, @RequestParam("model") String model) {
        // Add car details to the database or perform necessary actions
        ModelAndView modelAndView = new ModelAndView("addcar-success"); // return the name of the add car success template file
        modelAndView.addObject("make", make);
        modelAndView.addObject("model", model);
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteCar(@RequestParam("carId") int carId) {
        // Delete car from the database or perform necessary actions
        ModelAndView modelAndView = new ModelAndView("deletecar-success"); // return the name of the delete car success template file
        modelAndView.addObject("carId", carId);
        return modelAndView;
    }
}
