package com.example.ex_1.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(columnDefinition = "long")
    private String content;
    private LocalDate date;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "blog_type", nullable = false)
    private BlogType blogType;

    public Blog() {
        this.status = false;
    }

    public Blog(int id, String name, String content, LocalDate date) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.date = date;
        this.status = false;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
