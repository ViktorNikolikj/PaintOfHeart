package com.example.paintofheart.web;


import com.example.paintofheart.model.entities.*;
import com.example.paintofheart.model.exceptions.InvalidCustomerIdException;
import com.example.paintofheart.service.ArtistService;
import com.example.paintofheart.service.CustomerService;
import com.example.paintofheart.service.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RatingController {
    private final ArtistService artistService;
    private final ReviewService reviewService;
    private final CustomerService customerService;

    public  RatingController(ArtistService artistService, ReviewService reviewService, CustomerService customerService) {
        this.artistService = artistService;
        this.reviewService = reviewService;
        this.customerService = customerService;
    }


    @GetMapping("/artists/{id}/addRating")
    public String addRating(@PathVariable int id, Model model, HttpServletRequest request){

        model.addAttribute("hasError", false);

        User user = (User) request.getSession().getAttribute("user");
        if((user == null) || this.customerService.findById(user.getId()) == null){
            model.addAttribute("hasError", true);
            model.addAttribute("error", "Треба да сте регистрирани како купувач!");
            return "showEvent";
        }

        try{
            Customer customer = this.customerService.findById(user.getId());

        }catch (InvalidCustomerIdException a){
            model.addAttribute("hasError", true);
            model.addAttribute("error", "Треба да сте регистрирани како купувач!");

        }


        Artist artist = this.artistService.findById(id);
        model.addAttribute("artist", artist);
        List<Review> reviews = this.reviewService.findAllByArtist(artist);
        model.addAttribute("reviews", reviews);

        return "addRating";
    }

    @PostMapping("/artists/{id}")
    public String getRating(@PathVariable int id,
                            @RequestParam int rating,
                            @RequestParam(required = false) String content,
                            HttpServletRequest request){
        Artist artist = this.artistService.findById(id);
        User user = (User) request.getSession().getAttribute("user");
        Customer customer = this.customerService.findById(user.getId());
        Review review = this.reviewService.addReview(artist, customer, rating, content);
        return "redirect:/events";
    }

}

