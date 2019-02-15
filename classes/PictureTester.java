/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("images/beach.jpg");
    beach.explore(); // comment these out in repl.it
    beach.zeroBlue();
    beach.explore(); // comment these out in repl.it

    // uncomment this in repl.it to test your code!!
    // beach.write("imagesOutput/beach.jpg");
  }

  public static void testKeepOnlyBlue(){
    Picture bleh = new Picture("images/bleh.jpg");
    bleh.explore();
    bleh.keepOnlyBlue();
    bleh.explore();
  }

  public static void testNegate(){
    Picture bleh = new Picture("images/bleh.jpg");
    bleh.explore();
    bleh.negate();
    bleh.explore();
  }

  public static void testGrayscale(){
    Picture bleh = new Picture("images/bleh.jpg");
    bleh.explore();
    bleh.grayscale();
    bleh.explore();
  }
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  public static void testMirrorVerticalLeftToRight(){
    Picture bleh = new Picture("images/bleh.jpg");
    bleh.explore();
    bleh.mirrorVerticalRightToLeft();
    bleh.explore();
  }

  public static void testMirrorHorizontal(){
    Picture bleh = new Picture("images/bleh.jpg");
    bleh.mirrorHorizontal();
    bleh.explore();
  }

  public static void testMirrorHorizontalBottomToTop(){
    Picture bleh = new Picture("images/bleh.jpg");
    bleh.explore();
    bleh.mirrorHorizontalBottomToTop();
    bleh.explore();
  }
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("images/temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

  public static void testMirrorArms(){
    Picture snowman = new Picture("images/snowman.jpg");
    snowman.explore();
    // (291, 253) (236,160)
    snowman.mirrorArms(160,100,190 ,170);
    snowman.mirrorArms(170,235,195 ,290);
    snowman.explore();
  }

  public static void testMirrorGull(){
    Picture gull = new Picture("images/seagull.jpg");
    gull.explore();
    gull.mirrorGull(233,237,325,345);
    gull.explore();
  }

  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalLeftToRight();
    //testMirrorHorizontal();
    //testMirrorHorizontalBottomToTop();
    //testMirrorTemple();
    //testMirrorArms();
    testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}