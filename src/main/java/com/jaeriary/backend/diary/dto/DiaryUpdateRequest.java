package com.jaeriary.backend.diary.dto;

public record DiaryUpdateRequest(
        String title,
        String content
) {
}