package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.Model.CarForm;
import com.capstone.rideitout.Model.Photo;
import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.CarRepository;
import com.capstone.rideitout.repositories.UserRepository;
import jakarta.persistence.Id;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;


@Controller
@RequestMapping("/listyourride")
public class ListYourRideController {


    private UserRepository userRepository;


    private final CarRepository carDao;

    public ListYourRideController(UserRepository userRepository, CarRepository carDao) {
        this.userRepository = userRepository;
        this.carDao = carDao;
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

        Photo photo = new Photo();
        photo.setCarPhotoURL(carForm.getCarPhotoURL());
        photo.setCar(car);
        car.setPhotos(Collections.singletonList(photo));

        car.setUser(user);
        System.out.println(car.getUser().getId());
        carDao.save(car);

        return "redirect:/manage";
    }



}
