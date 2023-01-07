package com.mjc.school.repository.entity;

public class Author extends Entity {

    private String name;

    public Author() {
        super(0L);
    }

    public Author(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static AuthorBuilder getBuilder() {
        return new AuthorBuilder();
    }

    public static class AuthorBuilder {

        private final Author author = new Author();

        public AuthorBuilder setId(Long id) {
            author.setId(id);
            return this;
        }
        public AuthorBuilder setName(String name) {
            author.name = name;
            return this;
        }
        public Author build() {
            return author;
        }
    }
}
