package com.capstone.rideitout.Controller;
import com.capstone.rideitout.Model.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeaturedVehiclesController {

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("search", new Search());

        return "home";
    }

}
