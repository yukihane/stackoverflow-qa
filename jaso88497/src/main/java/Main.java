import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;


public class Main {
    public static void main(final String[] args) throws Exception {
        final JFrame frame = new JFrame("MyGUI");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new FlowLayout());

        final JLabel label = new JLabel("クリックもしくはキーボード入力に反応しました。");
        label.setVisible(false);

        final Action buttonClickedAction = new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                label.setVisible(true);
            }
        };

        final JButton button = new JButton("Click here or Press\"w\":)"); //ここのボタンでwを押せるようにしたい

        button.addActionListener(buttonClickedAction);


        button.getInputMap().put(KeyStroke.getKeyStroke('w'), "buttonClicked");
        button.getActionMap().put("buttonClicked", buttonClickedAction);

        frame.getContentPane().add(button);

        frame.getContentPane().add(label);

    }
}
