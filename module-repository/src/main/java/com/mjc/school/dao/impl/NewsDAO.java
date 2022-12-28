package com.mjc.school.dao.impl;

import com.mjc.school.dao.AbstractDAO;
import com.mjc.school.entity.Author;
import com.mjc.school.entity.News;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class NewsDAO extends AbstractDAO<News> {

    public NewsDAO() {}

    @Override
    protected List<News> getList() {
        return getSourceLoader().getNewsList();
    }

    @Override
    public Optional<News> create(News entity) {
        Optional<News> news = Optional.empty();
        if(isAuthorExist(entity.getId()) && getSourceLoader().setNewsToList(entity)) {
            news = Optional.of(entity);
        }
        return news;
    }

    @Override
    public Optional<News> update(News entity) {
        Optional<News> news = Optional.empty();
        Optional<News> sourceNews = getEntityById(entity.getId());
        if(sourceNews.isPresent() && isAuthorExist(entity.getId())) {
            news = Optional.ofNullable(sourceNews.get().updateNews(entity));
        }
        return news;
    }

    @Override
    public boolean delete(Long id) {
        return getEntityById(id)
                .filter(value -> getSourceLoader().removeNewsFromList(value))
                .isPresent();
    }

    private boolean isAuthorExist(Long id) {
        boolean isExist = false;
        List<Author> authors = getSourceLoader().getAuthorList();
        Optional<Author> author = authors.stream()
                .filter((a) -> Objects.equals(a.getId(), id))
                .findFirst();
        if(author.isPresent()) {
            isExist = true;
        }
        return isExist;
    }

}
