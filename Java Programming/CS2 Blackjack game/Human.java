import java.util.ArrayList;
import java.util.Scanner;
public class Human extends player{
    public Human() {
        this.hand= new ArrayList<Card>();
    }
    public boolean hit(){
        if(getScore()>20){ return false;}
        Scanner console=new Scanner(System.in);
        System.out.println("do you want another card? type 1 to draw type 2 to stand");
        int check=console.nextInt();
        return(check==1);
    }
    public String showHand(){
        String show="";
        for (int i=0;i<hand.size();i++){
            Card temp=hand.get(i);
            show+="{"+temp.toAString() +"} ";
        }
        return show;
    }
    public void takeTurn(Deck deck){
        while(hit()) {
            getCard(deck.giveCard());
            System.out.println(showHand());
        }

    }

}

