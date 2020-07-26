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
    JMenu menu1 = new JMenu("→to JPY"); 
    JMenu menu2=new JMenu("JPY to→");
    JMenuItem item01 = new JMenuItem("USD to JPY");
    JMenuItem item02 = new JMenuItem("CNY to JPY");
    JMenuItem item03 = new JMenuItem("Euro to JPY");
    JMenuItem item04 = new JMenuItem("JPY to USD");
    JMenuItem item05 = new JMenuItem("JPY to CNY");
    JMenuItem item06 = new JMenuItem("JPY to Euro");

    // それぞれのメニューについての選択/非選択状態は不要
    // boolean a=false;
    // boolean b=false;boolean c=false;boolean d;boolean e;boolean f;
    // 代わりに、どのメニューが選択状態か(1つに限られると思います)を覚えておく
    private JMenuItem selected;

    public Rate2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Please select Currency");
        setLayout(null);

        add(f0); f0.setBounds(100, 50, 50, 30);
        add(b0);b0.setBounds(150,50,50,30);
        mbar.add(menu1);mbar.add(menu2);setJMenuBar(mbar);
        menu1.add(item01);menu1.add(item02);menu1.add(item03);
        menu2.add(item04);menu2.add(item05);menu2.add(item06);

        add(l1);l1.setBounds(150,140,150,100);
        //pack(); 
        setSize(400, 300);

        ActionListener menuItemActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // a=true;
                // b=false;
                // c=false;
                // d=false;
                // e=false;
                // f=false;
                selected = (JMenuItem) evt.getSource();
            }
        };
        item01.addActionListener(menuItemActionListener);
        item02.addActionListener(menuItemActionListener);
        item03.addActionListener(menuItemActionListener);

        b0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(selected == item01){Double n=Double.parseDouble(f0.getText());

                Dollar d1=new Dollar(n);
                Double d2=d1.Ex();
                l1.setText(n+"USDは"+d2+"円");}
                else if(selected == item02){Double n=Double.parseDouble(f0.getText());
                //l1.C1(n);
                Other c1=new Other(n);
                Double c2=c1.Ex2();

                l1.setText(n+"人民元は"+c2+"円");}

                else if(selected == item03){Double n=Double.parseDouble(f0.getText());
                //l1.C1(n);
                Other c3=new Other(n);
                Double c4=c3.Ex3();

                l1.setText(n+"ユーロは"+c4+"円");}

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
    }
}
