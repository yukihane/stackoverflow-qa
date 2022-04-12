package com.github.yukihane.examples;

import java.awt.*;
import javax.swing.*;
public class Main{
    public static void main (String[] args){
        JFrame frame = new JFrame("GUI");
        int w = 600, h = 400;

        frame.setSize(w,h);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello World!");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(label);

        JButton button = new JButton("ここのボタンを押したらHello World!と出力したい");
        frame.getContentPane().add(button);




    }
}
