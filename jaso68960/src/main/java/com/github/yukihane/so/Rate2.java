package com.github.yukihane.so;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Rate2 extends JFrame {
    int n;
    JMenuBar mbar = new JMenuBar();
    JTextField f0 = new JTextField("");
    JButton b0 = new JButton("実行");

    JLabel l1 = new JLabel("Input a number and press the button.");
    JMenu menu1 = new JMenu("Currency");
    JMenuItem item01 = new JMenuItem("USD to JPY");
    JMenuItem item02 = new JMenuItem("CNY to JPY");
    boolean a = false;
    boolean b = false;

    public Rate2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("menu sample");
        setLayout(null);

        add(f0);
        f0.setBounds(100, 50, 50, 30);
        add(b0);
        b0.setBounds(150, 50, 50, 30);
        mbar.add(menu1);
        setJMenuBar(mbar);
        menu1.add(item01);
        menu1.add(item02);

        add(l1);
        l1.setBounds(150, 140, 150, 100);
        //pack(); 
        setSize(400, 300);

        item01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                a = true;
                b = !a;
            }
        });

        item02.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b = true;
                a = !b;
            }
        });

        b0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (a) {
                    Double n = Double.parseDouble(f0.getText());

                    Dollar d1 = new Dollar(n);
                    Double d2 = d1.Ex();
                    l1.setText(n + "USDは" + d2 + "円");
                } else if (b) {
                    Double n = Double.parseDouble(f0.getText());

                    CNY c1 = new CNY(n);
                    Double c2 = c1.Ex2();

                    l1.setText(n + "人民元は" + c2 + "円");
                }

                else {
                    return;
                }

            }
        });
    }

    public static void main(String[] args) throws Exception {
        new Rate2().setVisible(true);
    }

    static class Dollar {
        int d = 100;

        Double dl;
        Double n;

        public Dollar(Double n) {
            this.n = n;

        }

        public Double Ex() {
            return dl = d * n;
        }

    }

    static class CNY {
        Double cn;
        int c = 15;
        Double n;

        public CNY(Double n) {
            this.n = n;
        }

        public Double Ex2() {
            return cn = c * n;

        }
    }
}