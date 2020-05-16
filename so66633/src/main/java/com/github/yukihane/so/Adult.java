package com.github.yukihane.so;

public class Adult extends Person{
    int getFee(){
        return 200;
    }
    public Adult(String name, int money){
        super(name, money);
    }
}