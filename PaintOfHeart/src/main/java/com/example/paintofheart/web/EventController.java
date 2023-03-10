package com.example.paintofheart.web;

import com.example.paintofheart.model.entities.*;
import com.example.paintofheart.model.exceptions.InvalidCustomerIdException;
import com.example.paintofheart.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class EventController {

    private final EventService eventService;
    private final CustomerService customerService;
    private final SeatService seatService;
    private final CartService cartService;
    private final TicketService ticketService;
    private final ArtistService artistService;
    private final OrganizerService organizerService;

    public EventController(EventService eventService, CustomerService customerService, SeatService seatService, CartService cartService, TicketService ticketService, ArtistService artistService, OrganizerService organizerService) {
        this.eventService = eventService;
        this.customerService = customerService;
        this.seatService = seatService;
        this.cartService = cartService;
        this.ticketService = ticketService;
        this.artistService = artistService;
        this.organizerService = organizerService;
    }


    @GetMapping("/events")
    public String showAllEvents(Model model, HttpServletRequest request) {
        List<Event> events = this.eventService.allEvents();
        model.addAttribute("events", events);

        return "events";
    }

    @GetMapping("/events/{id}")
    public String showEvent(@PathVariable int id, Model model,
                            HttpServletRequest request) {

        Event event = this.eventService.findById(id);
        model.addAttribute("event", event);

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", "?????????? ???? ?????? ???????????????????????? ???????? ??????????????!");
            return "showEvent";
        }

        try {
            Customer customer = this.customerService.findById(user.getId());

        } catch (InvalidCustomerIdException a) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", "?????????? ???? ?????? ???????????????????????? ???????? ??????????????!");

        }
        model.addAttribute("hasError", false);
        return "showEvent";
    }

    @PostMapping("/events/{id}/ticketReservation")
    //TODO: this.seadService.create not working
    public String ticketReservation(@PathVariable int id,
                                    @RequestParam String seatNumber,
                                    HttpServletRequest request,
                                    Model model) {
        Event event = this.eventService.findById(id);
        User user = (User) request.getSession().getAttribute("user");
        Customer customer = this.customerService.findById(user.getId());
        Seat seat = this.seatService.create(event, Integer.parseInt(seatNumber));
        Cart cart = this.cartService.create(customer, event.getPrice());
        //Ima event type, a vo event klasata i bazata nema event type za eventot
        Ticket ticket = this.ticketService.create(event.getPrice(), event.getDate(), event.getCity(), "Neodredredeno", seat, cart, customer, event);

        return "redirect:/cart";

    }

    @PostMapping("events/{id}/delete")
    public String deleteEvenet(@PathVariable int id){
        this.eventService.delete(id);
        return "redirect:/events";
    }

    @GetMapping("/events/add")
    public String getAddEventPage(Model model){
        model.addAttribute("artists", this.artistService.allArtists());
        model.addAttribute("organizers", this.organizerService.findAll());
        return "addEvent";
    }

    @PostMapping("/addEvent")
    public String addEvent(@RequestParam String name,
                           @RequestParam String price,
                           @RequestParam String city,
                           @RequestParam String date,
                           @RequestParam String phoneNumber,
                           @RequestParam int artist,
                           @RequestParam int organizer){
        Artist artist1 = this.artistService.findById(artist);
        Organizer organizer1 = this.organizerService.findById(organizer);
        this.eventService.create(name, Integer.parseInt(price), city, Date.valueOf(date), phoneNumber, artist1, organizer1);
        return "redirect:/events";
    }
}
