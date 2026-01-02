package com.jaeriary.backend.diary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryCreateRequest {
    private String title;
    private String content;
}