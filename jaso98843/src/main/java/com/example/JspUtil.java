package com.example;

public class JspUtil {
    public static String notNull(String text) {
        if(text != null) {
            return text;
        }
        return "";
    }
}
