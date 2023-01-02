package com.mjc.school.utils;

public class StringValidator {

    public static boolean isTitleValid(String str) {
        if(str.length() > 5 && str.length() < 30) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isContentValid(String str) {
        if(str.length() > 5 && str.length() < 250) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
