package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.Model.Trip;
import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.CarRepository;
import com.capstone.rideitout.repositories.TripsRepository;
import com.capstone.rideitout.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@SessionAttributes("tripToSave")
public class PaymentController {

    private final UserRepository userRepository;
    private final TripsRepository tripsDao;
    private final CarRepository carDao;

    @Value("${squareUser}")
    private String SQUARE_USER;
    @Value("${squareKey}")
    private String SQUARE_KEY;

    public PaymentController(UserRepository userRepository, CarRepository carDao, TripsRepository tripsDao) {
        this.userRepository = userRepository;
        this.carDao = carDao;
        this.tripsDao = tripsDao;
    }

    @ModelAttribute("tripToSave")
    public Trip tripToSave() {
        return new Trip();
    }

    @PostMapping("/payment")
    public String runPayment(Model model,
                             @RequestParam(name = "startDate") Date startDate,
                             @RequestParam(name = "endDate") Date endDate,
                             @RequestParam(name = "carID") long carID,
                             @ModelAttribute("tripToSave") Trip tripToSave) {
        System.out.println("here");
        model.addAttribute("squareKey", SQUARE_KEY);
        model.addAttribute("squareUser", SQUARE_USER);

        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Car car = carDao.getReferenceById(carID);

        Trip trip = new Trip(startDate, endDate, car);
        trip.setRenter(user);
        trip.setTotalCost((trip.getStartDate().getTime() - trip.getEndDate().getTime()) / -86400000 * car.getPricePerDay());

        model.addAttribute("tripToSave", trip);

        return "Users/payment"; // return the name of the payment form template file
    }

    @GetMapping("/confirmed")
    public String confirmPayment(Model model, @ModelAttribute("tripToSave") Trip tripToSave) {
        model.addAttribute("tripToSave", tripToSave);
        tripsDao.save(tripToSave);
        return "Users/confirmed";
    }
}