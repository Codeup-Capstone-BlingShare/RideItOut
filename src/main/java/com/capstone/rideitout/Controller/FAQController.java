package com.capstone.rideitout.Controller;

import com.capstone.rideitout.Model.FAQ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FAQController {
    @RequestMapping("/")
    public String getLandingPage(Model model) {
        // Create a list of FAQs
        List<FAQ> faqs = new ArrayList<>();
        faqs.add(new FAQ("How do I create an account?", "To create an account, click on the \"Register\" button in the top-right corner. Fill in your details and follow the instructions to complete the registration process."));
        faqs.add(new FAQ("Can I search for vehicles without logging in?", "Yes, you can search for vehicles without logging in. Simply use the search filters on the homepage to find the perfect vehicle for your needs."));
        faqs.add(new FAQ("How can I list my vehicle for rent?", "If you're looking to list your vehicle for rent, you need to be a registered user. After logging in, navigate to your profile page and select the \"Manage Your Cars\" section to add your vehicle listing."));
        faqs.add(new FAQ("What is the booking process like?", "Once you've found a vehicle you'd like to rent, click on the \"Book Now\" button on the vehicle's listing page. Follow the instructions to choose your dates and confirm your booking. The owner will receive your request and will respond accordingly."));
        faqs.add(new FAQ("How do I manage my booked trips?", "To manage your booked trips, log in to your account and navigate to the \"My Trips\" section. Here, you can view the details of your upcoming and past trips, including any modifications or cancellations."));
        // Pass the FAQs to the view
        model.addAttribute("faqList", faqs);

        // Return the name of the FAQ view template
        return "faq";
    }
}


