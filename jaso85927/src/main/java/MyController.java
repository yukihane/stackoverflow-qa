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
                this.slider = new JSlider();


                this.timer = new Timer(90, this); // 0.5秒ごとにthisのactionPerformedメソッドを呼び出す様に設定
                this.timer.start();                // タイマースタート

                Toolkit tk = Toolkit.getDefaultToolkit();
                this.tracker = new MediaTracker(this);

                this.slider = new JSlider();
                this.panel = new JPanel();

                this.slider.setMaximum(5000); /* スライダの最大値 */
                this.slider.addChangeListener(this);

                this.label = new JLabel();
                //label.setText("風の強さ：" + slider.getValue());



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

        }

        public void actionPerformed(ActionEvent e){
                System.out.println("in actionPerform: ");
                this.mp.repaint(); // 描画パネル「に対して」再描画を指示する
                Toolkit.getDefaultToolkit().sync(); // CentOSの不具合対策
        }

        public void stateChanged(ChangeEvent e0){
                this.timer = new Timer(this.slider.getValue(), this);
                this.timer.start();
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
