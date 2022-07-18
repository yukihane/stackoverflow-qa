import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * カードデッキクラス． 
 * 
 * @author  
 */

public class CardDeck {
    /**カードデッキ，カードを登録するリスト*/
    private ArrayList<Card> cards = new ArrayList<>();
    
    /**空のインスタンスを作る*/
    public CardDeck() {
        
    }
    
    /**フルデッキを作るメソッド*/
    public void createFullDeck() {
        int i,j;
        for(i=0;i<4;i++) {
            for(j=1;j<14;j++) {
                Card card = new Card(i,j);
                addCard(card);
            }
        }
    }
    
    /**ジョーカーを追加するメソッド*/
    public void addJoker() {
        Card card = new Card(-1,0);
        addCard(card);
    }
    
    /**デッキを空にするメソッド*/
    public void clear() {
        cards.clear();
    }
    
    /**デッキのカードをシャッフルするメソッド*/
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    /**デッキの最後にカードを追加するメソッド*/
    public void addCard(Card card) {
        cards.add(card);
    }
    
    /**指定された番号の場所にカードを追加するメソッド*/
    public void addCard(int i,Card card) {
        cards.add(i-1,card);
    }
    
    /**1番目のカードを取って返すメソッド*/
    public Card takeCard() {
        Card top = cards.get(0);
        cards.remove(0);
        return top;
    }
    
    /**指定された番号の場所のカードを取って返すメソッド*/
    public Card takeCard(int i) {
        Card trump = cards.get(i-1);
        cards.remove(i-1);
        return trump;
    }
    
    /**指定された番号の場所のカードの情報を返すメソッド*/
    public Card seeCard(int i) {
        Card trump = cards.get(i-1);
        return trump;
    }
    
    /**指定されたトランプがデッキの何番目にあるかを返すメソッド*/
    public int serchCard(int suit,int number) {
        Card card = new Card(suit,number);
        int num;
        if(cards.contains(card)) {
            num = cards.indexOf(card)+1;
        }else {
            num = 0;
        }
        return num;
    }
    
    /**デッキが空かどうかを確認するメソッド*/
    public boolean isEmpty() {
        boolean empty = cards.isEmpty();
        return empty;
    }
    
    /**デッキにあるカードの枚数を返すメソッド*/
    public int size() {
        int size = cards.size();
        return size;
    }
    
    /**デッキのカードの情報をすべて表示するメソッド*/
    public void showAllCards() {
        ArrayList<Integer> suit = new ArrayList<>();
        ArrayList<Integer> number = new ArrayList<>();
        int i;
        Card card;
        for(i=0;i<cards.size();i++) {
            card = cards.get(i);
            suit.add(card.getSuit());
            number.add(card.getNumber());
        }
        
        System.out.println("------------現在の山を表示します．-----------");
        int j;
        String trump;
        for(j=0;j<suit.size();j++) {
            System.out.print(j+1+"番目のカード：");
            trump = Card.getString(suit.get(j),number.get(j));
            System.out.println(trump);
        }
        System.out.println("------------ここまで-----------");
    }
    /**デッキのカード情報を返すメソッド*/
    public List<Card> getAllCards(){
        return cards;
    }
    
    /**
     * デッキを取得する
     * 
     * @return デッキ
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * デッキをセットする
     * 
     * @param cards
     *            デッキ
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
}
