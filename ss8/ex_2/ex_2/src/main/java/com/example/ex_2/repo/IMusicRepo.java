package com.example.ex_2.repo;

import com.example.ex_2.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMusicRepo extends JpaRepository<Music, Integer> {
    Page<Music> findAllByFlagDeleteIsFalse(Pageable pageable);

}
