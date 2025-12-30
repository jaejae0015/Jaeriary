package com.jaeriary.backend.diary.dto;

public record DiaryCreateRequest(
        String title,
        String content
) {
}