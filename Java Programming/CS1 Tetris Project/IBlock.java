/*
Instantiates a Block in the shape of an I, with a unique rotateBlock method compared to the other subclasses of Block
*/
public class IBlock extends Block{

  //Constructor that calls upon Block's constructor, with the parameter 1 to initialize the correct blockType
  public IBlock(){
    super(1);
  }

  /*
  Rotates the Block in this subclass's unique way
  */
  public void rotateBlock(){
    int rotationNumber = super.rotationCount%4;
    if (rotationNumber==0 || rotationNumber==2){
      super.unit1.moveLeft();
      super.unit1.moveLeft();
      super.unit1.moveDown();
      super.unit2.moveLeft();
      super.unit3.moveUp();
      super.unit4.moveRight();
      super.unit4.moveUp();
      super.unit4.moveUp();
    }else{
      super.unit1.moveRight();
      super.unit1.moveRight();
      super.unit1.moveUp();
      super.unit2.moveRight();
      super.unit3.moveDown();
      super.unit4.moveLeft();
      super.unit4.moveDown();
      super.unit4.moveDown();
    }
    super.rotationCount++;
  }
}
