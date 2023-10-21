/*
Instantiates a Block in the shape of a Z, with a unique rotateBlock method compared to the other subclasses of Block
*/
public class ZBlock extends Block{

  //Constructor that calls upon Block's constructor, with the parameter 3 to initialize the correct blockType
  public ZBlock(){
    super(3);
  }

  /*
  Rotates the Block in this subclass's unique way
  */
  public void rotateBlock(){
    int rotationNumber = super.rotationCount%4;
    if (rotationNumber==0 || rotationNumber == 2){
      super.unit1.moveRight();
      super.unit2.moveDown();
      super.unit3.moveLeft();
      super.unit4.moveDown();
      super.unit4.moveLeft();
      super.unit4.moveLeft();
    }else{
      super.unit1.moveLeft();
      super.unit2.moveUp();
      super.unit3.moveRight();
      super.unit4.moveUp();
      super.unit4.moveRight();
      super.unit4.moveRight();
    }
    super.rotationCount++;
  }
}
