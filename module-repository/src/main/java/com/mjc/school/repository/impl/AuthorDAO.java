package com.mjc.school.repository.impl;

import com.mjc.school.repository.dao.AbstractDAO;
import com.mjc.school.repository.entity.Author;

import java.util.List;
import java.util.Optional;

public class AuthorDAO extends AbstractDAO<Author> {

    public AuthorDAO() {}
    @Override
    protected List<Author> getList() {
        return super.dataSource.getAuthorList();
    }

    @Override
    public Optional<Author> create(Author entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Author> update(Author entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException();
    }

}
