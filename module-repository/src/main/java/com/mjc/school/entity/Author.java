package com.mjc.school.entity;

public class Author extends Entity {

    private static Long increment = 0L;

    private Long id;
    private String name;

    public Author() {
        super(++increment);
    }

    public Author(String name) {
        this();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static AuthorBuilder getBuilder() {
        return new AuthorBuilder();
    }

    public static class AuthorBuilder {

        private final Author author = new Author();

        public AuthorBuilder setId(Long id) {
            author.id = id;
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
