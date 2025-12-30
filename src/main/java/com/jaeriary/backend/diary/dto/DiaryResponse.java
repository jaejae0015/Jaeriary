package com.jaeriary.backend.diary.dto;

import com.jaeriary.backend.diary.entity.Diary;

public record DiaryResponse(
	    Long id,
	    String title,
	    String content
	) {
	    public static DiaryResponse from(Diary diary) {
	        return new DiaryResponse(
	            diary.getId(),
	            diary.getTitle(),
	            diary.getContent()
	        );
	    }
	}