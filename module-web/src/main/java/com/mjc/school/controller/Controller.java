package com.mjc.school.controller;

import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.service.exception.ServiceException;

import java.util.List;

public interface Controller<T extends NewsDTO>{

    List<T> getAllNews();

    T getNewsById(Long id) throws ServiceException;

    T create(T entity) throws ServiceException;

    T update(T entity) throws ServiceException;

    boolean delete(Long id) throws ServiceException;
}
