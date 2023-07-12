package rayglass.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

//    @GetMapping("/")
//    @ResponseBody
//    public String home() {
//        return "Home!";
//    }
//    @GetMapping("/home")
//    public String welcome() {
//        return "home";
//    }

    @GetMapping("/")
    public String returnLandingPage() {
        return "index";
    }

}
