package com.jaeriary.backend.diary.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaeriary.backend.diary.dto.DiaryCreateRequest;
import com.jaeriary.backend.diary.dto.DiaryResponse;
import com.jaeriary.backend.diary.service.DiaryService;

@RestController
@RequestMapping("/api/diaries")
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping
    public DiaryResponse create(@RequestBody DiaryCreateRequest request) {
        return diaryService.create(request);
    }

    @GetMapping
    public List<DiaryResponse> list() {
        return diaryService.findAll();
    }
}