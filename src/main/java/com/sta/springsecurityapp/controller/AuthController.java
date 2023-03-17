package com.sta.springsecurityapp.controller;


import com.sta.springsecurityapp.service.employeeServiceImpl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final EmployeeServiceImpl employeeService;

}
