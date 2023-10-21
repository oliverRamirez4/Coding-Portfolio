import java.util.ArrayList;
public class Dealer extends player{
    public Dealer() {
        this.hand= new ArrayList<Card>();
    }
    @Override
    public boolean hit() {
        return (getScore()<16);
    }
    public String showHand(){
        String show="{hidden} ";
        for (int i=1;i<hand.size();i++){
            Card temp=hand.get(i);
            show+=("{"+temp.toAString() +"} ");
        }
        return show;
    }
    public void takeTurn(Deck deck){
        if (hit()){
            getCard(deck.giveCard());
        }
    }
}
