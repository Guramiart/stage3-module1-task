package com.mjc.school.exception;

public enum Error {
    NOT_EXIST("0101", "News with id: %s doesn't exist"),
    NON_NUMBER("0201", "News id should be number"),
    NON_POSITIVE("0202", "News id can't be null or less than 1. News id is: %s"),
    WRONG_LENGTH("0301", "News title can't be less than 5 and more than 30 symbols. News content is: %s");

    private final String errorCode;
    private final String message;
    Error(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("ERROR_CODE: %s ERROR_MESSAGE: %s", errorCode, message);
    }
}
