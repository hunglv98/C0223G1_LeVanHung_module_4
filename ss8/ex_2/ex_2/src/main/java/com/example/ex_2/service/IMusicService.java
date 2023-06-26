package com.example.ex_2.service;

import com.example.ex_2.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IMusicService {
    Page<Music> getList(Pageable pageable);

    void add(Music music);

    void update(Music music);

    Music findById(int id);

    void deleteById(int id);
}
