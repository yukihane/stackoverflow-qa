package com.github.yukihane.so;

/**
 * Hello world!
 */
public class App {

    public static void main(final String[] args) throws ClassNotFoundException {
        final Class<?> obj1 = Class.forName("com.github.yukihane.so.App");
        System.out.println("obj1: " + obj1);
        final Class<?> obj2 = Class.forName("com.github.yukihane.so.NonExist");
        System.out.println("obj2: " + obj2);
    }
}
