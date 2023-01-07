package com.mjc.school.repository.interfaces;

import java.util.List;

public interface Repository<T> {

    T create(T entity);
    List<T> readAll();
    T readById(Long id);
    T update(T entity);
    Boolean delete(Long id);

}
