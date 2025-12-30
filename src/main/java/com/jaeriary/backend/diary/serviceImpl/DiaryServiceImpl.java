package com.jaeriary.backend.diary.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaeriary.backend.diary.dto.DiaryCreateRequest;
import com.jaeriary.backend.diary.dto.DiaryResponse;
import com.jaeriary.backend.diary.dto.DiaryUpdateRequest;
import com.jaeriary.backend.diary.entity.Diary;
import com.jaeriary.backend.diary.repository.DiaryRepository;
import com.jaeriary.backend.diary.service.DiaryService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private final DiaryRepository diaryRepository;

	// ✅ 생성자 주입 (핵심)
    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    
    @Override
    public DiaryResponse create(DiaryCreateRequest request) {
        Diary diary = new Diary(request.title(), request.content());
        return DiaryResponse.from(diaryRepository.save(diary));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiaryResponse> findAll() {
        return diaryRepository.findAll()
                .stream()
                .map(DiaryResponse::from)
                .toList();
    }
    @Transactional
    @Override
    public DiaryResponse update(Long id, DiaryUpdateRequest request) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일기 없음"));

        diary.update(request.title(), request.content());
        return DiaryResponse.from(diary);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        diaryRepository.deleteById(id);
    }
    
    @Transactional(readOnly = true)
    public DiaryResponse get(Long id) {
        Diary diary = diaryRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Diary not found"));
        return DiaryResponse.from(diary);
    }
}