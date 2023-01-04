package com.mjc.school.controller.impl;

import com.mjc.school.controller.Controller;
import com.mjc.school.dto.NewsDTO;
import com.mjc.school.exception.ServiceException;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.impl.NewsServiceImpl;

import java.util.List;
import java.util.Optional;

public class NewsController implements Controller<NewsDTO> {

    private final NewsService<NewsDTO> newsService = new NewsServiceImpl();

    @Override
    public List<NewsDTO> getAllNews() {
        return newsService.getAllNews();
    }

    @Override
    public Optional<NewsDTO> getNewsById(Long id) {
        return newsService.getNewsById(id);
    }

    @Override
    public Optional<NewsDTO> create(NewsDTO entity) {
        try {
            return newsService.createNews(entity);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<NewsDTO> update(NewsDTO entity) {
        try {
            return newsService.updateNews(entity);
        } catch (ServiceException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean delete(Long id) {
        return newsService.deleteNews(id);
    }
}
