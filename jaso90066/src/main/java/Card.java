/**
 * カードクラス．絵柄，数字を持つ， 
 * 
 * @author 
 */

public class Card {
    
    /** 絵柄 */
    private int suit;
    /** 数字 */
    private int number;
    
    /**空のコンストラクタ*/
    public Card() {
        
    }
    
    /** 絵柄，数字を指定してインスタンスを作る */
    public Card(int suit,int number) {
        this.suit=suit;     
        this.number=number;
    }
    
    /**
     * 絵柄を取得する
     * 
     * @return 絵柄
     */
    public int getSuit() {
        return suit;
    }
    
    /**
     * 数字を取得する
     * 
     * @return 数字
     */
    public int getNumber() {
        return number;
    }
    
    /**
     * カードの整数表現を返すメソッド
     */
    public static int getIndex(int suit,int number) {
        int serialnumber=0;
        switch(suit) {
        case 0:serialnumber = number-1;break;
        case 1:serialnumber = number+12;break;
        case 2:serialnumber = number+25;break;
        case 3:serialnumber = number+38;break;
        case -1:serialnumber = -1;break;
        }
        return serialnumber;
    }
    
    /**
     * カードの文字列表現を返すメソッド
     */
    public static String getString(int suit,int number) {
        String stringsuit = null,stringnumber = null,stringtrump;
        switch(suit) {
        case 0:
            stringsuit = "スペード";
            break;
        case 1:
            stringsuit = "ダイヤ";
            break;
        case 2:
            stringsuit = "ハート";
            break;
        case 3:
            stringsuit = "クラブ";
            break;
        case -1:
            stringsuit = "ジョーカー";
            break;
        }
        
        if(number==1) {
            stringnumber = "A";
        }
        if(number==2) {
            stringnumber = "2";
        }
        if(number==3) {
            stringnumber = "3";
        }
        if(number==4) {
            stringnumber = "4";
        }
        if(number==5) {
            stringnumber = "5";
        }
        if(number==6) {
            stringnumber = "6";
        }
        if(number==7) {
            stringnumber = "7";
        }
        if(number==8) {
            stringnumber = "8";
        }
        if(number==9) {
            stringnumber = "9";
        }
        if(number==10) {
            stringnumber = "10";
        }
        if(number==11) {
            stringnumber = "J";
        }
        if(number==12) {
            stringnumber = "Q";
        }
        if(number==13) {
            stringnumber = "K";
        }
        if(number==0) {
            stringnumber = "";
        }
        
        stringtrump = stringsuit+stringnumber;
        
        return stringtrump;
    }
    
    /**
     * カード情報を整数表示に変換するメソッド 
     */
    public int toIndex() {
        int serialnumber = getIndex(suit,number);
        return serialnumber;
    }
    
    /**
     *  カード情報を文字列表示に変換するメソッド 
     */
    @Override
    public String toString() {
        String stringtrump = getString(suit,number);
        return stringtrump;
    }
    
    /**
     *  カード情報を画面に出力するメソッド
     */
    public void show() {
        System.out.println(toString());
    }
    
}
