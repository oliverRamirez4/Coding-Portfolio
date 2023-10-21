public class Card {
    private String rank;
    private String suit;
    private int value;
    public Card( String suit, String rank, int value){
        this.suit = suit;
        this.rank = rank;
        this.value=value;
    }
    public String getSuit() {
        return suit;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String toAString(){
        return this.rank +" of " +this.suit;
    }
    public boolean checkIfAce(){
        return(rank.equals("Ace")&&(value==11));
    }
    public boolean checkBlackJack(){
        return(rank.equals("Jack")&&(suit.equals("spades")||suit.equals("clubs")));
    }
}
