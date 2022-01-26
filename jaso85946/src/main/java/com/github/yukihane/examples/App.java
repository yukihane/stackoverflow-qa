package com.github.yukihane.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void main(final String[] args) {
        final List<String> str = new ArrayList<>();
        str.add("123abc");
        str.add("456[def]");

        System.out.println(str); // [123abc]
        System.out.println(str.toString().replaceAll("^\\[|\\]$", "")); // 123abc
        System.out.println(String.join(", ", str));
    }
}
