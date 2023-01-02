package com.mjc.school.service.impl;

import com.mjc.school.dao.AbstractDAO;
import com.mjc.school.dao.impl.NewsDAO;
import com.mjc.school.dto.NewsDTO;
import com.mjc.school.entity.News;
import com.mjc.school.mapper.NewsMapper;
import com.mjc.school.service.NewsService;
import com.mjc.school.utils.StringValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewsServiceImpl implements NewsService<NewsDTO> {

    private final AbstractDAO<News> newsDAO;

    public NewsServiceImpl() {
        newsDAO = new NewsDAO();
    }

    @Override
    public Optional<NewsDTO> createNews(News news) {
        if(StringValidator.isTitleValid(news.getTitle())
                && StringValidator.isContentValid(news.getContent())) {
            Optional<News> optionalNews = newsDAO.create(news);
            Optional<NewsDTO> newsDTO = Optional.empty();
            if(optionalNews.isPresent()) {
                newsDTO = Optional.of(NewsMapper.INSTANCE.newsToNewsDTO(optionalNews.get()));
            }
            return newsDTO;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<NewsDTO> getAllNews() {
        List<NewsDTO> news = new ArrayList<>();
        for(News elem : newsDAO.getAll()) {
            news.add(NewsMapper.INSTANCE.newsToNewsDTO(elem));
        }
        return news;
    }

    @Override
    public Optional<NewsDTO> getNewsById(Long id) {
        Optional<NewsDTO> newsDTO = Optional.empty();
        Optional<News> news = newsDAO.getEntityById(id);
        if(news.isPresent()) {
            newsDTO = Optional.of(NewsMapper.INSTANCE.newsToNewsDTO(news.get()));
        }
        return newsDTO;
    }

    @Override
    public Optional<NewsDTO> updateNews(News news) {
        if(StringValidator.isTitleValid(news.getTitle())
                && StringValidator.isContentValid(news.getContent())) {
            Optional<NewsDTO> newsDTO = Optional.empty();
            Optional<News> updateNews = newsDAO.update(news);
            if(updateNews.isPresent()) {
                newsDTO = Optional.of(NewsMapper.INSTANCE.newsToNewsDTO(updateNews.get()));
            }
            return newsDTO;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean deleteNews(Long id) {
        return newsDAO.delete(id);
    }

}
