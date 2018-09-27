package com.example.springdiary.service;

import com.example.springdiary.model.Diary;
import com.example.springdiary.model.Entry;
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

    public void createNewEntry(String entryName, String content, Diary diary) {
        Entry entry = new Entry(entryName, content, diary);
        diary.addEntry(entry);
        entryRepo.save(entry);
    }
}
