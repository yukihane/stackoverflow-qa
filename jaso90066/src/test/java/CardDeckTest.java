import junit.framework.TestCase;

/**カードデッキクラスのテストクラス*/
public class CardDeckTest extends TestCase {
    // すべてのテストメソッドで用いるデッキのインスタンス
    private CardDeck deck,deck1,deck2,deckJ,deck4,deckEmpty;
    // すべてのテストメソッドで用いるカードのインスタンス
    private Card spadeA, diamond10, heartQ, clubK,joker;

    /**
     * 各テストメソッドの実行の前処理
     */
    protected void setUp() throws Exception {
        // いくつかテスト用のカードインスタンスを作っておく．
        spadeA = new Card(0, 1); 
        diamond10 = new Card(1, 10); 
        heartQ = new Card(2, 12); 
        clubK = new Card(3, 13);
        joker = new Card(-1,0);
        
        // いくつかテスト用のデッキインスタンスを作っておく．
        deckEmpty = new CardDeck();
        deck = new CardDeck();
        deck1 = new CardDeck();
        deck2 = new CardDeck();
        deckJ = new CardDeck();
        deck4 = new CardDeck();
        
        deck1.addCard(spadeA);
        deck1.addCard(diamond10);
        deck1.addCard(heartQ);
        deck1.addCard(clubK);
        
        deck2.addCard(spadeA);
        deck2.addCard(diamond10);
        deck2.addCard(clubK);
        
        deckJ.addCard(joker);
        
        deck4.addCard(spadeA);
        deck4.addCard(diamond10);
        deck4.addCard(heartQ);
        deck4.addCard(clubK);
        
        for(int i=0;i<4;i++) {
            for(int j=1;j<14;j++) {
                Card card = new Card(i,j);
                deck.addCard(card);
            }
        }
        
    }

    protected void tearDown() throws Exception {
        
    }
    
    public void testCreateFullDeck() {
        deckEmpty.createFullDeck();
        assertEquals(deck,deckEmpty);
    }
    
    public void testAddJoker() {
        deckEmpty.addJoker();
        assertEquals(deckJ,deckEmpty);
    }
    
    public void testClear() {
        deck1.clear();
        assertTrue(deckEmpty.equals(deck1));
    }

    public void testShuffle() {
        deck4.shuffle();
        assertNotSame(deck1, deck4);
    }

    public void testAddCardCard() {
        deckEmpty.addCard(joker);
        assertTrue(deckJ.equals(deckEmpty));
    }

    public void testAddCardIntCard() {
        deck2.addCard(3,heartQ);
        assertEquals(deck1,deck2);
    }

    public void testTakeCard() {
        assertEquals(deckEmpty,deckJ.takeCard());
    }

    public void testTakeCardInt() {
        assertEquals(deck2,deck1.takeCard(3));
    }

    public void testSeeCard() {
        assertEquals(joker,deckJ.seeCard(1));
        assertEquals(diamond10,deck1.seeCard(2));
    }

    public void testSerchCard() {
        assertEquals(1,deck1.serchCard(0, 1));
        
    }

    public void testIsEmpty() {
        assertEquals(true,deckEmpty.isEmpty());
        assertEquals(false,deck1.isEmpty());
    }

    public void testSize() {
        assertEquals(4,deck1.size());
    }

}

