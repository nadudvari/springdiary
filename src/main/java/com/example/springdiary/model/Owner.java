package com.example.springdiary.model;

import com.example.springdiary.util.PasswordHash;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToOne
    private Diary diary;
    private String password;
    private byte[] salt;

    public Owner(String name, String password) throws NoSuchAlgorithmException {
        this.name = name;
        this.salt = PasswordHash.getSalt();
        this.password = PasswordHash.get_SHA_256_SecurePassword(password, salt);
        this.diary = new Diary(name + "\'s Diary");
    }

    public Owner() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }
}
