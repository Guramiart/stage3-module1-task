package com.mjc.school.repository.impl;

import com.mjc.school.repository.dao.AbstractDAO;
import com.mjc.school.repository.entity.News;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class NewsDAO extends AbstractDAO<News> {

    public NewsDAO() {}

    @Override
    protected List<News> getList() {
        return super.dataSource.getNewsList();
    }

    @Override
    public Optional<News> create(News entity) {
        entity.setCreateDate(LocalDateTime.now());
        entity.setLastUpdateDate(LocalDateTime.now());
        return Optional.of(super.dataSource.addNewsToList(entity));
    }

    @Override
    public Optional<News> update(News entity) {
        Optional<News> news = Optional.empty();
        Optional<News> sourceNews = getEntityById(entity.getId());
        if(sourceNews.isPresent()) {
            news = Optional.ofNullable(sourceNews.get().updateNews(entity));
        }
        return news;
    }

    @Override
    public boolean delete(Long id) {
        return getEntityById(id)
                .filter(super.dataSource::removeNewsFromList)
                .isPresent();
    }

}
