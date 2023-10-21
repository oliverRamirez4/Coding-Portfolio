/*
The purpose of the Board class is to define all of actions of the Tetris game onto the tetris Board
and move those actions into the JFrame full of JButtons which are each block of the Tetris grid
*/

import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

public class Board extends JFrame{
  //the 2D board array is where we track all the actions made to the Tetris board
  int[][] board = new int[22][12];
  //the 2d squares array is used to translate the board array onto the JFrame with JButtons
  JButton[][] squares = new JButton[22][12];
  //the JFrame that holds the game
  JFrame screen;

/*
Constructor for a board object
@param a JFrame to do actions to the JFrame
*/
public Board(JFrame screen){
  this.screen = screen;
  this.screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.board = new int[22][12];
  //fill the squares array with the buttons, White buttons as empty spaces and black buttons as the borders
  populateScreen();
  //fill the board array with 1s as empty spaces and 0s as borders
  populateBoard();

  //set size layout and visibility of the screen
  this.screen.setSize(300,675);
  this.screen.setLayout(null);
  this.screen.setVisible(true);
}

/*
This method translates a block onto the board array by finding the coordinates of each
unit and placing a 2 in that position on the array
*/
  public void translateBlockToGrid(Block spot){
    this.board[spot.getUnit1_y()][spot.getUnit1_x()] = 2;
    this.board[spot.getUnit2_y()][spot.getUnit2_x()] = 2;
    this.board[spot.getUnit3_y()][spot.getUnit3_x()] = 2;
    this.board[spot.getUnit4_y()][spot.getUnit4_x()] = 2;
  }
  /*
This method takes a block off the board array by finding the coordinates of each
unit and placing a 1 in that position on the array
  */
  public void removeBlockFromGrid(Block spot){
    this.board[spot.getUnit1_y()][spot.getUnit1_x()] = 1;
    this.board[spot.getUnit2_y()][spot.getUnit2_x()] = 1;
    this.board[spot.getUnit3_y()][spot.getUnit3_x()] = 1;
    this.board[spot.getUnit4_y()][spot.getUnit4_x()] = 1;
  }
  /*
This method fills the board with 0s as the borders and 1s as the empty spaces inside the borders
  */
  public void populateBoard(){
    for (int i=0;i<board.length; i++){
      this.board[i][0]=0;
      this.board[i][board[i].length-1]=0;
    }
    for (int i=0;i<board[0].length; i++){
      this.board[0][i]=0;
      this.board[board.length-1][i]=0;
    }
    for (int i=1;i<board.length-1;i++){
      for (int j=1;j<board[i].length-1;j++){
        this.board[i][j]=1;
      }
    }
  }
  /*
This method takes the 2D array of JButtons and puts them on the JFrame in the
corresponding positon
  */
  public void populateScreen(){
    //fill the inside area of the borders with white Jbuttons
    for (int i=1;i<squares.length-1; i++){
      for (int j=1;j<squares[0].length-1; j++){
      JButton bob = new JButton();
      bob.setBounds(j*25,25*i,25,25);
      bob.setBackground(Color.WHITE);
      bob.setOpaque(true);
      bob.setBorderPainted(true);
      bob.setEnabled(false);
      squares[i][j]=bob;
      screen.add(squares[i][j]);

    }
  }
  //fill the left wall border with black Jbuttons
  for (int i=0;i<squares.length; i++){
    JButton bob = new JButton();
    bob.setBounds(0,25*i,25,25);
    bob.setBackground(Color.BLACK);
    bob.setOpaque(true);
    bob.setBorderPainted(false);
    squares[i][0]=bob;
    screen.add(squares[i][0]);
  }
  //fill the right wall border with black JButtons
  for (int i=0;i<squares.length; i++){
    JButton bob = new JButton();
    bob.setBounds(275,25*i,25,25);
    bob.setBackground(Color.BLACK);
    bob.setOpaque(true);
    bob.setBorderPainted(false);
    squares[i][squares[0].length-1]=bob;
    screen.add(squares[i][squares[0].length-1]);
  }
  //fill the top wall border with black JButtons
  for (int i=1;i<squares[0].length-1;i++){
    JButton bob = new JButton();
    bob.setBounds(25*i,0,25,25);
    bob.setBackground(Color.BLACK);
    bob.setOpaque(true);
    bob.setBorderPainted(false);
    squares[0][i]=bob;
    screen.add(squares[0][i]);
  }
  //fill the bottom border wall with black JButtons
  for (int i=1;i<squares[0].length-1;i++){
    JButton bob = new JButton();
    bob.setBounds(25*i,525,25,25);
    bob.setBackground(Color.BLACK);
    bob.setOpaque(true);
    bob.setBorderPainted(false);
    squares[squares.length-1][i]=bob;
    screen.add(squares[squares.length-1][i]);
  }
}
/*
this method scans through the board array and changes the color of each JButton
depending on the number
*/
  public void translateToScreen(){
    for (int i=0;i<board.length;i++) {
      for (int j=0;j<board[i].length;j++) {
        if (board[i][j]== 0){
          squares[i][j].setBackground(Color.BLACK);
          squares[i][j].setOpaque(true);
        }
        if (board[i][j]== 1){
          squares[i][j].setBackground(Color.WHITE);
          squares[i][j].setOpaque(true);
        }
        if (board[i][j]== 2){
          squares[i][j].setBackground(Color.RED);
          squares[i][j].setOpaque(true);
        }
      }
    }
  }
  /*
  This method checks if a block can move down by seeing if all the spots on the board
  when it is moved down are open spaces.
  */
  public boolean canMoveDown(Block spot){
    //move the block down
    spot.moveDown();
    //check if the unit below is an empty space
    if (board[spot.getUnit1_y()][spot.getUnit1_x()] != 1){
      //move it back up before returning a boolean
      spot.moveUp();
      return false;
    }
    if (board[spot.getUnit2_y()][spot.getUnit2_x()] != 1){
      spot.moveUp();
      return false;
    }
    if (board[spot.getUnit3_y()][spot.getUnit3_x()] != 1){
      spot.moveUp();
      return false;
    }
    if (board[spot.getUnit4_y()][spot.getUnit4_x()] != 1){
      spot.moveUp();
      return false;
    }
    spot.moveUp();
    return true;
  }
  /*
  This method checks if a block can move left by seeing if all the spots on the board
  when it is moved left are open spaces.
  It has the same logic as the canMoveDown method
  */
  public boolean canMoveLeft(Block spot){
    spot.moveLeft();
    if (board[spot.getUnit1_y()][spot.getUnit1_x()] != 1){
      spot.moveRight();
      return false;
    }
    if (board[spot.getUnit2_y()][spot.getUnit2_x()] != 1){
      spot.moveRight();
      return false;
    }
    if (board[spot.getUnit3_y()][spot.getUnit3_x()] != 1){
      spot.moveRight();
      return false;
    }
    if (board[spot.getUnit4_y()][spot.getUnit4_x()] != 1){
      spot.moveRight();
      return false;
    }
    spot.moveRight();
    return true;
  }
  /*
  This method checks if a block can move right by seeing if all the spots on the board
  when it is moved right are open spaces.
  It has the same logic as the canMoveDown method
  */
  public boolean canMoveRight(Block spot){
    spot.moveRight();
    if (board[spot.getUnit1_y()][spot.getUnit1_x()] != 1){
      spot.moveLeft();
      return false;
    }
    if (board[spot.getUnit2_y()][spot.getUnit2_x()] != 1){
      spot.moveLeft();
      return false;
    }
    if (board[spot.getUnit3_y()][spot.getUnit3_x()] != 1){
      spot.moveLeft();
      return false;
    }
    if (board[spot.getUnit4_y()][spot.getUnit4_x()] != 1){
      spot.moveLeft();
      return false;
    }
    spot.moveLeft();
    return true;
  }
  /*
  This method checks if a block can rotate by seeing if all the spots on the board
  when it is rotated are open spaces.
  It has the same logic as the canMoveDown method
  */
  public boolean canRotate(Block spot){
    spot.rotateBlock();
    if (board[spot.getUnit1_y()][spot.getUnit1_x()] != 1){
      spot.rotateBlock();
      spot.rotateBlock();
      spot.rotateBlock();
      return false;
    }
    if (board[spot.getUnit2_y()][spot.getUnit2_x()] != 1){
      spot.rotateBlock();
      spot.rotateBlock();
      spot.rotateBlock();
      return false;
    }
    if (board[spot.getUnit3_y()][spot.getUnit3_x()] != 1){
      spot.rotateBlock();
      spot.rotateBlock();
      spot.rotateBlock();
      return false;
    }
    if (board[spot.getUnit4_y()][spot.getUnit4_x()] != 1){
      spot.rotateBlock();
      spot.rotateBlock();
      spot.rotateBlock();
      return false;
    }
    spot.rotateBlock();
    spot.rotateBlock();
    spot.rotateBlock();
    return true;
  }

/*
This method checks if the top line of the board is full of empty spaces
*/
  public boolean ifTopLineClear(){
    int checker = 1;
    for (int i=1;i<board[0].length-1;i++){
      checker = board[1][i];
      if (checker != 1){
        return false;
      }
    }
    return true;
  }
  /*
  This method checks if the line(int y) is full of blocks
  */
  public boolean CheckIfLineIsFull(int y){
    int checker = 2;
    for(int i=1;i<board[0].length-1;i++){
      checker = board[y][i];
      if (checker != 2){
        return false;
      }
    }
    return true;
  }
  /*
This method takes the line(int y) and moves all the blocks above it down 1 except for the top border.
Then it makes a new row of empty spaces at the top
  */
  public void clearLineFixGrid(int y){
    for( int j=y;j>0;j--){
      for (int i=1;i<board[0].length-1;i++){
        board[j][i]=board[j-1][i];
      }
    }
    for (int i=1;i<board[0].length-1;i++){
         board[1][i]= 1;
    }

  }
}
