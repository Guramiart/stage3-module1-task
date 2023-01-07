package com.mjc.school.controller.impl;

import com.mjc.school.controller.Controller;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.ServiceException;
import com.mjc.school.service.interfaces.NewsService;
import com.mjc.school.service.impl.NewsServiceImpl;

import java.util.List;

public class NewsController implements Controller<NewsDto> {

    private final NewsService<NewsDto> newsService = new NewsServiceImpl();

    @Override
    public List<NewsDto> readAllNews() {
        return newsService.readAllNews();
    }

    @Override
    public NewsDto readById(Long id) throws ServiceException {
        return newsService.readById(id);
    }

    @Override
    public NewsDto create(NewsDto entity) throws ServiceException {
        return newsService.createNews(entity);
    }

    @Override
    public NewsDto update(NewsDto entity) throws ServiceException {
        return newsService.updateNews(entity);
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return newsService.deleteNews(id);
    }
}
