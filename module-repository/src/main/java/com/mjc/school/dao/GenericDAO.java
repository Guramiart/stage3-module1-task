package com.mjc.school.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {

    Optional<T> create(T entity);
    List<T> getAll();
    Optional<T> getEntityById(Long id);
    Optional<T> update(T entity);
    boolean delete(Long id);

}
