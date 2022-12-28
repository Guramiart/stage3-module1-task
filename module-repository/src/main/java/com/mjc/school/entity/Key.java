package com.mjc.school.entity;

public class Key {

    private static Long increment = 0L;
    private final Long id;

    public Key() {
        increment++;
        this.id = increment;
    }

    public Long getId() {
        return id;
    }
}
