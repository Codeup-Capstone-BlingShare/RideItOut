package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.Car;
import com.capstone.rideitout.Model.Trip;
import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.CarRepository;
import com.capstone.rideitout.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class PaymentController {

    private final UserRepository userRepository;


    private final CarRepository carDao;

    @Value("${squareUser}")
    private String SQUARE_USER;
    @Value("${squareKey}")
    private String SQUARE_KEY;

    public PaymentController(UserRepository userRepository, CarRepository carDao) {
        this.userRepository = userRepository;
        this.carDao = carDao;
    }

    @GetMapping("/payment")
    public String showPaymentForm(Model model,
                                  @RequestParam(name = "startDate") Date startDate,
                                  @RequestParam(name = "endDate") Date endDate,
                                  @RequestParam(name = "carID") Car car) {
        System.out.println("here");
        model.addAttribute("squareKey", SQUARE_KEY);
        model.addAttribute("squareUser", SQUARE_USER);

        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Trip trip = new Trip(startDate, endDate, car);
        trip.setRenter(user);
        trip.setTotalCost((trip.getStartDate().getTime() - trip.getEndDate().getTime()) / -86400000 * car.getPricePerDay());

        model.addAttribute("trip", trip);

        return "Users/payment"; // return the name of the payment form template file
    }

    @PostMapping("/process")
    public ModelAndView processPayment(@RequestParam("cardNumber") String cardNumber, @RequestParam("expiryDate") String expiryDate, @RequestParam("cvv") String cvv) {
        // Perform payment processing logic and validation
        boolean paymentSuccess = validatePayment(cardNumber, expiryDate, cvv);
        ModelAndView modelAndView;

        if (paymentSuccess) {
            modelAndView = new ModelAndView("payment-success"); // return the name of the payment success template file
        } else {
            modelAndView = new ModelAndView("payment-error"); // return the name of the payment error template file
        }

        return modelAndView;
    }

    // Placeholder method for payment validation logic
    private boolean validatePayment(String cardNumber, String expiryDate, String cvv) {
        // Perform debit card validation logic
        // Return true if payment is successful, false otherwise
        // You can replace this with your own payment processing and validation logic
        return true;
    }
}