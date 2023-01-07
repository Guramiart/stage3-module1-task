package com.mjc.school.controller;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.ServiceException;

import java.util.List;

public interface Controller<T extends NewsDto>{

    List<T> readAllNews();

    T readById(Long id) throws ServiceException;

    T create(T entity) throws ServiceException;

    T update(T entity) throws ServiceException;

    Boolean delete(Long id) throws ServiceException;
}
