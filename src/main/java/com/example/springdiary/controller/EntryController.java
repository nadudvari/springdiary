package com.example.springdiary.controller;

import com.example.springdiary.model.Owner;
import com.example.springdiary.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class EntryController {

    private EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping("/create-entry")
    public String addEntry(HttpSession session, @ModelAttribute("entry-name") String entryName, @ModelAttribute("entry-content") String entryContent) {
        Owner owner = (Owner) session.getAttribute("user");
        entryService.createNewEntry(entryName, entryContent, owner.getDiary());
        return "redirect:/";
    }
}
