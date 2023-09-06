package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.Model.Photo;
import com.capstone.rideitout.Model.Trip;
import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.CarRepository;
import com.capstone.rideitout.repositories.PhotoRepository;
import com.capstone.rideitout.repositories.TripsRepository;
import com.capstone.rideitout.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class ManageCarsController {
    private final CarRepository carDoa;
    private final UserRepository userDoa;
    private final PhotoRepository photoDoa;
    private final TripsRepository tripsDoa;

    public ManageCarsController(CarRepository carDoa, UserRepository userDoa, PhotoRepository photoDoa, TripsRepository tripsDoa) {
        this.carDoa = carDoa;
        this.userDoa = userDoa;
        this.photoDoa = photoDoa;
        this.tripsDoa = tripsDoa;
    }

    @GetMapping("/manage")
    public String showManageCarsPage(Model model) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Car> cars = carDoa.findByUser(user);

        for (Car car : cars) {
            boolean isRented = false;
            Date current = new Date();
            System.out.println(current);
            List<Trip> trips = car.getTrips();
            for (Trip trip: trips) {
                if (current.after(trip.getStartDate()) &&
                        current.before(trip.getEndDate())) {
                    car.setRented(true);
                    break;
                } else {
                    car.setRented(false);
                }
            }
        }

        model.addAttribute("cars", cars);
        return "Users/manage"; // return the name of the manage cars page template file
    }

    @GetMapping("/car/{id}/edit")
    public String postsEdit(@PathVariable long id, Model model) {
        model.addAttribute("car",
                carDoa.getReferenceById(id));
        model.addAttribute("newPhoto", new Photo());
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
        Car car = carDoa.getReferenceById(id);

        carDoa.delete(car);
        return "redirect:/manage";
    }

    @PostMapping("/deleteImg/{id}")
    public String deleteImg(@PathVariable long id, @RequestParam long carid) {
        Photo deletePhoto = photoDoa.getReferenceById(id);
        photoDoa.delete(deletePhoto);
        return "redirect:/car/" + carid + "/edit";
    }

    @PostMapping("/car/{id}/addPhoto")
    public String addImg(@PathVariable long id, @ModelAttribute("newPhoto") Photo photo) {
        System.out.println("here");
        Car car = carDoa.getReferenceById(id);
        System.out.println(photo.getCarPhotoURL());
        if (!photo.getCarPhotoURL().isEmpty()) {
            photo.setCar(car);
            photoDoa.save(photo);
        }

        return "redirect:/car/" + id + "/edit";
    }
}
