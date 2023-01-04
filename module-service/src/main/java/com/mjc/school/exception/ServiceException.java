package com.mjc.school.exception;

public class ServiceException extends Exception {

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
