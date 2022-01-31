package com.lgcns.icst.lecture.servletjsp.lec3;

import java.time.LocalDateTime;

public class FreeBoard {

    private Long id;
    private String title;
    private String content;
    private String createdBy;
    private LocalDateTime createdAt;

    public FreeBoard(Long id) {
        this.id = id;
    }

    public FreeBoard(Long id, String title, String content, String createdBy) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
