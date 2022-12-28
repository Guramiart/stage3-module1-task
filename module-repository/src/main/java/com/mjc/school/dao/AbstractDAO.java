package com.mjc.school.dao;

import com.mjc.school.entity.Key;
import com.mjc.school.loader.SourceLoader;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class AbstractDAO<T extends Key> implements GenericDAO<T> {

    private final SourceLoader sourceLoader;

    protected AbstractDAO() {
        this.sourceLoader = SourceLoader.getInstance();
    }

    protected abstract List<T> getList();

    @Override
    public List<T> getAll() {
        return getList();
    }

    public Optional<T> getEntityById(Long id) {
        return getList().stream().filter(el -> Objects.equals(el.getId(), id)).findFirst();
    }

    public SourceLoader getSourceLoader() {
        return sourceLoader;
    }
}
