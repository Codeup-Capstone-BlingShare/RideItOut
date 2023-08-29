package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.Model.CarForm;
import com.capstone.rideitout.Model.Photo;
import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.CarRepository;
import com.capstone.rideitout.repositories.PhotoRepository;
import com.capstone.rideitout.repositories.UserRepository;
import jakarta.persistence.Id;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/listyourride")
public class ListYourRideController {


    private UserRepository userRepository;

    private final PhotoRepository photoDao;


    private final CarRepository carDao;

    public ListYourRideController(UserRepository userRepository, CarRepository carDao, PhotoRepository photoDao) {
        this.userRepository = userRepository;
        this.carDao = carDao;
        this.photoDao = photoDao;
    }

    @GetMapping
    public String listYourRide(Model model) {
        CarForm carForm = new CarForm();
        model.addAttribute("carForm", carForm);
        return "Users/listyourride";
    }
//, Principal principal

    @PostMapping
    public String addCar(@ModelAttribute("carForm") CarForm carForm) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(user.getId());

        user = userRepository.getById(user.getId());
//        System.out.println(user.getId());
        Car car = new Car(carForm.getMake(), carForm.getModel(), carForm.getYear(), carForm.getMileage(),
                carForm.isAvailable(), carForm.getPricePerDay(), carForm.getCarLocationZip());
        System.out.println("car data " + carForm.getCarPhotoURL());

        car.setUser(user);
        carDao.save(car);
        List<String> carURLs = carForm.getCarPhotoURL();
        for(String carURL : carURLs) {
            Photo photo = new Photo(car, carURL);
            photoDao.save(photo);
        }

        return "redirect:/manage";
    }



}
