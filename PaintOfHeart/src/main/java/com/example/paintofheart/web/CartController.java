package com.example.paintofheart.web;

import com.example.paintofheart.model.entities.Cart;
import com.example.paintofheart.model.entities.Customer;
import com.example.paintofheart.model.entities.Ticket;
import com.example.paintofheart.service.CartService;
import com.example.paintofheart.service.CustomerService;
import com.example.paintofheart.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {
    private final CustomerService customerService;
    private final CartService cartService;
    private final TicketService ticketService;

    public CartController(CustomerService customerService, CartService cartService, TicketService ticketService) {
        this.customerService = customerService;
        this.cartService = cartService;
        this.ticketService = ticketService;
    }

    @GetMapping("/cart/{id}")
    public String showCustomerCart(@PathVariable int id,
                                   Model model){
        Customer customer = this.customerService.findById(id);
        Cart cart = this.cartService.findByCustomer(customer);
        model.addAttribute("cart", cart);
        Ticket ticket = this.ticketService.findByCart(cart);
        model.addAttribute("ticket", ticket);
        return "cart";
    }
}
