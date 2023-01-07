package com.mjc.school.repository.impl;

import com.mjc.school.repository.dao.GenericDAO;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.source.DataSource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class NewsDAO implements GenericDAO<NewsModel> {

    private final DataSource dataSource;

    public NewsDAO() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public List<NewsModel> readAll() {
        return dataSource.getNewsList();
    }

    @Override
    public Optional<NewsModel> readById(Long id) {
        return dataSource.getNewsList().stream()
                .filter(el -> Objects.equals(el.getId(), id))
                .findFirst();
    }

    @Override
    public Optional<NewsModel> create(NewsModel entity) {
        entity.setCreateDate(LocalDateTime.now());
        entity.setLastUpdateDate(LocalDateTime.now());
        return Optional.of(dataSource.addNewsToList(entity));
    }

    @Override
    public Optional<NewsModel> update(NewsModel entity) {
        Optional<NewsModel> news = Optional.empty();
        Optional<NewsModel> sourceNews = readById(entity.getId());
        if(sourceNews.isPresent()) {
            news = Optional.ofNullable(sourceNews.get().updateNews(entity));
        }
        return news;
    }

    @Override
    public Boolean delete(Long id) {
        return readById(id)
                .filter(dataSource::removeNewsFromList)
                .isPresent();
    }

}
