package com.mjc.school.repository.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class NewsModel extends Entity {

    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public NewsModel() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsModel newsModel = (NewsModel) o;
        return Objects.equals(title, newsModel.title)
                && Objects.equals(content, newsModel.content)
                && Objects.equals(createDate, newsModel.createDate)
                && Objects.equals(lastUpdateDate, newsModel.lastUpdateDate)
                && Objects.equals(authorId, newsModel.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, createDate, lastUpdateDate, authorId);
    }

    public NewsModel updateNews(NewsModel newsModel) {
        setTitle(newsModel.title);
        setContent(newsModel.content);
        setAuthorId(newsModel.authorId);
        lastUpdateDate = LocalDateTime.now();
        return this;
    }

    public static NewsBuilder getBuilder() {
        return new NewsBuilder();
    }

    public static class NewsBuilder {

        private final NewsModel newsModel = new NewsModel();

        public NewsBuilder setId(Long id){
            newsModel.setId(id);
            return this;
        }

        public NewsBuilder setTitle(String title) {
            newsModel.title = title;
            return this;
        }

        public NewsBuilder setContent(String content) {
            newsModel.content = content;
            return this;
        }

        public NewsBuilder setCreateDate(LocalDateTime createDate) {
            newsModel.createDate = createDate;
            return this;
        }

        public NewsBuilder setLastUpdateDate(LocalDateTime lastUpdateDate) {
            newsModel.lastUpdateDate = lastUpdateDate;
            return this;
        }

        public NewsBuilder setAuthorId(Long authorId) {
            newsModel.authorId = authorId;
            return this;
        }

        public NewsModel build() {
            return newsModel;
        }
    }
}
