package com.pires.api_sistemalogin.Controller;

import com.pires.api_sistemalogin.Service.UserService;
import com.pires.api_sistemalogin.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    /////VER COM URGENCIA
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        if(user != null){
            model.addAttribute("user", user);
        }

        return "home.html";
    }
    @GetMapping("/success")
    public String Success(){
        return "/loginsucces.html";
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
            return "redirect:/success";
        } else {
            return "redirect:/login";
        }
    }


}
