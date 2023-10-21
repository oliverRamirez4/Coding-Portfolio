import java.util.ArrayList;
import java.util.Scanner;
public class BlackJack {
    static ArrayList<player> table;
     static Deck deck;
    public static void main(String args[]){
        generateTable();
        deal();
        takeTurns();
        showFinalHands();
        getWinner();
    }
    public BlackJack() {
        this.table = new ArrayList<player>();
        this.deck=new Deck();
        getWinner();
    }
    public static void generateTable(){
            table=new ArrayList<player>();
            Scanner console=new Scanner(System.in);
            System.out.println("How many players are there? Type an int.");
            int playerCount=console.nextInt();
            player dealer=new Dealer();
            for (int i=0;i<playerCount;i++) {
                Human plyr = new Human();
                table.add(plyr);
            }
        table.add(dealer);
            System.out.println("thank you. there are " + playerCount + " players.");
    }
    public static void deal(){
        deck=new Deck();
        for(int i =0;i<table.size();i++){
            player temp=table.get(i);
            temp.getCard(deck.giveCard());
            temp.getCard(deck.giveCard());
            table.set(i,temp);
            if(i==(table.size()-1)){
                System.out.println("Dealer's hand: " + temp.showHand());
            }else{
                System.out.println("Player " + (i+1) + "'s hand: " + temp.showHand());
            }
        }
    }
    public static void takeTurns(){
        System.out.println("Player 1's turn");
        for(int i=0;i<table.size();i++){
            player current=table.get(i);
            current.takeTurn(deck);
            table.set(i,current);

            if(i<table.size()-1){
                System.out.println("turn over.");
            }
            if(i<table.size()-2){
                System.out.println("Player " + (i+2) + "'s turn");
            }

        }
    }
    public static void showFinalHands(){
        System.out.println("Final Hands:");
        for (int i=0;i<table.size();i++) {
            player current = table.get(i);
            if (i == (table.size() - 1)) {
                System.out.print("Dealer:" + current.showFinalHand());
            } else {
                System.out.print("Player " + (i+1) + ":" + current.showFinalHand());
            }
            System.out.println();
        }
    }
    public static void getWinner(){
        int winner=0;
        int winningScore=0;
        ArrayList<Integer> winnerList=new ArrayList<Integer>();
        for (int i=0;i<table.size();i++){
            player current =table.get(i);
            int score = current.getScore();
            if ((score<=21)&&(score>winningScore)){
                winningScore=score;
            }
        }

        for (int i=0;i<table.size();i++){
            player current =table.get(i);
            if (current.getScore()==winningScore){
                winnerList.add(i+1);
            }
        }
              System.out.println("Winners:");
        if(winnerList.size()==0){
            System.out.println("no winners");
        }else {

            for (int i = 0; i < winnerList.size(); i++) {
                if (i == (table.size() - 1)) {
                    System.out.println("Dealer");
                } else {
                    System.out.println("Player " + winnerList.get(i));
                }

            }
        }

    }

}
