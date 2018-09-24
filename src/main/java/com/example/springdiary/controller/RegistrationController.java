package com.example.springdiary.controller;

import com.example.springdiary.model.Owner;
import com.example.springdiary.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    private RegistrationRepo registrationRepo;

    @Autowired
    public RegistrationController(RegistrationRepo registrationRepo) {
        this.registrationRepo = registrationRepo;
    }

    @GetMapping(path = "/registration")
    public String registerUser(Model model) {
        model.addAttribute("owner", new Owner());
        return "registration";
    }
}
