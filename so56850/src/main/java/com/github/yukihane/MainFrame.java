package com.github.yukihane;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

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

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
