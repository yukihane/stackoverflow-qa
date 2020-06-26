package com.github.yukihane.so;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

    public MyFrame() {
        // ...
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                shutdown();
                System.exit(0);
            }
        });
    }

    private void shutdown() {
    }
}
