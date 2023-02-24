package com.example.paintofheart.web;

import com.example.paintofheart.model.entities.Cart;
import com.example.paintofheart.model.entities.Customer;
import com.example.paintofheart.model.entities.Ticket;
import com.example.paintofheart.model.entities.User;
import com.example.paintofheart.service.CartService;
import com.example.paintofheart.service.CustomerService;
import com.example.paintofheart.service.TicketService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    @GetMapping("/cart")
    public String showCustomerCart(Model model,
                                   HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        Customer customer = this.customerService.findById(user.getId());
        Cart cart = this.cartService.findByCustomer(customer);
        model.addAttribute("cart", cart);
        List<Ticket> ticketList = this.ticketService.findAllTicketsByCustomer(customer);
        model.addAttribute("ticketList", ticketList);
        return "cart";
    }
}
