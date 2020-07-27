import java.util.*;
import java.awt.event.*;
import javax.swing.*;



    public class Main1{
        public static void main(String[]args){
            Hero a= new Hero();

            a.name = "ピカチュウ";
            a.hp=100;

            System.out.println("勇者"+a.name+"を生み出した！");

            a.sit(5);
        }
      }

        public class Hero{
          String name;
          int hp;
          int level=10;
      
          public void sleep(){
            this.hp=100;
            System.out.println(this.name+"は眠って回復した！");
          }
      
          public void sit(int sec){
            this.hp+=sec;
            System.out.println(this.name+"は"+sec+"秒座った");
          }
      }