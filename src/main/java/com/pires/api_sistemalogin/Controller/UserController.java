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

    //definindo os html que irao aparecer de acordo com as rotas
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


    //pegando os dados do form(POST) com os parametros de acordo com o User
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        service.registerUser(user);

        return "redirect:/login";
    }


    @PostMapping("/login")
    //pegar os dados do form para verificar login
    public String verify_account(@ModelAttribute User user){
        boolean exists = service.verify_account(user);
        System.out.println(exists);
        if (exists) {
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }


}
