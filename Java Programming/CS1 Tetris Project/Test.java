/**
Program written by Yael Homa, Oliver Ramirez, & PJ Langas
CP122 Computer Science 1
This class contains the main method that runs a clone of Tetris.
*/
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.io.*;
import java.io.FileNotFoundException;

public class Test{

  //declares some static variables relevant to the Timer threads that will be implemented further down
  static int interval = 10;
  static Timer timer;
  static int delay = 300;
  static int period = 300;

  /*
  Main method that executes the startup of a new game
  */
  public static void main(String[] args) throws FileNotFoundException{

    //creates a JFrame where everything will be displayed
    JFrame screen = new JFrame();
    screen.setVisible(true);
    //creates a new game Board using the screen that was just made
    Board board = new Board(screen);
    //creates and adds JLabels that will display the player's score & high score to the JFrame
    JLabel curScore = new JLabel("Current Score:");
    curScore.setBounds(0, 560, 400, 50);
    screen.add(curScore);
    JLabel hiScore = new JLabel ("High score:");
    hiScore.setBounds(0, 585, 400, 50);
    screen.add(hiScore);
    //Scans the .txt file that contains the previous high score, and stores it
    Scanner input = new Scanner(new File("Scores.txt"));
    int high_score = 0;
    while (input.hasNext()){
      if (input.hasNextInt()){
        high_score = input.nextInt();
      }
    }
    //initializes a new Score instance with the given high score
    Score score = new Score(high_score);
    //creates a new Game instance with the now fully defined Board and Score
    Game game = new Game(board, score);

      /*
      Adds a listener to the JFrame that listens for certain input at any given time during the running of the game
      */
      screen.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e){
          int keyCode = e.getKeyCode();
          //if the up arrow is pressed, rotates current block
          if (keyCode == KeyEvent.VK_UP){
            if(game.ifCanRotate() && !game.getGameOver()){
              board.removeBlockFromGrid(game.getCurrentBlock());
              game.getCurrentBlock().rotateBlock();
              board.translateBlockToGrid(game.getCurrentBlock());
              board.translateToScreen();
            }
          }
          //if the left arrow is pressed, move the current block left
          else if (keyCode == KeyEvent.VK_LEFT) {
            if(game.ifCanMoveLeft() && !game.getGameOver()){
              board.removeBlockFromGrid(game.getCurrentBlock());
              game.getCurrentBlock().moveLeft();
              board.translateBlockToGrid(game.getCurrentBlock());
              board.translateToScreen();
            }
          }
          //if the right arrow is pressed, move the current block right
          else if (keyCode == KeyEvent.VK_RIGHT) {
            if(game.ifCanMoveRight() && !game.getGameOver()){
              board.removeBlockFromGrid(game.getCurrentBlock());
              game.getCurrentBlock().moveRight();
              board.translateBlockToGrid(game.getCurrentBlock());
              board.translateToScreen();
            }
          }
          //if the down arrow is pressed, move the block downwards faster
          else if (keyCode == KeyEvent.VK_DOWN) {
            if(game.ifCanMoveDown() && !game.getGameOver()){
              board.removeBlockFromGrid(game.getCurrentBlock());
              game.getCurrentBlock().moveDown();
              board.translateBlockToGrid(game.getCurrentBlock());
              board.translateToScreen();
            }
          }
        }
      });

      //creates a new instance of Timer
      timer = new Timer();

      /*
      Initializes a Thread that runs automatically using Timer, regardless of player input
      */
    timer.scheduleAtFixedRate(new TimerTask() {
        public void run() {
            if (setInterval()){
              //as long as the current block can move downwards, move it down one place depending on the interval of the Timer
              if (game.ifCanMoveDown()) {
                board.removeBlockFromGrid(game.getCurrentBlock());
                game.getCurrentBlock().moveDown();
                board.translateBlockToGrid(game.getCurrentBlock());
                board.translateToScreen();
              }
              //if it cannot move down, run a cleanUp method that moves onto the next step of the game
              else {
                game.cleanUp();
                //if the game over condition is NOT met, then update display for the player's score and instantiate a new Block to control
                if (game.getGameOver() == false){
                  hiScore.setText("High Score: " + score.getHighScore());
                  curScore.setText("Current Score: " + score.getCurrentScore());
                  game.newBlock();
                //if the game over condition IS met, stop the Timer, and display the player's score vs. the high score
                } else {
                  timer.cancel();
                  curScore.setText("Game Over! Score: " + score.getCurrentScore());
                  //if the player beat the high score, then overwrite the old high score in the .txt file
                  if (score.getCurrentScore() > score.getHighScore()){
                    hiScore.setText("New High Score: " + score.getCurrentScore());
                    try {
                      score.newHighScore();
                    }
                    catch(FileNotFoundException e){
                    }
                  }
                }
              }
            }
        }
    }, delay, period);
  }

//Setting the boolean that will initate timer
  private static final boolean setInterval() {
    //if the timer is at index, (at the bottom of the screen) it ends, and new block is initiated
    if (interval == 1){
      timer.cancel();
      return false;
    }
    //timer is true, timer runs
    else {
      return true;
    }
  }

}
