package com.mjc.school.dao.impl;

import com.mjc.school.dao.GenericDAO;
import com.mjc.school.entity.News;
import com.mjc.school.loader.SourceLoader;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class NewsDAO implements GenericDAO<News> {

    private final SourceLoader sourceLoader;

    public NewsDAO() {
        sourceLoader = SourceLoader.getInstance();
    }

    @Override
    public Optional<News> create(News entity) {
        if(sourceLoader.setNewsToList(entity)) {
            return Optional.ofNullable(entity);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<News> getAll() {
        return sourceLoader.getNewsList();
    }

    @Override
    public Optional<News> getEntityById(Long id) {
        Optional<News> news = Optional.empty();
        for (News elem : sourceLoader.getNewsList()) {
            if(Objects.equals(elem.getId(), id)) {
                news = Optional.of(elem);
                break;
            }
        }
        return news;
    }

    @Override
    public Optional<News> update(News entity) {
        Optional<News> news = Optional.empty();
        for(News elem : sourceLoader.getNewsList()) {
            if(Objects.equals(elem.getId(), entity.getId())) {
                news = Optional.ofNullable(elem.updateNews(entity));
            }
        }
        return news;
    }

    @Override
    public boolean delete(Long id) {
        for(News elem : sourceLoader.getNewsList()) {
            if(Objects.equals(elem.getId(), id)) {
                return sourceLoader.removeNewsFromList(elem);
            }
        }
        return false;
    }
}
