package com.github.yukihane.so;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rate3 extends JPanel {
  int n;
  JMenuBar mbar = new JMenuBar();
  JTextField f0 = new JTextField("");
  JButton b0 = new JButton("実行");
 
  JLabel l1 = new JLabel("Input a number and press the button.");
  JMenu menu1 = new JMenu("Please select Currency"); 
  JMenuItem item01 = new JMenuItem("USD to JPY");
  JMenuItem item02 = new JMenuItem("CNY to JPY");
  JMenuItem item03= new JMenuItem("Euro to JPY");
  boolean a=false;
  boolean b=false;boolean c=false;
 
  

  public Rate3() {
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   // setTitle("Currency Exchange");
    setLayout(null);
    
    
    add(f0); f0.setBounds(100, 50, 50, 30);
    add(b0);b0.setBounds(150,50,50,30);
    mbar.add(menu1);setJMenuBar(mbar);
    menu1.add(item01);menu1.add(item02);menu1.add(item03);
   
    add(l1);l1.setBounds(150,140,150,100);
    //pack(); 
    setSize(400, 300);
   
   

    item01.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
       
       a=true;
       b=false;
       c=false;


    }
});

    

    item02.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        
        b=true;
        a=false;c=false;
        

      }
    });

    item03.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        
        c=true;
        a=false;b=!c;
        

      }
    });
    
    b0.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        if(a){Double n=Double.parseDouble(f0.getText());
        
            Dollar d1=new Dollar(n);
           Double d2=d1.Ex();
            l1.setText(n+"USDは"+d2+"円");}
        else if(b){Double n=Double.parseDouble(f0.getText());
           
            CNY c1=new CNY(n);
            Double c2=c1.Ex2();
            
            l1.setText(n+"人民元は"+c2+"円");}

        else if(c){Double n=Double.parseDouble(f0.getText());
              
              CNY c3=new CNY(n);
              Double c4=c3.Ex3();
              
              l1.setText(n+"ユーロは"+c4+"円");}
        
        else{return;} 
            
    
        }
      });
}


 public static void main(String[] args) throws Exception {
    new Rate3().setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setTitle("Currency Exchange");
  }


  static class Dollar{
   int d=100;
  
   Double dl;Double n;

   public Dollar(Double n){
     this.n=n;

   }

   public Double Ex(){
    return dl=d*n;
   }

  }

  static class CNY {
     Double cn;
     int c=15;
     int d=120;
     Double n;
     public CNY(Double n){
       this.n=n;
     }
     
     public Double Ex2(){
      return cn=c*n;
      
     }

     public Double Ex3(){
       return cn=d*n;
     }

  }
}
