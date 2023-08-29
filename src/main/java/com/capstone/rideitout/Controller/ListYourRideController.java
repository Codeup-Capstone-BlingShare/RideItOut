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
                carForm.isAvailable(), carForm.getPricePerDay(), carForm.getCarLocationZip(), carForm.getCarLocationCity());

        Photo photo = new Photo();
        photo.setCarPhotoURL(carForm.getCarPhotoURL());
        photo.setCar(car);
        car.getPhotos().add(photo);
        System.out.println(carForm.getCarPhotoURL());
        System.out.println(car.getPhotos());
//        car.setPhotos(Collections.singletonList(photo));

        Photo photo1 = new Photo();
        photo1.setCarPhotoURL(carForm.getCarPhotoURL1());
        photo1.setCar(car);
        car.getPhotos().add(photo1);
        System.out.println(carForm.getCarPhotoURL1());

        System.out.println(car.getPhotos());


//        car.setPhotos(Collections.singletonList(photo));

        Photo photo2 = new Photo();
        photo2.setCarPhotoURL(carForm.getCarPhotoURL2());
        photo2.setCar(car);
        car.getPhotos().add(photo2);
        System.out.println(carForm.getCarPhotoURL2());

        System.out.println(car.getPhotos());

//        car.setPhotos(Collections.singletonList(photo));

        Photo photo3 = new Photo();
        photo3.setCarPhotoURL(carForm.getCarPhotoURL3());
        photo3.setCar(car);
        car.getPhotos().add(photo3);
        System.out.println(carForm.getCarPhotoURL3());

        System.out.println(car.getPhotos());

//        car.setPhotos(Collections.singletonList(photo));

        car.setUser(user);
        System.out.println(car.getUser().getId());
        carDao.save(car);

        return "redirect:/manage";
    }



}
