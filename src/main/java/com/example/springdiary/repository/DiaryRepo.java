package com.example.springdiary.repository;

import com.example.springdiary.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepo extends JpaRepository<Diary, Long> {
    Diary getDiaryById(long id);
}
