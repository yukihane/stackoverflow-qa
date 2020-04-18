//インポート・ファイル
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

//メイン・クラス

public class framemoving
{

    int x = 100;
    int y = 100;

 //メイン・メソッド
 public static void main(String[] args)
 {
  framemoving test = new framemoving();
 }
 //コンストラクタ
 public framemoving()
 {

 //基礎フレームの設定。
 JFrame frame = new JFrame();
 frame.setSize(250,250);
 frame.setLocation(x, y);
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

        switch(e.getKeyCode()){
        case KeyEvent.VK_UP : y = y - 10; break;
        case KeyEvent.VK_RIGHT : x=x+10; break;
        case KeyEvent.VK_DOWN : y=y+10; break;
        case KeyEvent.VK_LEFT : x=x-10;  break;
    }
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