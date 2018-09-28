package com.example.springdiary.repository;

import com.example.springdiary.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepo extends JpaRepository<Entry, Long>{
    Entry findEntryById(Long id);
}
