/**
This class contains all the information and functions that are relevant to the player's score
*/
import java.util.*;
import java.io.*;

public class Score{
  //highscore and currennt score stored
  int currentScore;
  int highScore;

  //constructor
  public Score(int highScore){
    currentScore=0;
    this.highScore= highScore;
  }
  //setter high score
  public void setHighScore(int highScore){
    this.highScore=highScore;
  }
  //seter current score
  public void setCurrentScore(int x){
    this.currentScore=currentScore+x;
  }
  //getter current score
  public int getCurrentScore(){
    return this.currentScore;
  }
  //getter high score
  public int getHighScore(){
    return this.highScore;
  }
  //rewrite highscore into file (called if currentscore greater)
  public void newHighScore()throws FileNotFoundException{
    PrintStream print = new PrintStream("Scores.txt");
    print.println(currentScore);
  }

}
