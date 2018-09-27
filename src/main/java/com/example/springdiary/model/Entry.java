package com.example.springdiary.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String content;
    private Date date;
    @ManyToOne
    private Diary diary;

    public Entry(String name, String content, Diary diary) {
        this.name = name;
        this.content = content;
        this.diary = diary;
    }

    public Entry() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }
}
