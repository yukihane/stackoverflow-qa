package com.github.yukihane.examples;

import java.util.ArrayList;
import java.util.Random;
public class Main{
    public static void main (String[] args){

        Random random = new Random();
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Ruby");
        languages.add("PHP");
        languages.add("Swift");
        languages.add("Python");

        String language = languages.get(random.nextInt(5));
        System.out.println(language);

    }
}
