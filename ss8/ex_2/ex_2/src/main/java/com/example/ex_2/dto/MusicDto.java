package com.example.ex_2.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class MusicDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Not Blank")
    @Size(max = 800, message = "Maximum 800 character")
    @Pattern(regexp = "^[\\w ]+", message = "Not included special character")
    private String name;

    @NotBlank(message = "Not Blank")
    @Size(max = 300, message = "Maximum 300 character")
    @Pattern(regexp = "^[\\w ]+", message = "Not included special character")
    private String artist;
    @NotBlank(message = "Not Blank")
    @Size(max = 1000, message = "Maximum 1000 character")
    @Pattern(regexp = "^[\\w, ]+", message = "Not included special character except ','")
    private String type;

    private boolean flagDelete;

    public MusicDto() {
        flagDelete = false;
    }

    public MusicDto(int id, String name, String artist, String type) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
        flagDelete = false;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
