package com.jaeriary.backend.diary.controller;
import com.jaeriary.backend.diary.dto.*;
import com.jaeriary.backend.diary.entity.Diary;
import com.jaeriary.backend.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diaries")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @GetMapping
    public List<Diary> list() {
        return diaryService.findAll();
    }

    @PostMapping
    public Diary create(@RequestBody DiaryCreateRequest request) {
        return diaryService.create(request);
    }

    @PutMapping("/{id}")
    public Diary update(
            @PathVariable("id") Long id,
            @RequestBody DiaryUpdateRequest request
    ) {
        return diaryService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        diaryService.delete(id);
    }
}