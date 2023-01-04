package com.mjc.school.service;

import com.mjc.school.dto.NewsDTO;
import com.mjc.school.entity.News;
import com.mjc.school.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface NewsService<T extends NewsDTO> {

    Optional<T> createNews(T entity) throws ServiceException;

    List<T> getAllNews();

    Optional<T> getNewsById(Long id);

    Optional<T> updateNews(T entity) throws ServiceException;

    boolean deleteNews(Long id);

}
