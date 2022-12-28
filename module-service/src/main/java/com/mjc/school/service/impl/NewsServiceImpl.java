package com.mjc.school.service.impl;

import com.mjc.school.dao.AbstractDAO;
import com.mjc.school.dao.impl.AuthorDAO;
import com.mjc.school.dao.impl.NewsDAO;
import com.mjc.school.dto.NewsDTO;
import com.mjc.school.entity.Author;
import com.mjc.school.entity.News;
import com.mjc.school.mapper.NewsMapper;
import com.mjc.school.service.NewsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewsServiceImpl implements NewsService<NewsDTO> {

    private final AbstractDAO<News> newsDAO;
    private final AbstractDAO<Author> authorDAO;

    public NewsServiceImpl() {
        newsDAO = new NewsDAO();
        authorDAO = new AuthorDAO();
    }

    @Override
    public Optional<NewsDTO> createNews(String title, String content, Long authorId) {
        return Optional.empty();
    }

    @Override
    public List<NewsDTO> getAllNews() {
        List<NewsDTO> news = new ArrayList<>();
        for(News elem : newsDAO.getAll()) {
            Optional<Author> author = authorDAO.getEntityById(elem.getAuthorId());
            author.ifPresent(value -> news.add(NewsMapper.INSTANCE.newsToNewsDTO(elem, value)));
        }
        return news;
    }

    @Override
    public Optional<NewsDTO> getNewsById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<NewsDTO> updateNews(String title, String content, Long authorId) {
        return Optional.empty();
    }

    @Override
    public boolean deleteNews(Long id) {
        return false;
    }

}
