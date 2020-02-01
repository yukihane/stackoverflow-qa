import java.awt.Graphics;
import javax.swing.*;

public class conditionalLab extends JPanel {

    int age;
    ImageIcon picture1;
    ImageIcon picture2;
    ImageIcon picture3;
    ImageIcon picture4;
    int jobs;

    public conditionalLab() {
        // Your custom initialization code here
        jobs = JOptionPane.showConfirmDialog(null, "Are you Student or Military?", "Laie Palms Cinemas",
                JOptionPane.YES_NO_OPTION);

        final String mike = JOptionPane.showInputDialog("Please enter your age.");
        age = Integer.parseInt(mike);

        picture1 = new ImageIcon("dolittle.png");
        picture2 = new ImageIcon("frozen2.png");
        picture3 = new ImageIcon("starwars9.png");
        picture4 = new ImageIcon("Daisy.png");
    }

    @Override
    public void paintComponent(Graphics g) {
        // Your custom rendering code here

        if ((jobs == JOptionPane.YES_OPTION) && (age >= 11) && (age <= 60)) {
            g.drawString("That will be $8.00, please", 10, 30);
            picture3.paintIcon(null, g, 10, 50);

        }

        else if ((jobs == JOptionPane.NO_OPTION) && (age >= 0) && (age <= 2)) {
            g.drawString("You get free!", 10, 10);
            picture1.paintIcon(null, g, 10, 50);

        }

        else if ((jobs == JOptionPane.NO_OPTION) && (age >= 3) && (age <= 11)) {
            g.drawString("You owe $7.00!", 10, 10);
            picture2.paintIcon(null, g, 10, 50);

        }

        else if ((jobs == JOptionPane.NO_OPTION) && (age >= 12) && (age <= 59)) {
            g.drawString("You owe $10.00!", 10, 10);
            picture3.paintIcon(null, g, 10, 50);

        }

        else if ((jobs == JOptionPane.NO_OPTION) && (age >= 60) && (age <= 119)) {
            g.drawString("That will be $7.00, please", 10, 10);
            picture4.paintIcon(null, g, 10, 50);

        }

        else {
            g.drawString("Are you sure you typed that correctly?", 10, 10);

        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize(300, 300);
            window.setContentPane(new conditionalLab());
            window.setVisible(true);
        });
    }
}
