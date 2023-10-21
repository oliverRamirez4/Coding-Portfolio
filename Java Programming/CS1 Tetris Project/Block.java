/**
This abstract class contains all the relevant characteristics and methods of any type of Block.
It is the parent class of all the OBlock, IBlock, SBlock, ZBlock, LBlock, JBlock, and TBlock subclasses
They were made into subclasses because each of them uses a different way of rotating, so the
rotateBlock() method in this class was made abstract, and was implemented differently into each subclass.
*/
public abstract class Block{
  //every Block is made up of four units
  protected Unit unit1;
  protected Unit unit2;
  protected Unit unit3;
  protected Unit unit4;
  //keeps track of which type of block the instance is
  protected int blockType;
  //Counts the number of times this block has rotated
  protected int rotationCount;

  //constructor for a Block object, only called upon through all the Block subclasses
  public Block(int blockType){
    //creates a O block
    if(blockType==0){
      this.unit1 = new Unit(1,5);
      this.unit2 = new Unit(1,6);
      this.unit3 = new Unit(2,5);
      this.unit4 = new Unit(2,6);
    }
    //creates an I block
    if(blockType==1){
      this.unit1 = new Unit(1,6);
      this.unit2 = new Unit(2,6);
      this.unit3 = new Unit(3,6);
      this.unit4 = new Unit(4,6);
    }
    //creates a S block
    if(blockType==2){
      this.unit1 = new Unit(1,6);
      this.unit2 = new Unit(1,5);
      this.unit3 = new Unit(2,5);
      this.unit4 = new Unit(2,4);
    }
    //creates a Z block
    if(blockType==3){
      this.unit1 = new Unit(1,5);
      this.unit2 = new Unit(1,6);
      this.unit3 = new Unit(2,6);
      this.unit4 = new Unit(2,7);
    }
    //creates a L block
    if(blockType==4){
      this.unit1 = new Unit(1,5);
      this.unit2 = new Unit(2,5);
      this.unit3 = new Unit(3,5);
      this.unit4 = new Unit(3,6);
    }
    //creates a J block
    if(blockType==5){
      this.unit1 = new Unit(1,6);
      this.unit2 = new Unit(2,6);
      this.unit3 = new Unit(3,6);
      this.unit4 = new Unit(3,5);
    }
    //creates a T block
    if(blockType==6){
      this.unit1 = new Unit(1,4);
      this.unit2 = new Unit(1,5);
      this.unit3 = new Unit(1,6);
      this.unit4 = new Unit(2,5);
    }
    this.blockType=blockType;
    this.rotationCount=0;
}

  /*
  Abstract method that applies differently to each subclass
  Rotates the block via tracking the rotationCount variable
  */
  public abstract void rotateBlock();

  /*
  Moves all units in the Block downwards
  */
  public void moveDown(){
    this.unit1.moveDown();
    this.unit2.moveDown();
    this.unit3.moveDown();
    this.unit4.moveDown();
  }
  /*
  Moves all units in the Block right
  */
  public void moveRight(){
    this.unit1.moveRight();
    this.unit2.moveRight();
    this.unit3.moveRight();
    this.unit4.moveRight();
  }
  /*
  Moves all units in the Block left
  */
  public void moveLeft(){
    this.unit1.moveLeft();
    this.unit2.moveLeft();
    this.unit3.moveLeft();
    this.unit4.moveLeft();
  }
  /*
  Moves all units in the Block up
  (This is not a player control, it is used when testing if Blocks can move downards)
  */
  public void moveUp(){
    this.unit1.moveUp();
    this.unit2.moveUp();
    this.unit3.moveUp();
    this.unit4.moveUp();
  }

  /*
  Getters for each Unit making up the Block
  */
  public Unit getUnit1(){
    return this.unit1;
  }
  public Unit getUnit2(){
    return this.unit2;
  }
  public Unit getUnit3(){
    return this.unit3;
  }
  public Unit getUnit4(){
    return this.unit4;
  }

  /*
  Setters for each Unit making up the Block
  */
  public void setUnit1(Unit one){
    this.unit1 = one;
  }
  public void setUnit2(Unit two){
    this.unit2 = two;
  }
  public void setUnit3(Unit three){
    this.unit3 = three;
  }
  public void setUnit4(Unit four){
    this.unit4 = four;
  }

  /*
  Getters for getting the Y value of each Unit making up the Block
  */
  public int getUnit1_y(){
    Unit temporary = this.unit1;
    return temporary.getY();
  }
  public int getUnit2_y(){
    Unit temporary = this.unit2;
    return temporary.getY();
  }
  public int getUnit3_y(){
    Unit temporary = this.unit3;
    return temporary.getY();
  }
  public int getUnit4_y(){
    Unit temporary = this.unit4;
    return temporary.getY();
  }

  /*
  Getters for getting the X value of each Unit making up the Block
  */
  public int getUnit1_x(){
    Unit temporary = this.unit1;
    return temporary.getX();
  }
  public int getUnit2_x(){
    Unit temporary = this.unit2;
    return temporary.getX();
  }
  public int getUnit3_x(){
    Unit temporary = this.unit3;
    return temporary.getX();
  }
  public int getUnit4_x(){
    Unit temporary = this.unit4;
    return temporary.getX();
  }

  /*
  Getter for this Block's blockType
  */
  public int getBlockType(){
    return this.blockType;
  }
  /*
  Getter for this Block's rotationCount
  */
  public int getRotationCount(){
    return this.rotationCount;
  }
  /*
  Setter for this Block's blockType
  */
  public void setBlockType(int type){
    this.blockType = type;
  }
  /*
  Setter for this Block's rotationCount
  */
  public void setRotationCount(int count){
    this.rotationCount=count;
  }

  /*
  toString method used for testing purposes
  */
  public String toString(){
    return "unit1" + this.unit1.toString() + " unit2" + this.unit2.toString() + " unit3" + this.unit3.toString() + " unit4" + this.unit4.toString();
  }
}
