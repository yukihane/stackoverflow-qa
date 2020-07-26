package com.github.yukihane.so;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rate2 extends JFrame {
  int n;
  JMenuBar mbar = new JMenuBar();
  JTextField f0 = new JTextField("");
  JButton b0 = new JButton("実行");
 
  JLabel l1 = new JLabel("Input a number and press the button.");
  JMenu menu1 = new JMenu("Foreign Currency→to JPY"); 
  JMenu menu2=new JMenu("JPY to→Foreign Currency");
  JMenuItem item01 = new JMenuItem("USD to JPY");
  JMenuItem item02 = new JMenuItem("CNY to JPY");
  JMenuItem item03= new JMenuItem("Euro to JPY");
  JMenuItem item04 = new JMenuItem("JPY to USD");
  JMenuItem item05 = new JMenuItem("JPY to CNY");
  JMenuItem item06= new JMenuItem("JPY to Euro");

  boolean a=false;
 // boolean b=false;boolean c=false;boolean d;boolean e;boolean f;
  boolean[]t=new boolean[6];

  // 対応する配列要素をtrueに、それ以外をfalseにする
  private void setSelected(int menuNum) {
    for (int i = 0; i < 6; i++) {
      t[i] = false;
    }
    t[menuNum] = true;
  }

  public Rate2() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setTitle("Please select Currency");
    setLayout(null);
    
    
    add(f0); f0.setBounds(100, 50, 50, 30);
    add(b0);b0.setBounds(150,50,50,30);
    mbar.add(menu1);mbar.add(menu2);setJMenuBar(mbar);
    menu1.add(item01);menu1.add(item02);menu1.add(item03);
    menu2.add(item04);menu2.add(item05);menu2.add(item06);
   
    add(l1);l1.setBounds(50,140,300,100);
    //pack(); 
    setSize(600, 400);
   
   

    item01.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
       
       // t[0]=true;t[1-5]=false;
       setSelected(0);
    }
});

    

    item02.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        // t[1]=true;t[0]=t[2-5]=false;
        setSelected(1);
      }
    });

    item03.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        // t[2]=true;t[0-1]=t[3-5]=false;
        setSelected(2);
      }
    });

    item04.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        // t[3]=true;t[0-2]=t[4-5]=false;
        setSelected(3);
      }
    });

    item05.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        // t[4]=true;t[0-3]=t[5]=false;
        setSelected(4);
      }
    });

    item06.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        // t[5]=true;t[0-4]=false;
        setSelected(5);
      }
    });
    
    b0.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        if(t[0]){Double n=Double.parseDouble(f0.getText());
        
            Dollar d1=new Dollar(n);
           Double d2=d1.Ex();
            l1.setText(n+"USDは"+d2+"円");}
        else if(t[1]){Double n=Double.parseDouble(f0.getText());
            //l1.C1(n);
            Other c1=new Other(n);
            Double c2=c1.Ex2();
            
            l1.setText(n+"人民元は"+c2+"円");}

        else if(t[2]){Double n=Double.parseDouble(f0.getText());
              
              Other c3=new Other(n);
              Double c4=c3.Ex3();
              
              l1.setText(n+"ユーロは"+c4+"円");}

       else if(t[3]){Double n=Double.parseDouble(f0.getText());
                
                Other c4=new Other(n);
                Double c5=c4.Ex4();
                
                l1.setText(n+"円は"+c5+"ドル");}

       else if(t[4]){Double n=Double.parseDouble(f0.getText());
                  
                  Other c5=new Other(n);
                  Double c6=c5.Ex5();
                  
                  l1.setText(n+"円は"+c6+"人民元");}

        else if(t[5]){Double n=Double.parseDouble(f0.getText());
                  
                    Other c6=new Other(n);
                    Double c7=c6.Ex6();
                    
                    l1.setText(n+"円は"+c7+"ユーロ");}

              
        
        else{return;} 
            
    
        }
      });
}


 public static void main(String[] args) throws Exception {
    new Rate2().setVisible(true);
    
  }


  
  
  static class Dollar{
   int d=106;
  // int c=15;
   Double dl;Double n;

   public Dollar(Double n){
     this.n=n;

   }

   public Double Ex(){
    return dl=d*n;
   }

  }

  static class Other {
     Double cn;
     int c=15;
     int d=123;
     double e=0.0094;
     double f=0.0667;
     double g=0.0081;
     Double n;
     public Other(Double n){
       this.n=n;
     }
     
     public Double Ex2(){
      return cn=c*n;
      
     }

     public Double Ex3(){
       return cn=d*n;
     }

     public Double Ex4(){
      return cn=e*n;
    }

    public Double Ex5(){
      return cn=f*n;
    }

    public Double Ex6(){
      return cn=g*n;
    }

  }
}
