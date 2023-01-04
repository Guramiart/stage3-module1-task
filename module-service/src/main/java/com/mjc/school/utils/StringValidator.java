package com.mjc.school.utils;

import com.mjc.school.exception.ArgumentValidException;

public class StringValidator {

    public static boolean isTitleValid(String str) throws ArgumentValidException {
        if(str.length() > 5 && str.length() < 30) {
            return true;
        } else {
            throw new ArgumentValidException("Title field should have length of value from 5 to 30");
        }
    }

    public static boolean isContentValid(String str) throws ArgumentValidException {
        if(str.length() > 5 && str.length() < 250) {
            return true;
        } else {
            throw new ArgumentValidException("Content field should have length of value from 5 to 255");
        }
    }
}
