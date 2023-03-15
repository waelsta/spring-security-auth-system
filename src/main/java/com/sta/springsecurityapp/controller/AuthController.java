package com.sta.springsecurityapp.controller;


import com.sta.springsecurityapp.model.Employee;
import com.sta.springsecurityapp.model.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {


    @GetMapping("/")
    public String homePage(@ModelAttribute("employee") Employee employee){
        return "home-page";
    }
    @GetMapping("/landing")
    public String showLanding(){
        return "landing-page";
    }

    @GetMapping("/login")
    public String showLogin(Model model){
        Employee employee = new Employee().builder()
                        .email("waelsta@gmail.com")
                        .role(Role.EMPLOYEE)
                        .firstName("wael")
                        .lastName("sta")
                        .password("test123").build();
        model.addAttribute("employee",employee);
        return "login-page";
    }

    @PostMapping("/login")
    public String performLogin(){
        //TODO login logic

        return "home-page";
    }
}
