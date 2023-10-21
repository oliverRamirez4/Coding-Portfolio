/*
Instantiates a Block in the shape of a J, with a unique rotateBlock method compared to the other subclasses of Block
*/
public class JBlock extends Block{

  //Constructor that calls upon Block's constructor, with the parameter 5 to initialize the correct blockType
  public JBlock(){
    super(5);
  }

  /*
  Rotates the Block in this subclass's unique way
  */
  public void rotateBlock(){
    int rotationNumber = super.rotationCount%4;
    if (rotationNumber == 0){
      super.unit1.moveLeft();
      super.unit1.moveDown();
      super.unit3.moveRight();
      super.unit3.moveUp();
      super.unit4.moveRight();
      super.unit4.moveRight();
    }
    if (rotationNumber == 1){
      super.unit1.moveDown();
      super.unit1.moveRight();
      super.unit3.moveUp();
      super.unit3.moveLeft();
      super.unit4.moveUp();
      super.unit4.moveUp();
    }
    if (rotationNumber == 2){
      super.unit1.moveUp();
      super.unit1.moveRight();
      super.unit3.moveDown();
      super.unit3.moveLeft();
      super.unit4.moveLeft();
      super.unit4.moveLeft();
    }
    if (rotationNumber == 3){
      super.unit1.moveUp();
      super.unit1.moveLeft();
      super.unit3.moveDown();
      super.unit3.moveRight();
      super.unit4.moveDown();
      super.unit4.moveDown();
    }
    super.rotationCount++;
  }
}
