package com.sta.springsecurityapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String showLanding(){
        return "landing-page";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login-page";
    }

    @PostMapping("/login")
    public String performLogin(){
        //TODO login logic

        return "home-page";
    }
}
