/*
Instantiates a Block in the shape of a T, with a unique rotateBlock method compared to the other subclasses of Block
*/
public class TBlock extends Block{

  //Constructor that calls upon Block's constructor, with the parameter 6 to initialize the correct blockType
  public TBlock(){
    super(6);
  }

  /*
  Rotates the Block in this subclass's unique way
  */
  public void rotateBlock(){
    int rotationNumber = super.rotationCount%4;
    if (rotationNumber == 0){
      super.unit1.moveUp();
      super.unit1.moveRight();
      super.unit3.moveDown();
      super.unit3.moveLeft();
      super.unit4.moveLeft();
      super.unit4.moveUp();
    }
    if (rotationNumber == 1){
      super.unit1.moveDown();
      super.unit1.moveRight();
      super.unit3.moveUp();
      super.unit3.moveLeft();
      super.unit4.moveRight();
      super.unit4.moveUp();
    }
    if (rotationNumber == 2){
      super.unit1.moveDown();
      super.unit1.moveLeft();
      super.unit3.moveUp();
      super.unit3.moveRight();
      super.unit4.moveRight();
      super.unit4.moveDown();
    }
    if (rotationNumber == 3){
      super.unit1.moveUp();
      super.unit1.moveLeft();
      super.unit3.moveDown();
      super.unit3.moveRight();
      super.unit4.moveLeft();
      super.unit4.moveDown();
    }
    super.rotationCount++;
  }
}
