import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;

public class MyController extends JFrame implements ActionListener,ChangeListener
{
        private Timer timer;
        private MyView mp;
        private Image[]  chara_array;
        private MediaTracker tracker;

        private JSlider slider;
        private JLabel label;
        private JPanel panel;


        public MyController()
        {
                // 0.5秒おきに1回呼び出し
                final int initialValue = 500;

                this.timer = new Timer(initialValue, this); // 0.5秒ごとにthisのactionPerformedメソッドを呼び出す様に設定

                this.slider = new JSlider(1, 5000, initialValue);
                this.slider.addChangeListener(this);

                Toolkit tk = Toolkit.getDefaultToolkit();
                this.tracker = new MediaTracker(this);

                this.panel = new JPanel();
                this.label = new JLabel();

                Image[] chara_array = new Image[3]; // Imageクラスの配列
                for (int i = 0; i < 3; i++)
                        {
                                chara_array[i] = tk.getImage("husya" + i + ".png"); // chara0.png, ..., chara9.png
                                this.tracker.addImage(chara_array[i], 1);
                        }

                        this.mp = new MyView(chara_array);

                        mp.add(slider, BorderLayout.CENTER);
                        mp.add(label, BorderLayout.SOUTH);


                  super.getContentPane().add(this.mp);

                  // 手動でイベント発火させることで初期状態設定
                  SwingUtilities.invokeLater(()-> stateChanged(new ChangeEvent(this.slider)));
        }

        public void actionPerformed(ActionEvent e){
                System.out.println("in actionPerform: ");
                this.mp.repaint(); // 描画パネル「に対して」再描画を指示する
                Toolkit.getDefaultToolkit().sync(); // CentOSの不具合対策
        }

        public void stateChanged(ChangeEvent e0){
                // スライダーの値を基にタイマーを再設定
                this.timer.setDelay(((JSlider)e0.getSource()).getValue());
                this.timer.restart();
                this.label.setText("風の強さ：" + slider.getValue());
        }



        public static void main(String[] args) {
            MyController a = new MyController();

            a.setSize(1600,930);
            a.setLocation(0,0);
            //a.pack();
            a.setVisible(true);
        }
}
