package pair_matching;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CardList extends JPanel{
    ArrayList<CardLabel> cards = new ArrayList<>();
    // ラベルをリストにする -> リストの各ラベルにImageIconをセット -> リストをコレクションシャッフル
    boolean flg = false;
    
    final int club = 0;
    final int diamond = 1;
    final int heart = 2;
    final int spade = 3;
    
    /* カード画像 */
    // 裏面
    ImageIcon card_back = new ImageIcon("image/card_back.png");
    // 表面
    ImageIcon[][] card_array = new ImageIcon[4][13];
    String filename;
    
    // 割り当て
    int[] Array2 = {
            0,1,2,3,4,5,6,7,8,9,10,11,12,
            13,14,15,16,17,18,19,20,21,22,23,24,25,
            26,27,28,29,30,31,32,33,34,35,36,37,38,
            39,40,41,42,43,44,45,46,47,48,49,50,51
    };
    
    public CardList() {
        setPreferredSize(new Dimension(1150, 550));
        
        // Card_image
        for(int i = 0; i < card_array.length; i++) {
            for(int j = 0; j < card_array[i].length; j++) {
                filename = "image/card";
                switch(i) {
                case club:
                    filename = filename + "_club_";
                    break;
                case diamond:
                    filename = filename + "_diamond_";
                    break;
                case heart:
                    filename = filename + "_heart_";
                    break;
                case spade:
                    filename = filename + "_spade_";
                    break;
                }
                // ファイル名に数字を足す -> 拡張子を足す
                filename = String.format(filename + "%02d", j+1);
                filename = filename + ".png";
                card_array[i][j] = new ImageIcon(filename);
                CardLabel tmp_label = new CardLabel(card_array[i][j],card_back,j);
                // tmp_labelを押下したら、ひっくり返るのはtmp_label
                tmp_label.addMouseListener(new Cardclick_Listener(tmp_label));
                cards.add(tmp_label);
            }
        }
        
        // 表面のカードをシャッフル
        Collections.shuffle(cards);
        
    }

}
