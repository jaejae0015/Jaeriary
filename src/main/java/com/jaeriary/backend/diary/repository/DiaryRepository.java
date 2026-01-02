package com.jaeriary.backend.diary.repository;


import com.jaeriary.backend.diary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}