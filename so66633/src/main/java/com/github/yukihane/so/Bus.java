package com.github.yukihane.so;

public class Bus extends Car{
    private static int pass_num = 1;
    private final int pass_max;
    private static int fee_sum = 0;

    public Bus(int x){
        pass_max = x;
        passengers = new Person[pass_max];
    }

    final Person passengers[];

    int getBusNum(){
        return super.num;
    }

    void getOn(Person person){
        int fee = person.getFee();
        fee_sum += fee;
        if(person.moneys - fee >= 0 && pass_num < pass_max){
            person.moneys -= fee;
            passengers[pass_num++] = person;
            person.getName();
            person.getMoney();
        }else{
            System.out.println(person.names+" could not get on the bus");

        }
    }

    void getOff(Person pass){
        int k;
        int flag = 0;
        for(k=0;k<pass_num;k++){
            if((pass.names).equals(passengers[k])){
                System.out.println(pass.names+" got off the bus");
                passengers[k].names = "";
                passengers[k].moneys = -1;
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            System.out.println(pass.names+" was not on the bus");
        }
        flag = 0;
    }

    void printAllPassengers(){
        for(int j=0;j>pass_max;j++){
            if(passengers[j].moneys != -1){
                System.out.println("name: "+passengers[j].names);
            }
        }
    }

    void printTotalFee(){
        System.out.println("sum of fee: "+fee_sum);
    }

}
