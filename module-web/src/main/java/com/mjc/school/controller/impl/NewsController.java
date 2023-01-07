package com.mjc.school.controller.impl;

import com.mjc.school.controller.Controller;
import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.service.exception.ServiceException;
import com.mjc.school.service.interfaces.NewsService;
import com.mjc.school.service.impl.NewsServiceImpl;

import java.util.List;

public class NewsController implements Controller<NewsDTO> {

    private final NewsService<NewsDTO> newsService = new NewsServiceImpl();

    @Override
    public List<NewsDTO> getAllNews() {
        return newsService.getAllNews();
    }

    @Override
    public NewsDTO getNewsById(Long id) throws ServiceException {
        return newsService.getNewsById(id).get();
    }

    @Override
    public NewsDTO create(NewsDTO entity) throws ServiceException {
        return newsService.createNews(entity).get();
    }

    @Override
    public NewsDTO update(NewsDTO entity) throws ServiceException {
        return newsService.updateNews(entity).get();
    }

    @Override
    public boolean delete(Long id) throws ServiceException {
        return newsService.deleteNews(id);
    }
}
