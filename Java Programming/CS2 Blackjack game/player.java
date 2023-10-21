import java.util.ArrayList;
public abstract class player {
    public ArrayList<Card> hand;
    public void clearHand(){
        while(hand.size()!=0) {
            hand.remove(0);
        }
    }
    public int getScore(){
        int score=0;
        Card current;
        for (int i=0;i<hand.size();i++){
            current=hand.get(i);
            score+=current.getValue();
        }
        if(score>21){
            for (int i=0;i<hand.size();i++){
                Card temp=hand.get(i);
                if (temp.checkIfAce()){
                    temp.setValue(1);
                    hand.set(i,temp);
                    score-=10;
                }
                if ((getHandSize()>=5)&&(score<=21)){
                    score=21;
                }
            }
        }
        return score;
    }
    public boolean hit(){
        return false;
    }
    public void getCard(Card newCard){
        hand.add(newCard);
    }
    public String showHand(){
        return "";
    }
    public String showFinalHand(){
        String show="";
        for (int i=0;i<hand.size();i++){
            Card temp=hand.get(i);
            show+="{"+temp.toAString() +"} ";
        }
        return show;
    }
    public int getHandSize(){
        return hand.size();
    }
    public boolean checkBlackJackWin(){
        Card firstCard=hand.get(0);
        Card secondCard=hand.get(1);
        return ((firstCard.checkIfAce()&& secondCard.checkBlackJack())||(secondCard.checkIfAce()&& firstCard.checkBlackJack()));
    }
    public void takeTurn(Deck deck){
    }
}
