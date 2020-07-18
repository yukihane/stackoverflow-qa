package com.github.yukihane.so;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample91ex2 extends JPanel {
    Circle c1 = new Circle(Color.RED, 100, 50, 50);
    Circle c2 = new Circle(Color.BLUE, 150, 90, 40);
    Circle sel;

    public Sample91ex2() {
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                requestFocus();
                if(c1.hit(evt.getX(), evt.getY())) {
                    sel = c1;
                } else if(c2.hit(evt.getX(), evt.getY())) {
                    sel = c2;
                }
                else sel=null;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                if(sel == null) { return; }

                    sel.moveTo(evt.getX(), evt.getY()); repaint();

                }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                if(evt.isShiftDown()) {
                    c2.moveTo(evt.getX(), evt.getY()); repaint();
                } else {
                    c1.moveTo(evt.getX(), evt.getY()); repaint();
                }
            }
        });

    }
    public void paintComponent(Graphics g) {
        c1.draw(g); c2.draw(g);
    }
    public static void main(String[] args) {
        JFrame app = new JFrame();
        app.add(new Sample91ex2());
        app.setSize(400, 300);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
    static class Circle {
        Color col;
        int xpos, ypos, rad;
        public Circle(Color c, int x, int y, int r) {
            col = c; xpos = x; ypos = y; rad = r;
        }
        public void moveTo(int x, int y) {
            xpos = x; ypos = y;
        }

        public boolean hit(int x, int y) {
            return (xpos-x)*(xpos-x) + (ypos-y)*(ypos-y) <= rad*rad;
        }
        public void draw(Graphics g) {
            g.setColor(col);
            g.fillOval(xpos-rad, ypos-rad, rad*2, rad*2);
        }
    }
}