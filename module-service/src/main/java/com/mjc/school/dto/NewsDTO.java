package com.mjc.school.dto;

import com.mjc.school.entity.News;

import java.time.LocalDateTime;
import java.util.Objects;

public class NewsDTO {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public NewsDTO() {}
    public NewsDTO(Long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdateDate, Long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.authorId = authorId;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsDTO news = (NewsDTO) o;
        return Objects.equals(title, news.title)
                && Objects.equals(content, news.content)
                && Objects.equals(createDate, news.createDate)
                && Objects.equals(lastUpdateDate, news.lastUpdateDate)
                && Objects.equals(authorId, news.authorId);
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d, title=%s, content=%s, createDate=%s, lastUpdateDate=%s, authorId=%d]",
                getClass().getSimpleName(), id, title, content, createDate, lastUpdateDate, authorId);
    }
}
