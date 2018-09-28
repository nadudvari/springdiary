package com.example.springdiary.controller;

import com.example.springdiary.model.Owner;
import com.example.springdiary.service.DiaryService;
import com.example.springdiary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private UserService userService;
    private DiaryService diaryService;

    @Autowired
    public RegistrationController(UserService userService, DiaryService diaryService) {
        this.userService = userService;
        this.diaryService = diaryService;
    }

    @GetMapping(path = "/registration")
    public String addUserToModel(Model model) {
        model.addAttribute("owner", new Owner());
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String registerUser(@ModelAttribute("owner") Owner owner) {
        if (userService.findUserByName(owner.getUsername()) != null) {
            return "Username already taken";
        } else {
            userService.saveUser(owner);
            diaryService.createNewDiary(owner.getUsername() + "'s Diary", owner);
            return "redirect:/";
        }
    }
}
