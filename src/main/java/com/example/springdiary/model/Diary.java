package com.example.springdiary.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToMany(mappedBy = "diary")
    private List<Entry> entries;
    @OneToOne
    private Owner owner;

    public Diary(String name, Owner owner) {
        this.name = name;
        this.owner = owner;
    }

    public Diary() {
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "name='" + name + '\'' +
                ", owner=" + owner +
                '}';
    }
}
