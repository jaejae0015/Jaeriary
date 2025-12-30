package com.jaeriary.backend.diary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "diary")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "CLOB")
    private String content;

    /**
     * ✅ Hibernate 전용 기본 생성자 (필수)
     * - 접근제어자는 protected
     */
    protected Diary() {
    }

    /**
     * ✅ 우리가 사용하는 생성자
     */
    public Diary(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // ===== getter =====
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    // ===== update 메서드 =====
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}