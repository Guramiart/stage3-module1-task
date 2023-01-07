package com.mjc.school.service.interfaces;

import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface NewsService<T extends NewsDTO> {

    T createNews(T entity) throws ServiceException;

    List<T> getAllNews();

    T getNewsById(Long id) throws ServiceException;

    T updateNews(T entity) throws ServiceException;

    boolean deleteNews(Long id) throws ServiceException;

}
