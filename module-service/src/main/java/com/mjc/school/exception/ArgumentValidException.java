package com.mjc.school.exception;

public class ArgumentValidException extends Exception {

    public ArgumentValidException(String message) {
        super(message);
    }
    public ArgumentValidException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
