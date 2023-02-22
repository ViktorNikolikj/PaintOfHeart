package com.example.paintofheart.web;

import com.example.paintofheart.model.entities.User;
import com.example.paintofheart.model.exceptions.InvalidUserCredentialException;
import com.example.paintofheart.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/userLogin")
public class LoginController {
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;


    @GetMapping
    public String getLoginPage(@RequestParam(required = false)String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "userLogin";
    }

    @PostMapping
    public String login(@RequestParam String username,
            @RequestParam String password,
            HttpServletRequest req,
            Model model){
        User user;
        try{
            user = this.userService.login(username, password);
            req.getSession().setAttribute("user", user);
            return "redirect:/events";
        }catch (InvalidUserCredentialException exception){
            return "redirect:/userLogin?error=" + exception.getMessage();
        }
    }
}
