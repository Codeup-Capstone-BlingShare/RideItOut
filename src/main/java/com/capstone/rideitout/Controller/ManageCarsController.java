package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.Model.Photo;
import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.CarRepository;
import com.capstone.rideitout.repositories.PhotoRepository;
import com.capstone.rideitout.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ManageCarsController {
    private final CarRepository carDoa;
    private final UserRepository userDoa;
    private final PhotoRepository photoDoa;

    public ManageCarsController(CarRepository carDoa, UserRepository userDoa, PhotoRepository photoDoa) {
        this.carDoa = carDoa;
        this.userDoa = userDoa;
        this.photoDoa = photoDoa;
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
        model.addAttribute("newPhoto", new Photo());
        return "Users/edityourride";
    }

    @PostMapping("/car/{id}/edit")
    public String postUpdate(@PathVariable long id, @ModelAttribute Car car) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Car oldCar = carDoa.getReferenceById(id);

        car.setUser(user);
        car.setRented(oldCar.isRented());

//        List<Photo> carPhotos = car.getPhotos();
//        for (Photo carPhoto : carPhotos) {
//            String url = carPhoto.getCarPhotoURL();
//            Photo photo = new Photo(car, url);
//            photoDoa.save(photo);
//        }

        carDoa.save(car);
        return "redirect:/manage";
    }

    @PostMapping("/car/{id}/delete")
    public String deleteCar(@PathVariable long id) {
        carDoa.deleteById(id);
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

        Car car = carDoa.getReferenceById(id);
        photo.setCar(car);
        photoDoa.save(photo);

        return "redirect:/car/" + id + "/edit";
    }
}
