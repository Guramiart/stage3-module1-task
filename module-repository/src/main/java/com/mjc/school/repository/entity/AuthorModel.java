package com.mjc.school.repository.entity;

public class AuthorModel extends Entity {

    private String name;

    public AuthorModel() {
        super(0L);
    }

    public AuthorModel(Long id, String name) {
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

        private final AuthorModel authorModel = new AuthorModel();

        public AuthorBuilder setId(Long id) {
            authorModel.setId(id);
            return this;
        }
        public AuthorBuilder setName(String name) {
            authorModel.name = name;
            return this;
        }
        public AuthorModel build() {
            return authorModel;
        }
    }
}
