package com.example.paintofheart.web;

import com.example.paintofheart.model.entities.Admin;
import com.example.paintofheart.service.AdminService;
import com.example.paintofheart.service.ArtistService;
import com.example.paintofheart.service.CustomerService;
import com.example.paintofheart.service.OrganizerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    private final ArtistService artistService;
    private final CustomerService customerService;
    private final AdminService adminService;
    private final OrganizerService organizerService;

    public RegisterController(ArtistService artistService, CustomerService customerService, AdminService adminService, OrganizerService organizerService) {
        this.artistService = artistService;
        this.customerService = customerService;
        this.adminService = adminService;
        this.organizerService = organizerService;
    }


    @GetMapping("/registerUser")
    public String registerUser(){
        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String registerNewUser(@RequestParam String name,
                                  @RequestParam String surname,
                                  @RequestParam String username,
                                  @RequestParam String email,
                                  @RequestParam String password,
                                  @RequestParam String phoneNumber,
                                  @RequestParam String userType,
                                  @RequestParam (required = false) String transaction,
                                  @RequestParam (required = false) String artistType){
        if(userType.equals("customer")){
            this.customerService.create(username, email,surname, name, phoneNumber,password, transaction);
        }
        if(userType.equals("artist")){
            Admin admin = this.adminService.findById(1); //TODO
            this.artistService.create(username, email,surname, name, phoneNumber,password, artistType, admin);
        }
        if(userType.equals("organizer")){ //TODO:test
            Admin admin = this.adminService.findById(1);
            this.organizerService.create(username, email,surname, name, phoneNumber,password);
        }

        return "redirect:/userLogin";
    }

    //TODO: another register method, that will logout current user, and redirect to register page
}
