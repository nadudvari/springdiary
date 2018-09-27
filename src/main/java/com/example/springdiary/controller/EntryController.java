package com.example.springdiary.controller;

import com.example.springdiary.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;

public class EntryController {

    private EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }
}
