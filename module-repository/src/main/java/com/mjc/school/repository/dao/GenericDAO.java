package com.mjc.school.repository.dao;

import java.util.List;

public interface GenericDAO<T> {

    T create(T entity);
    List<T> readAll();
    T readById(Long id);
    T update(T entity);
    Boolean delete(Long id);

}
