package com.mjc.school.controller.impl;

import com.mjc.school.controller.Controller;
import com.mjc.school.dto.NewsDTO;
import com.mjc.school.exception.ServiceException;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.impl.NewsServiceImpl;

import java.util.List;

public class NewsController implements Controller<NewsDTO> {

    private final NewsService<NewsDTO> newsService = new NewsServiceImpl();

    @Override
    public List<NewsDTO> getAllNews() {
        return newsService.getAllNews();
    }

    @Override
    public NewsDTO getNewsById(Long id) {
        return newsService.getNewsById(id).get();
    }

    @Override
    public NewsDTO create(NewsDTO entity) {
        try {
            return newsService.createNews(entity).get();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NewsDTO update(NewsDTO entity) {
        try {
            return newsService.updateNews(entity).get();
        } catch (ServiceException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean delete(Long id) {
        return newsService.deleteNews(id);
    }
}
