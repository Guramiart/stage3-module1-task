package com.mjc.school.service.interfaces;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.ServiceException;

import java.util.List;

public interface NewsService<T extends NewsDto> {

    T createNews(T entity) throws ServiceException;

    List<T> readAllNews();

    T readById(Long id) throws ServiceException;

    T updateNews(T entity) throws ServiceException;

    Boolean deleteNews(Long id) throws ServiceException;

}
