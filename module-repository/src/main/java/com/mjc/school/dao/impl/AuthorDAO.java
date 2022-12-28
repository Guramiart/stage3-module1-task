package com.mjc.school.dao.impl;

import com.mjc.school.dao.AbstractDAO;
import com.mjc.school.entity.Author;

import java.util.List;
import java.util.Optional;

public class AuthorDAO extends AbstractDAO<Author> {

    public AuthorDAO() {}
    @Override
    protected List<Author> getList() {
        return getSourceLoader().getAuthorList();
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
