package com.github.yukihane.so;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sample91ex3 extends JPanel {
    Circle[] circles = new Circle[20];
    //Circle sel = null;

    public Sample91ex3() {
        setOpaque(false);
        int x = 30;
        for (int i = 0; i < 20; ++i) {
            circles[i] = new Circle(Color.black, x, 100, 15);
            x = x + 40;
        }

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                for (int i = 0; i < 20; ++i) {
                    if (circles[i].hit(evt.getX(), evt.getY())) {
                        // sel = circles[i];
                        circles[i].changeColor();
                        circles[i].moveBy(10, 10);

                        repaint();
                    }

                }
                circles[3].hito(evt.getX(), evt.getY());
            }
        });
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < 20; ++i) {
            circles[i].draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame app = new JFrame();
        app.add(new Sample91ex3());
        app.setSize(800, 300);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    static class Circle {
        int xpos, ypos, rad;
        Color col;

        public Circle(Color c, int x, int y, int r) {
            col = c;
            xpos = x;
            ypos = y;
            rad = r;
        }

        public void draw(Graphics g) {
            g.setColor(col);
            g.fillOval(xpos - rad, ypos - rad, rad * 2, rad * 2);
        }

        public void moveBy(int x, int y) {
            xpos = xpos + x;
            ypos = ypos + y;
        }

        public void moveTo(int x, int y) {
            xpos = x;
            ypos = y;
        }

        public boolean hit(int x, int y) {
            return (xpos - x) * (xpos - x) + (ypos - y) * (ypos - y) <= rad * rad;
        }

        public void hito(int x, int y) {
            double a = x + y;
            System.out.println(a);

        }

        public void setColor(Color c) {
            col = c;
        }

        public void changeColor() {
            col = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
                (int) (Math.random() * 255));
        }
    }
}