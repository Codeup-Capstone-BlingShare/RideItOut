package com.capstone.rideitout.Controller;



import com.capstone.rideitout.Model.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeaturedVehiclesController {

    @GetMapping("/")
    public String showHomePage(Model model) {
        // Retrieve the featured vehicles from a database or any other data source
        Vehicle vehicle1 = new Vehicle("Make1", "Model1");
        Vehicle vehicle2 = new Vehicle("Make2", "Model2");
        Vehicle vehicle3 = new Vehicle("Make3", "Model3");

        // Add the featured vehicles to the model
        model.addAttribute("vehicle1", vehicle1);
        model.addAttribute("vehicle2", vehicle2);
        model.addAttribute("vehicle3", vehicle3);

        return "home";
    }

}
