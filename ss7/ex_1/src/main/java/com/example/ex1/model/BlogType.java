package com.example.ex1.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class BlogType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private boolean status;

    @OneToMany
    private List<Blog> blogs;

    public BlogType() {
        status = false;
    }

    public BlogType(int id, String name, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.status = false;
        this.blogs = blogs;
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

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
