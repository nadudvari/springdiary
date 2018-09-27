package com.example.springdiary.service;

import com.example.springdiary.repository.EntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    private EntryRepo entryRepo;

    @Autowired
    public EntryService(EntryRepo entryRepo) {
        this.entryRepo = entryRepo;
    }
}
