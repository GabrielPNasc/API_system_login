package com.pires.api_sistemalogin.Controller;

import com.pires.api_sistemalogin.Service.UserService;
import com.pires.api_sistemalogin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("")
    public String redirect(){
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String Login(){
        return "/login.html";
    }

    @GetMapping("/home")
    public String home(){
        return "/home.html";
    }

    @GetMapping("/register")
    public String Register(){
        return "/register.html";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {

        service.registerUser(user);

        return "redirect:/login";
    }


}
