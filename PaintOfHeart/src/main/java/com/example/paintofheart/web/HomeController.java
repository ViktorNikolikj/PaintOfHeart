package com.example.paintofheart.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    public HomeController() {
    }

    @GetMapping("/home")
    public String getHomePage(Model model){

        return "home.html";
    }

}
