package com.mjc.school.controller;

import com.mjc.school.dto.NewsDTO;
import com.mjc.school.service.NewsService;

import java.util.List;
import java.util.Optional;

public interface Controller<T extends NewsDTO>{

    List<T> getAllNews();

    Optional<T> getNewsById(Long id);

    Optional<T> create(T entity);

    Optional<T> update(T entity);

    boolean delete(Long id);
}
