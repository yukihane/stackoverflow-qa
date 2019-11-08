package com.github.yukihane;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App extends JFrame {

    private static final long serialVersionUID = -3034008389766810149L;

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public App() {

        super("HELLO WORLD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel("Hello World");
        getContentPane().add(label);
        setPreferredSize(new Dimension(150, 100));

        pack();
    }

    public static void main(final String[] args) {

        LOG.info("Hello, executable JAR!");

        javax.swing.SwingUtilities.invokeLater(() -> {
            final App app = new App();
            app.setVisible(true);
        });
    }
}
