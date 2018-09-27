package com.example.springdiary.service;

import com.example.springdiary.model.Diary;
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
        diaryRepo.save(diary);
    }
}
