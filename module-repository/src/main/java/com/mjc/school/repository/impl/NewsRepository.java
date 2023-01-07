package com.mjc.school.repository.impl;

import com.mjc.school.repository.interfaces.Repository;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.source.DataSource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class NewsRepository implements Repository<NewsModel> {

    private final DataSource dataSource;

    public NewsRepository() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public List<NewsModel> readAll() {
        return dataSource.getNewsList();
    }

    @Override
    public NewsModel readById(Long id) {
        return dataSource.getNewsList().stream()
                .filter(el -> Objects.equals(el.getId(), id))
                .findFirst().get();
    }

    @Override
    public NewsModel create(NewsModel entity) {
        entity.setCreateDate(LocalDateTime.now());
        entity.setLastUpdateDate(LocalDateTime.now());
        return dataSource.addNewsToList(entity);
    }

    @Override
    public NewsModel update(NewsModel entity) {
        NewsModel sourceNews = readById(entity.getId());
        return sourceNews.updateNews(entity);
    }

    @Override
    public Boolean delete(Long id) {
        return dataSource.getNewsList().remove(readById(id));
    }

}
