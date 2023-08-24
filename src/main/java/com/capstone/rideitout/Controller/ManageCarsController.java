package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.CarRepository;
import com.capstone.rideitout.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManageCarsController {
    private final CarRepository carDoa;
    private final UserRepository userDoa;

    public ManageCarsController(CarRepository carDoa, UserRepository userDoa) {
        this.carDoa = carDoa;
        this.userDoa = userDoa;
    }

    @GetMapping("/manage")
    public String showManageCarsPage(Model model) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("cars", carDoa.findByUser(user));
        return "Users/manage"; // return the name of the manage cars page template file
    }

    @GetMapping("/car/{id}/edit")
    public String postsEdit(@PathVariable long id, Model model) {
        model.addAttribute("car",
                carDoa.getReferenceById(id));
        return "Users/edityourride";
    }

    @PostMapping("/car/{id}/edit")
    public String postUpdate(@PathVariable long id, @ModelAttribute Car car) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Car oldCar = carDoa.getReferenceById(id);

        car.setUser(user);
        car.setRented(oldCar.isRented());

        carDoa.save(car);
        return "redirect:/manage";
    }

    @PostMapping("/car/{id}/delete")
    public String deleteCar(@PathVariable long id) {
        carDoa.deleteById(id);
        return "redirect:/manage";
    }
}
