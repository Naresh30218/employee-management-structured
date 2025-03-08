package com.employeeapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    // Welcome message for the root URL
    //@GetMapping("/")
    //public String home() {
    //    return "Welcome to the Employee Management System!";
    //}

    // Optional: Redirect from root URL to /employees
    /*
    @GetMapping("/")
    public String redirectToEmployees() {
        return "redirect:/employees";
    }
    */
}
