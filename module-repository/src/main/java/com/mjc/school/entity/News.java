package com.mjc.school.entity;

import java.time.LocalDateTime;

public class News extends Entity {

    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public News() {
        super(0L);
        createDate = LocalDateTime.now();
        lastUpdateDate = LocalDateTime.now();
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

    public News updateNews(News news) {
        setTitle(news.title);
        setContent(news.content);
        setAuthorId(news.authorId);
        lastUpdateDate = LocalDateTime.now();
        return this;
    }

    public static NewsBuilder getBuilder() {
        return new NewsBuilder();
    }

    public static class NewsBuilder {

        private final News news = new News();

        public NewsBuilder setId(Long id){
            news.setId(id);
            return this;
        }

        public NewsBuilder setTitle(String title) {
            news.title = title;
            return this;
        }

        public NewsBuilder setContent(String content) {
            news.content = content;
            return this;
        }

        public NewsBuilder setCreateDate(LocalDateTime createDate) {
            news.createDate = createDate;
            return this;
        }

        public NewsBuilder setLastUpdateDate(LocalDateTime lastUpdateDate) {
            news.lastUpdateDate = lastUpdateDate;
            return this;
        }

        public NewsBuilder setAuthorId(Long authorId) {
            news.authorId = authorId;
            return this;
        }

        public News build() {
            return news;
        }
    }
}
