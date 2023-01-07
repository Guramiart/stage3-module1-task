package com.mjc.school.controller;

import com.mjc.school.dto.NewsDTO;
import com.mjc.school.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface Controller<T extends NewsDTO>{

    List<T> getAllNews();

    T getNewsById(Long id) throws ServiceException;

    T create(T entity) throws ServiceException;

    T update(T entity) throws ServiceException;

    boolean delete(Long id) throws ServiceException;
}
