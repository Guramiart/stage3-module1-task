package com.mjc.school.utils;

import com.mjc.school.exception.ArgumentValidException;
import com.mjc.school.exception.Error;

public class Validator {

    private static final int MIN_TITLE_LENGTH = 5;
    private static final int MAX_TITLE_LENGTH = 30;
    private static final int MIN_CONTENT_LENGTH = 5;
    private static final int MAX_CONTENT_LENGTH = 250;

    public static boolean isTitleValid(String str) throws ArgumentValidException {
        if(str.length() > MIN_TITLE_LENGTH && str.length() < MAX_TITLE_LENGTH) {
            return true;
        } else {
            throw new ArgumentValidException("");
        }
    }

    public static boolean isContentValid(String str) throws ArgumentValidException {
        if(str.length() > MIN_CONTENT_LENGTH && str.length() < MAX_CONTENT_LENGTH) {
            return true;
        } else {
            throw new ArgumentValidException("");
        }
    }
}
