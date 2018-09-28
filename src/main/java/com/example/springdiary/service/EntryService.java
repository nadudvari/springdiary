package com.example.springdiary.service;

import com.example.springdiary.model.Diary;
import com.example.springdiary.model.Entry;
import com.example.springdiary.repository.EntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    private EntryRepo entryRepo;
    private DiaryService diaryService;

    @Autowired
    public EntryService(EntryRepo entryRepo, DiaryService diaryService) {
        this.entryRepo = entryRepo;
        this.diaryService = diaryService;
    }

    public void createNewEntry(String entryName, String content, Diary diary) {
        Entry entry = new Entry(entryName, content, diary);
        diary.addEntry(entry);
        entryRepo.save(entry);
    }

    public void deleteEntryById(String id) {
        Entry entryToDelete = entryRepo.findEntryById(Long.parseLong(id));
        diaryService.removeEntryFromList(entryToDelete);
        entryRepo.delete(entryToDelete);
    }
}
