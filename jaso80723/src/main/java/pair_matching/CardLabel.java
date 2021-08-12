package pair_matching;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CardLabel extends JLabel{
    private int number;
    private boolean open = false;
    private ImageIcon open_icon;
    private ImageIcon reverse_icon;
    
    // コンストラクタの作成
    public CardLabel(ImageIcon open_icon, ImageIcon revers_icon, int number) {
        this.open_icon = open_icon;
        this.reverse_icon = revers_icon;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        if(open == true) {
            this.setIcon(open_icon);
        }else {
            this.setIcon(reverse_icon);
        }
        this.open = open;
    }

}
