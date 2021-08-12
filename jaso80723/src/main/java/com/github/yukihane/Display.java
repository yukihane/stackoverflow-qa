package com.github.yukihane;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import pair_matching.CardList;

public class Display {

    public static void main(String[] arags) {
        SwingUtilities.invokeLater(()->{
            JFrame frame = new JFrame();
            frame.getContentPane().add(new CardList());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
