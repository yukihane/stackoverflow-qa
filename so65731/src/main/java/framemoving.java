//インポート・ファイル
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

//メイン・クラス

public class framemoving
{

    private final JFrame frame;

 //メイン・メソッド
 public static void main(String[] args)
 {
  framemoving test = new framemoving();
 }
 //コンストラクタ
 public framemoving()
 {

 //基礎フレームの設定。
 frame = new JFrame();
 frame.setSize(250,250);
 frame.setLocation(100, 100);
 frame.setTitle("Key_test");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setVisible(true);

 //キーボード・リスナーの設定
//フレームにキーボード入力の受信を登録
  frame.addKeyListener(new Keyboard_input());

 }

//キーボードのためのクラス

class Keyboard_input implements KeyListener
{
    public void keyPressed(KeyEvent e)
    {
        System.out.println("keyPressed.");

        // 現在の位置
        Point point = frame.getLocation();
        int x = point.x;
        int y = point.y;
        switch(e.getKeyCode()){
        case KeyEvent.VK_UP : y = y - 10; break;
        case KeyEvent.VK_RIGHT : x=x+10; break;
        case KeyEvent.VK_DOWN : y=y+10; break;
        case KeyEvent.VK_LEFT : x=x-10;  break;
    }
    frame.setLocation(x, y);
}
  public void keyReleased(KeyEvent e)
 {
  //keyReleasedに対するメッセージを表示
  System.out.println("keyReleased.");
}
 public void keyTyped(KeyEvent e)
 {
  //keyTypedに対するメッセージを表示
  System.out.println("keyTyped.");
 }
}}