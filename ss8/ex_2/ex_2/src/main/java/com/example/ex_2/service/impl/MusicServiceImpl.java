package com.example.ex_2.service.impl;

import com.example.ex_2.model.Music;
import com.example.ex_2.repo.IMusicRepo;
import com.example.ex_2.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicServiceImpl implements IMusicService {
    @Autowired
    private IMusicRepo musicRepo;

    @Override
    public Page<Music> getList(Pageable pageable) {
        return musicRepo.findAllByFlagDeleteIsFalse(pageable);
    }

    @Override
    public void add(Music music) {
        musicRepo.save(music);
    }

    @Override
    public void update(Music music) {
        Music music1 = findById(music.getId());
        music1.setName(music.getName());
        music1.setArtist(music.getArtist());
        music1.setType(music.getType());
        musicRepo.save(music);
    }

    @Override
    public Music findById(int id) {
        return musicRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        Music music = findById(id);
        music.setFlagDelete(true);
        musicRepo.save(music);
    }


}
