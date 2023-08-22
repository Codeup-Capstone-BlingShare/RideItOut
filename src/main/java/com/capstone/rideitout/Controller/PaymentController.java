package com.capstone.rideitout.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {

@Value("${squareUser}")
private String SQUARE_USER;
@Value("${squareKey}")
private String SQUARE_KEY;

    @GetMapping("/payment")
    public String showPaymentForm(Model model) {
        model.addAttribute("squareKey", SQUARE_KEY);
        model.addAttribute("squareUser", SQUARE_USER);
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