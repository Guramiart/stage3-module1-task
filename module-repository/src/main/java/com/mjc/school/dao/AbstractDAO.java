package com.mjc.school.dao;

import com.mjc.school.entity.Entity;
import com.mjc.school.source.DataSource;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class AbstractDAO<T extends Entity> implements GenericDAO<T> {

    protected final DataSource dataSource;

    protected AbstractDAO() {
        this.dataSource = DataSource.getInstance();
    }

    protected abstract List<T> getList();

    @Override
    public List<T> getAll() {
        return getList();
    }

    public Optional<T> getEntityById(Long id) {
        return getList().stream().filter(el -> Objects.equals(el.getId(), id)).findFirst();
    }
    
}
