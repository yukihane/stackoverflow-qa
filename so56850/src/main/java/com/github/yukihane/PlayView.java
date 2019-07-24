package com.github.yukihane;

import java.awt.*;
import java.swing.*;

public class PlayView extends JPanel implements KeyListener, Runnable{

    public JPanel panel = new JPanel(); //全部のコンポ―ネントを乗せるJPanel
    public static JPanel[] lane = new JPanel[4];
    public JLabel[] judge = new JLabel[4];
    public JLabel combo = new JLabel();
    public Dimension panelsize = null;

public PlayView() {

        for (int i = 0; i < 4; i++) { 
            lane[i] = new JPanel();
            judge[i] = new JLabel();
        }

        panel.setSize(800, 600);
        panel.setLayout(null);

        for (int i = 0; i < 4; i++) { //座標指定でコンポーネントを配置
            lane[i].setBounds(200 * i, 0, 200, 500);
            judge[i].setBounds(200 * i, 520, 200, 60);
            lane[i].setBackground(new Color(211,211,211));
            lane[i].setBorder(new EtchedBorder(EtchedBorder.RAISED));
            judge[i].setBorder(new EtchedBorder(EtchedBorder.RAISED));
            judge[i].setFont(new Font("Arial",Font.PLAIN,27));
            judge[i].setForeground(new Color(220,20,60));
            panel.add(lane[i]);
            panel.add(judge[i]);
        }

        this.panelsize = lane[0].getSize();

        panel.setBackground(new Color(135,206,235));
        panel.addKeyListener(this);

    }

@Override
    public void run() {
        while (this.isVisible())  {
            panel.repaint();　//10msごとにpanelの再描画
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        //System.out.println("paintComponent");
        //super.paintComponent(g);
        g.setColor(new Color(255, 255, 255));//211,211,211
        for (int i = 0; i < 4; i++) {
            g.fillRect(200 * i, 0, (int) this.panelsize.getWidth(), (int) this.panelsize.getHeight());
        }
        //座標をランダムに変えて画像を描画
        for(int i = 0; i < 4; i++){
　　　　　  g.drawImage((new ImageIcon("hoge.png")).getImage(), (int)Math.random() * (int) this.panelsize.getWidth(), 
           (int)Math.random() * (int) this.panelsize.getHeight(), lane[i]);
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
    if (arg0.getKeyCode() == KeyEvent.VK_SPACE) { //spaceを押したらrun()呼び出し
          Thread thread = new Thread(this);
          thread.start(); //this.run()の中身実行？
    }
}