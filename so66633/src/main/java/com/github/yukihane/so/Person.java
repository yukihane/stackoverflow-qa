package com.github.yukihane.so;

abstract class Person{
    protected String names;
    protected int moneys;

    public Person(String name, int money){
        names = name;
        moneys = money;
    }

    void getName(){
        System.out.println("name:"+names);
    }

    void getMoney(){
        System.out.println("money:"+moneys);
    }

    void changeMoney(int used_money){
        moneys = moneys - used_money;
        if(moneys < 0){
            System.out.println("error:money cannot be less than 0");
        }
    } 

    void print(){
        System.out.println(names+" now has "+moneys+" yen");
    }

    abstract int getFee();

}
