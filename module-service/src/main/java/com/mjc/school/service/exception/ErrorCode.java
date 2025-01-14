package com.mjc.school.service.exception;

public enum ErrorCode {
    NOT_EXIST("0101", "%s with id: %s doesn't exist"),
    NOT_NUMBER("0201", "%s id should be number"),
    NON_POSITIVE("0202", "%s id can't be null or less than 1. %s id is: %d"),
    NULL_CONTENT("0301", "%s can't be null. %s is null"),
    WRONG_LENGTH("0302", "News %s can't be less than %d and more than %d symbols. News %s is: %s");

    private final String errorCode;
    private final String message;
    ErrorCode(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorMessage() {
        return String.format("ERROR_CODE: %s ERROR_MESSAGE: %s", errorCode, message);
    }
}
