package com.example.paintofheart.web;

import com.example.paintofheart.model.entities.*;
import com.example.paintofheart.model.exceptions.InvalidCustomerIdException;
import com.example.paintofheart.service.CartService;
import com.example.paintofheart.service.CustomerService;
import com.example.paintofheart.service.EventService;
import com.example.paintofheart.service.SeatService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EventController {

    private final EventService eventService;
    private final CustomerService customerService;
    private final SeatService seatService;
    private final CartService cartService;

    public EventController(EventService eventService, CustomerService customerService, SeatService seatService, CartService cartService) {
        this.eventService = eventService;
        this.customerService = customerService;
        this.seatService = seatService;
        this.cartService = cartService;
    }



    @GetMapping("/events")
    public String showAllEvents(Model model, HttpServletRequest request){
        List<Event> events = this.eventService.allEvents();
        model.addAttribute("events", events);

        return "events";
    }

    @GetMapping("/events/{id}")
    public String showEvent(@PathVariable int id, Model model,
                            HttpServletRequest request){

        Event event = this.eventService.findById(id);
        model.addAttribute("event", event);

        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
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
        model.addAttribute("hasError", false);
        return "showEvent";
    }

    @PostMapping("/events/{id}/ticketReservation")
    //TODO: this.seadService.create not working
    public String ticketReservation(@PathVariable int id,
                                    @RequestParam String seatNumber,
                                    HttpServletRequest request,
                                    Model model){
            Event event = this.eventService.findById(id);
            User user = (User) request.getSession().getAttribute("user");
            Customer customer = this.customerService.findById(user.getId());
            Seat seat = this.seatService.create(event,Integer.parseInt(seatNumber));
            Cart cart = this.cartService.create(customer, event.getPrice());

        return "redirect:/cart/{id}";

    }
}
