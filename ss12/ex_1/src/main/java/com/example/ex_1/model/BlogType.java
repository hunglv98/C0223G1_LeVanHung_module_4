package com.example.ex_1.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class BlogType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean status;

    public BlogType() {
    }

    public BlogType(int id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public BlogType(int id, String name, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.status = false;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
