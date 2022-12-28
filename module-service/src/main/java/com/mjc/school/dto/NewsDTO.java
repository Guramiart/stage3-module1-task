package com.mjc.school.dto;

import java.time.LocalDateTime;

public class NewsDTO {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private String authorName;

    public NewsDTO(Long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdateDate, String authorName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return String.format("id=%d;title=%s;content=%s;createDate=%s;updateDate=%s;author=%s",
                id, title, content, createDate, lastUpdateDate, authorName);
    }
}
