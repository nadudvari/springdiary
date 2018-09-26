package com.example.springdiary.controller;

import com.example.springdiary.model.Owner;
import com.example.springdiary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String validateLogin(HttpSession session, @ModelAttribute("username") String username, @ModelAttribute("password") String password ) {
        Owner ownerToCheck = userService.findUserByName(username);
        boolean isPasswordCorrect = userService.checkIfPasswordMatch(password, ownerToCheck);
        if (ownerToCheck == null || !isPasswordCorrect) {
            return "Name or password is not correct";
        } else {
            session.setAttribute("user", ownerToCheck);
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }
}
