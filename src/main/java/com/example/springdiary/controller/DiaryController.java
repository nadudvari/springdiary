package com.example.springdiary.controller;

import com.example.springdiary.model.Diary;
import com.example.springdiary.model.Owner;
import com.example.springdiary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DiaryController {

    private DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }


    @GetMapping(path = "/")
    public String getMainPage(HttpSession session, Model model) {
        if (session.getAttribute("user") != null) {
            Owner owner = (Owner) session.getAttribute("user");
            model.addAttribute("owner", owner);
            if (diaryService.getDiaryByOwner(owner) != null) {
                model.addAttribute("diary", diaryService.getDiaryByOwner(owner));
                return "index";
            }
            return "index";
        }
        return "index";
    }

    @PostMapping(path = "/create-diary")
    public String createDiary(HttpSession session, @ModelAttribute("diary-name") String diaryName) {
        Owner owner = (Owner) session.getAttribute("user");
        diaryService.createNewDiary(diaryName, owner);
        return "redirect:/";
    }
}
