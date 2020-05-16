package com.github.yukihane.so;

/**
 * Hello world!
 */
public class App {

    public static void main(final String[] args) {
        int x=100;
        Bus bus = new Bus(x);
        Person person = new Adult("myname", 300);
        bus.getOn(person);
        Person person2 = new Adult("myname2", 300);
        bus.getOn(person2);
    }
}
