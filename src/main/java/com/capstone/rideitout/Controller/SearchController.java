package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.Model.CarForm;
import com.capstone.rideitout.Model.Search;
import com.capstone.rideitout.Model.Trip;
import com.capstone.rideitout.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Value("${mapBoxKey}")
    private String MB_KEY;

    private final CarRepository carDoa;

    public SearchController(CarRepository carDoa) {
        this.carDoa = carDoa;
    }

    @GetMapping(value = "/search")
    public String search(Model model, @ModelAttribute("search") Search search, BindingResult result) {
        model.addAttribute("mapBoxKey", MB_KEY);
        List<Car> cars = carDoa.findAll();
        List<Car> available = new ArrayList<>();

        if (!search.getSearchLocation().equals("")) {
            cars = carDoa.findByCarLocationCityContains(search.getSearchLocation());
        }

        if (search.getStartDate() == null || search.getEndDate() == null){
            model.addAttribute("listings", cars);
        } else {
            for (Car car : cars) {
                boolean notAvailable = false;
                List<Trip> trips = car.getTrips();
                for (Trip planned : trips) {
                    if (search.getStartDate().after(planned.getStartDate()) &&
                            search.getStartDate().before(planned.getEndDate())) {
                        notAvailable = true;
                        break;
                    } else if (search.getEndDate().after(planned.getStartDate()) &&
                            search.getEndDate().before(planned.getEndDate())) {
                        notAvailable = true;
                        break;
                    }
                }
                if (!notAvailable) {
                    available.add(car);
                }
            }
            model.addAttribute("listings", available);
        }
        return "Users/listing"; // return the name of the listings page template file
    }
}
