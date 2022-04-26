import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main {
    public static void main(final String[] args) throws Exception {
        final JFrame frame = new JFrame("MyGUI");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new FlowLayout());

        final JButton button = new JButton("Click here or Press\"w\":)"); //ここのボタンでwを押せるようにしたい
        frame.getContentPane().add(button);

        final JLabel label = new JLabel("クリックもしくはキーボード入力に反応しました。");
        frame.getContentPane().add(label);
        label.setVisible(false);

        button.addActionListener(e -> { //マウスカーソルだけでなく、キーボードにも反応してほしい
            label.setVisible(true);
        });

    }
}
