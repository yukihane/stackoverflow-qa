package com.github.yukihane.so;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 * Hello world!
 */
public class App {

    public static void main(final String[] args) {
        final URL url = Object.class.getResource("/org/mozillatranslator/resource/mt_icon_small.gif");
        final Toolkit tk = Toolkit.getDefaultToolkit();

        final Image img = tk.getImage(url); // Raises runtime exception
    }
}
