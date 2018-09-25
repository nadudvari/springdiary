package com.example.springdiary.controller;

import com.example.springdiary.repository.LoginRepo;
import com.example.springdiary.util.PasswordHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private LoginRepo loginRepo;

    @Autowired
    public LoginController(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    @PostMapping("/login")
    public String validateLogin(@ModelAttribute("username") String name, String password) {

        
        String hashedInputPass = PasswordHash.get_SHA_256_SecurePassword(password);
    }
}
