package com.jaeriary.backend.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaeriary.backend.diary.entity.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
