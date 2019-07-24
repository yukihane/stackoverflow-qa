package com.github.yukihane;

import java.awt.*;
import java.swing.*;

public class MainFrame extends JFrame implements KeyListener {
    PlayView pv = new PlayView();
    public MainFrame() {
        this.add(pv.panel);
        pv.panel.setVisible(true);
        this.setBounds(200, 100, 800, 600);
        this.addKeyListener(pv);
    }
    public static void main(String[] args) {
        MainFrame f = new MainFrame();
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}