package com.mjc.school.entity;

import java.time.LocalDateTime;

public class News extends Entity {

    private static Long increment = 0L;

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public News() {
        super(++increment);
    }

    public News(String title, String content, Long authorId) {
        this();
        id = super.getId();
        this.title = title;
        this.content = content;
        this.createDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
        this.authorId = authorId;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public News updateNews(News news) {
        title = news.title;
        content = news.content;
        authorId = news.authorId;
        lastUpdateDate = LocalDateTime.now();
        return this;
    }

    public static NewsBuilder getBuilder() {
        return new NewsBuilder();
    }

    public static class NewsBuilder {

        private final News news = new News();

        public NewsBuilder setId(Long id){
            news.id = id;
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
