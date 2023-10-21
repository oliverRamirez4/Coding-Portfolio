/**
The purpose of the Game class is to contain all the methods that instantiate new Blocks and
essentially continues to run the current game via all of its checker methods that check
multiple important statuses relevant to the game.
*/

import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Game {
  //Defines the Board, Block, and Score that the Game is working with
  Board board;
  Block current_block;
  Score score;
  boolean game_over; //sets a boolean flag to signal if the game is over or not

  /*
  Constructor for Game, takes a given Board and Score as parameters
  */
  public Game(Board board, Score score){
    this.score = score;
    this.game_over = false; //sets game_over to false by default
    this.board = board;
    //Takes the Board, populates it, translates it, and populates the JFrame based off of that
    this.board.populateBoard();
    this.board.translateToScreen();
    this.board.populateScreen();
    //Instantiates a new starting Block and places it on the board
    int blockNum = (int)(Math.random() * 7);
    //Depending on which random int we get, it has a corresponding unique Block subclass for the
    //7 different tetrominoes that are used in Tetris
    if (blockNum == 0){
      this.current_block = new OBlock();
    } else if (blockNum == 1){
      this.current_block = new IBlock();
    } else if (blockNum == 2){
      this.current_block = new SBlock();
    } else if (blockNum == 3){
      this.current_block = new ZBlock();
    } else if (blockNum == 4){
      this.current_block = new LBlock();
    } else if (blockNum == 5){
      this.current_block = new JBlock();
    } else if (blockNum == 6){
      this.current_block = new TBlock();
    }
    //Places the first block onto the screen
    this.board.translateBlockToGrid(current_block);
    this.board.translateToScreen();
  }

  //Returns whatever the current Block being controlled is
  public Block getCurrentBlock(){
    return current_block;
  }
  //Returns whatever the status of the game_over boolean is
  public boolean getGameOver(){
    return game_over;
  }

  /*
  Creates a new Block instance using the same approach as before, and assigns the newly made Block to
  be the current_block attribute in this instance of Game
  */
  public void newBlock(){
    int blockNum = (int)(Math.random() * 7);
    if (blockNum == 0){
      this.current_block = new OBlock();
    } else if (blockNum == 1){
      this.current_block = new IBlock();
    } else if (blockNum == 2){
      this.current_block = new SBlock();
    } else if (blockNum == 3){
      this.current_block = new ZBlock();
    } else if (blockNum == 4){
      this.current_block = new LBlock();
    } else if (blockNum == 5){
      this.current_block = new JBlock();
    } else if (blockNum == 6){
      this.current_block = new TBlock();
    }
    //displays the new current_block onto the screen
    this.board.translateBlockToGrid(current_block);
    this.board.translateToScreen();
  }

/*
This boolean checks if a block can move down on the tetris 2d array board
*/
  public boolean ifCanMoveDown(){

    //a block has to be removed from the grid before it can be checked if it can move down
    board.removeBlockFromGrid(current_block);

    //after removing the block use the can move down method from the block class to check
    if(board.canMoveDown(current_block)){
      //move the block back in the opposite direction so it stays in its original position
      board.translateBlockToGrid(current_block);
      return true;
    }else{
      board.translateBlockToGrid(current_block);
      return false;
    }
  }
  /*
  This boolean checks if a block can move right on the tetris 2d array board.
  Works in the same way as the ifCanMoveDown() method
  */
  public boolean ifCanMoveRight(){
    board.removeBlockFromGrid(current_block);
    boolean checker = board.canMoveRight(current_block);
    if(checker == true){
      board.translateBlockToGrid(current_block);
      return true;
    }else{
      board.translateBlockToGrid(current_block);
      return false;
    }
  }
  /*
  This boolean checks if a block can move left on the tetris 2d array board.
  Works in the same way as the ifCanMoveDown() method
  */
  public boolean ifCanMoveLeft(){
    board.removeBlockFromGrid(current_block);
    boolean checker = board.canMoveLeft(current_block);
    if(checker == true){
      board.translateBlockToGrid(current_block);
      return true;
    }else{
      board.translateBlockToGrid(current_block);
      return false;
    }
  }
  /*
  This boolean checks if a block can rotate on the tetris 2d array board.
  Works in the same way as the ifCanMoveDown() method
  */
  public boolean ifCanRotate(){
    board.removeBlockFromGrid(current_block);
    boolean checker = board.canRotate(current_block);
    if(checker == true){
      board.translateBlockToGrid(current_block);
      return true;
    }else{
      board.translateBlockToGrid(current_block);
      return false;
    }
  }

  /*
  A method that does the cleanUp step once the current_block has been placed on the field
  */
  public void cleanUp(){
    //Adds 1 to the player's current score
    score.setCurrentScore(1);
    //checks if the top line of the playing field is clear
    if (board.ifTopLineClear()){
      //if clear, then scans to see if any rows are filled
      int rows_full = 0;
      for (int i=1; i<21;i++){
        if (board.CheckIfLineIsFull(i)){
          //if a row is full, add one to the counter of how many rows are full and adjust the grid to reflect those changes
          rows_full ++;
          board.clearLineFixGrid(i);
        }
      }
      //Add to the player's score if they filled any rows
      score.setCurrentScore(rows_full * 100);
    }
    //if the top row has any blocks filled, set game_over to be true
    else{
      game_over = true;
    }
  }
}
