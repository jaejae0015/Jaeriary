package com.jaeriary.backend.diary.service;

import java.util.List;

import com.jaeriary.backend.diary.dto.DiaryCreateRequest;
import com.jaeriary.backend.diary.dto.DiaryResponse;
import com.jaeriary.backend.diary.dto.DiaryUpdateRequest;

public interface DiaryService {

	DiaryResponse create(DiaryCreateRequest request);
    List<DiaryResponse> findAll();
    DiaryResponse update(Long id, DiaryUpdateRequest request);
    void delete(Long id);
    DiaryResponse get(Long id);
}