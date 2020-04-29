package com.github.yukihane.so;

//import org.rosuda.JRI.REXP;
//import org.rosuda.JRI.Rengine;
import javax.swing.*;
import java.awt.BorderLayout;

public class ZTestCalculation extends JFrame
{
     public static void main (String[] args)
     {
//        //This is a method to create graph and save it as png file
//        Rengine engine = new Rengine(new String[]{"--no-save"}, false, null);
//        engine.eval("png('normal.png', 640, 480)");
//        engine.eval("plot(dnorm, -4, 4)");
//        engine.eval("xvals <- seq(qnorm(10), 4, length=100)");
//        engine.eval("dvals <- dnorm(xvals)");
//        engine.eval("polygon(c(xvals,rev(xvals)),c(rep(0,100),rev(dvals)),col=\"gray\")");
//        engine.eval("dev.off()");
//        engine.end();
//
//This is a method to stick png file to JFrame
        SwingUtilities.invokeLater(() -> {
            ZTestCalculation frame = new ZTestCalculation();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(10, 10, 150, 150);
            frame.setTitle("Z-Graph");
            JPanel p = new JPanel();
            p.setSize(500, 640);
            ImageIcon icon = new ImageIcon("normal.png");
            JLabel label = new JLabel(icon);
            label.setIcon(icon);
            p.add(label);
            frame.getContentPane().add(p, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
