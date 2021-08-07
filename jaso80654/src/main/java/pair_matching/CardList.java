package pair_matching;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardList extends JPanel implements MouseListener{
    PairMatchListener pairMatchListener;
    JLabel[] cards = new JLabel[52];
    // cardの表裏 : 裏 -> false 表 -> true
    boolean flg = false;

    /* カード画像 */
    // 裏面
    ImageIcon card_back = new ImageIcon("image/card_back.png");
    // クローバー
    ImageIcon card_club_01 = new ImageIcon("image/card_club_01.png");
    ImageIcon card_club_02 = new ImageIcon("image/card_club_02.png");
    ImageIcon card_club_03 = new ImageIcon("image/card_club_03.png");
    ImageIcon card_club_04 = new ImageIcon("image/card_club_04.png");
    ImageIcon card_club_05 = new ImageIcon("image/card_club_05.png");
    ImageIcon card_club_06 = new ImageIcon("image/card_club_06.png");
    ImageIcon card_club_07 = new ImageIcon("image/card_club_07.png");
    ImageIcon card_club_08 = new ImageIcon("image/card_club_08.png");
    ImageIcon card_club_09 = new ImageIcon("image/card_club_09.png");
    ImageIcon card_club_10 = new ImageIcon("image/card_club_10.png");
    ImageIcon card_club_11 = new ImageIcon("image/card_club_11.png");
    ImageIcon card_club_12 = new ImageIcon("image/card_club_12.png");
    ImageIcon card_club_13 = new ImageIcon("image/card_club_13.png");
    // ダイヤ
    ImageIcon card_diamond_01 = new ImageIcon("image/card_diamond_01.png");
    ImageIcon card_diamond_02 = new ImageIcon("image/card_diamond_02.png");
    ImageIcon card_diamond_03 = new ImageIcon("image/card_diamond_03.png");
    ImageIcon card_diamond_04 = new ImageIcon("image/card_diamond_04.png");
    ImageIcon card_diamond_05 = new ImageIcon("image/card_diamond_05.png");
    ImageIcon card_diamond_06 = new ImageIcon("image/card_diamond_06.png");
    ImageIcon card_diamond_07 = new ImageIcon("image/card_diamond_07.png");
    ImageIcon card_diamond_08 = new ImageIcon("image/card_diamond_08.png");
    ImageIcon card_diamond_09 = new ImageIcon("image/card_diamond_09.png");
    ImageIcon card_diamond_10 = new ImageIcon("image/card_diamond_10.png");
    ImageIcon card_diamond_11 = new ImageIcon("image/card_diamond_11.png");
    ImageIcon card_diamond_12 = new ImageIcon("image/card_diamond_12.png");
    ImageIcon card_diamond_13 = new ImageIcon("image/card_diamond_13.png");
    // ハート
    ImageIcon card_heart_01 = new ImageIcon("image/card_heart_01.png");
    ImageIcon card_heart_02 = new ImageIcon("image/card_heart_02.png");
    ImageIcon card_heart_03 = new ImageIcon("image/card_heart_03.png");
    ImageIcon card_heart_04 = new ImageIcon("image/card_heart_04.png");
    ImageIcon card_heart_05 = new ImageIcon("image/card_heart_05.png");
    ImageIcon card_heart_06 = new ImageIcon("image/card_heart_06.png");
    ImageIcon card_heart_07 = new ImageIcon("image/card_heart_07.png");
    ImageIcon card_heart_08 = new ImageIcon("image/card_heart_08.png");
    ImageIcon card_heart_09 = new ImageIcon("image/card_heart_09.png");
    ImageIcon card_heart_10 = new ImageIcon("image/card_heart_10.png");
    ImageIcon card_heart_11 = new ImageIcon("image/card_heart_11.png");
    ImageIcon card_heart_12 = new ImageIcon("image/card_heart_12.png");
    ImageIcon card_heart_13 = new ImageIcon("image/card_heart_13.png");
    // スペード
    ImageIcon card_spade_01 = new ImageIcon("image/card_spade_01.png");
    ImageIcon card_spade_02 = new ImageIcon("image/card_spade_02.png");
    ImageIcon card_spade_03 = new ImageIcon("image/card_spade_03.png");
    ImageIcon card_spade_04 = new ImageIcon("image/card_spade_04.png");
    ImageIcon card_spade_05 = new ImageIcon("image/card_spade_05.png");
    ImageIcon card_spade_06 = new ImageIcon("image/card_spade_06.png");
    ImageIcon card_spade_07 = new ImageIcon("image/card_spade_07.png");
    ImageIcon card_spade_08 = new ImageIcon("image/card_spade_08.png");
    ImageIcon card_spade_09 = new ImageIcon("image/card_spade_09.png");
    ImageIcon card_spade_10 = new ImageIcon("image/card_spade_10.png");
    ImageIcon card_spade_11 = new ImageIcon("image/card_spade_11.png");
    ImageIcon card_spade_12 = new ImageIcon("image/card_spade_12.png");
    ImageIcon card_spade_13 = new ImageIcon("image/card_spade_13.png");

    // card : back -> 0, open -> 1
    int[] Array = {
            0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0
    };

    // ２次元 -> １次元に割り当て
    int[][] Array2 = {
            {1,2,3,4,5,6,7,8,9,10,11,12,13},
            {14,15,16,17,18,19,20,21,22,23,24,25,26},
            {27,28,29,30,31,32,33,34,35,36,37,38,39},
            {40,41,42,43,44,45,46,47,48,49,50,51,52}
    };

    // カードを開く処理
    int k = 0, open = 0;
    // 開いてるカード
    int o1 = 52, o2 = 52;

    public CardList() {
        int x = 8 , y = 8 , yc = 9;
        setPreferredSize(new Dimension(1150, 600));

        // back_label
        for(int i = 0; i < 52; i++) {
            cards[i] = new JLabel();
            cards[i].setLocation(x, y);
            if(i == yc) {
                y += 85;
                x = 8;
                yc += 10;
            }else {
                x += 60;
            }
            cards[i].setIcon(card_back);
            cards[i].addMouseListener(this);
            add(cards[i]);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // マウスボタン押下 -> 離すとEvent発生

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}