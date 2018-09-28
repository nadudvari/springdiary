package com.example.springdiary.service;

import com.example.springdiary.model.Diary;
import com.example.springdiary.model.Entry;
import com.example.springdiary.model.Owner;
import com.example.springdiary.repository.DiaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {

    private DiaryRepo diaryRepo;

    @Autowired
    public DiaryService(DiaryRepo diaryRepo) {
        this.diaryRepo = diaryRepo;
    }


    public void createNewDiary(String diaryName, Owner owner) {
        Diary diary = new Diary(diaryName, owner);
        owner.setDiary(diary);
        diaryRepo.save(diary);
    }

    public void removeEntryFromList(Entry entryToDelete) {
        Diary fromDiary = entryToDelete.getDiary();
        fromDiary.removeEntry(entryToDelete);
    }

    public Diary getDiaryByOwner(Owner owner) {
        if (diaryRepo.getDiaryById(owner.getDiary().getId()) != null) {
            return diaryRepo.getDiaryById(owner.getDiary().getId());
        }
        return null;
    }
}
