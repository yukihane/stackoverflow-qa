import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

public class JsCalcW2 {                         // JsCalcW.java [java]
    private static void createAndShowGUI() {
        // フレームの作成
        JFrame frame = new JFrame("JsCalcW");   // JFrameオブジェクトを生成
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                // ウィンドウを閉じるとプログラムが終了
        MyPanel h = new MyPanel();
        frame.add(h, BorderLayout.CENTER);      // フレームにオブジェクトを置く
        frame.pack();                           // フレームを必要最小の大きさにする
        frame.setMinimumSize(new Dimension(frame.getSize().width, frame.getSize().height));
                                                // 最小サイズを指定 1.6以上で有効
        frame.setVisible(true);                 // フレームを表示する
    }
    // main関数
    public static void main(final String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

class MyPanel extends JPanel implements ActionListener { // JPanelを継承
    JButton    btn1, btn2;
    JTextField txt1, txt2;
    ArrayList<String> sHis = new ArrayList<String>();
    int iCnt = 0;
    
    JButton[] aBtn = new JButton[20];           // 追加ボタン
    String [] sBtD = {                          // 表示用
        "７","８","９","÷","CE",
        "４","５","６","×","√",
        "１","２","３","?","％",
        "０","．","（","＋","）"
    };
    String [] sBtO = {                          // 出力用
        "7","8","9","/","",
        "4","5","6","*","sqrt(",
        "1","2","3","-","%",
        "0",".","(","+",")"
    };
    
    public MyPanel() {
        setBackground(SystemColor.control);     // 背景を灰色にする

        txt1 = new JTextField(15);              // txtの設定
        txt1.addActionListener(this);
        txt1.addKeyListener(new MyKeyListener());   // リスナーオブジェクトを指定
        txt1.setFont(new Font("SansSerif",Font.PLAIN,16));

        txt2 = new JTextField(15);              // txtの設定
        txt2.setFont(new Font("SansSerif",Font.ITALIC,16));
        txt2.setHorizontalAlignment(JTextField.RIGHT);

        btn1 = new JButton("＝");
        btn1.addActionListener(this);

        btn2 = new JButton("Ｃ");
        btn2.addActionListener(this);

        for(int i = 0; i< aBtn.length; i++)
            aBtn[i] = new JButton(sBtD[i]);
        for(JButton b : aBtn)
            b.addActionListener(this);

        JPanel pa = new JPanel();
        pa.setLayout(new GridLayout(2,1,2,2));
        pa.add(txt1);
        pa.add(txt2);
        
        JPanel pb = new JPanel();
        pb.setLayout(new GridLayout(2,1,2,2));
        pb.add(btn1);
        pb.add(btn2);
        
        JPanel pc = new JPanel();
        pc.setLayout(new GridLayout(4,5,2,2));
        for(JButton b : aBtn)
            pc.add(b);
        
        setLayout(new BorderLayout(2,2));
        add(pa, BorderLayout.CENTER);
        add(pb, BorderLayout.EAST);
        add(pc, BorderLayout.SOUTH);
        
        JsCalc.defUserFunc();                   // ユーザー定義関数の設定
        sHis.add(""); iCnt = sHis.size()-1;
    }

    public void actionPerformed(ActionEvent e) {    // ボタンクリック
        if(e.getSource()==btn1||e.getSource()==txt1) {
            String s = txt1.getText(); sHis.add(s); iCnt = sHis.size()-1;
            txt2.setText(JsCalc.sEval(s));
        } else if(e.getSource()==btn2) {
            txt1.setText(""); txt2.setText("");
        } else if(e.getSource()==aBtn[4]) {     // [CE]
            String s = txt1.getText();
            if(s.length()> 0) s = s.substring(0, s.length()-1);
            txt1.setText(s);
        }
        for(int i = 0; i< aBtn.length; i++)
            if(e.getSource()==aBtn[i])
                txt1.setText(txt1.getText()+sBtO[i]);
        txt1.requestFocus();
    }

    class MyKeyListener extends KeyAdapter {    // リスナークラス
        public void keyPressed(KeyEvent e){ 
            int k = e.getKeyCode();
            
            if       (k == KeyEvent.VK_DOWN) {
                iCnt++;
                if(iCnt> sHis.size()) iCnt = sHis.size();
                txt2.setText(""); txt1.setText(sHis.get(iCnt % sHis.size()));
            } else if(k == KeyEvent.VK_UP) {
                iCnt--;
                if(iCnt< 1) iCnt = 1;
                txt2.setText(""); txt1.setText(sHis.get(iCnt % sHis.size()));
            }
        }
    }
}