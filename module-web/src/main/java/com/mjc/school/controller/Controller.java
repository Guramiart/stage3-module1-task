package com.mjc.school.controller;

import com.mjc.school.dto.NewsDTO;

import java.util.List;
import java.util.Optional;

public interface Controller<T extends NewsDTO>{

    List<T> getAllNews();

    T getNewsById(Long id);

    T create(T entity);

    T update(T entity);

    boolean delete(Long id);
}
