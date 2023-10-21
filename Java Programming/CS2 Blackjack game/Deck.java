import java.util.ArrayList;
import java.lang.Math;
public class Deck {
    public static ArrayList<Card> deckShell;

    public static ArrayList<Card> discardPile;
    public Deck() {
        deckShell=new ArrayList<Card>();
        discardPile=new ArrayList<Card>();


        generateDeck();
        shuffle();
    }
    public static void generateDeck(){
        String[] ranks={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
        String[] suits={"hearts", "spades","clubs", "diamonds"};
        int[] values={11,2,3,4,5,6,7,8,9,10,10,10,10};
        for (int i=0;i<13;i++) {
            for (int j = 0; j < 4; j++) {
                Card current = new Card(suits[j], ranks[i], values[i]);
                deckShell.add(current);
            }
        }
    }
    public static void shuffle(){
        ArrayList<Card> temp=new ArrayList<Card>();
        for(int i=0;i<52;i++){
            int idx=(int)(Math.random()*deckShell.size());
            Card current=deckShell.remove(idx);
            temp.add(current);
        }
        deckShell=temp;
    }
    public Card giveCard(){
        Card temp=deckShell.remove(0);
        discardPile.add(temp);
        return temp;

    }
    public static String toAString(){
        String base="{";
        for(int i=0;i<52;i++){
            Card current=deckShell.get(i);
            String add= current.toAString();
            base+=(add+", ");
        }
        base+="}";
        return base;
    }
}
