/*
Instantiates a Block in the shape of an O, with a unique rotateBlock method compared to the other subclasses of Block
*/
public class OBlock extends Block{

  //Constructor that calls upon Block's constructor, with the parameter 0 to initialize the correct blockType
  public OBlock(){
    super(0);
  }

  /*
  Rotates the Block in this subclass's unique way
  */
  public void rotateBlock(){
    //Rotating an OBlock would not do anything since it is the same in any orientation
  }
}
