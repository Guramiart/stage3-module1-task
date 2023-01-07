package com.mjc.school.repository.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {

    Optional<T> create(T entity);
    List<T> readAll();
    Optional<T> readById(Long id);
    Optional<T> update(T entity);
    Boolean delete(Long id);

}
