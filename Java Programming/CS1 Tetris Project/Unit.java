/*
The Unit class contains information relevant to each Unit that makes up the
Board, as well as when applied inside of Blocks
*/
public class Unit{
  //Variables to track the Unit's x and y positions
  int yTracker;
  int xTracker;

//Constructor of a Unit object. Every Unit has a y and x coordinate
  public Unit(int y, int x){
    this.yTracker = y;
    this.xTracker = x;
  }

  //Getters and setters for the x and y coordinate of a Unit
  public void setY (int y){
    this.yTracker = y;
  }
  public void setX (int x){
    this.xTracker = x;
  }
  public int getX(){
    return this.xTracker;
  }
  public int getY(){
    return this.yTracker;
  }

  //Move the location of a Unit right, down, left, or up
  public void moveDown(){
    this.yTracker ++;
  }
  public void moveRight(){
    this.xTracker ++;
  }
  public void moveLeft(){
    this.xTracker --;
  }
  public void moveUp(){
    this.yTracker --;
  }

//To string method for a Unit
  public String toString(){
    return "[" + getY() + "][" + getX() + "]";
  }
}
