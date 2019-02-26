//package com.gradescope.pixlab;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  public void keepOnlyBlue(){
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] rowArray: pixels){
      for(Pixel pix:rowArray){
        pix.setGreen(0);
        pix.setRed(0);
      }
    }
  }

  public void negate(){
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] rowArray:pixels){
      for(Pixel pix: rowArray){
        pix.setGreen(255-pix.getGreen());
        pix.setRed(255-pix.getRed());
        pix.setBlue(255-pix.getBlue());
      }
    }
  }

  public void grayscale(){
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] rowArray: pixels){
      for(Pixel pix:rowArray){
        int average = (pix.getRed() + pix.getBlue() + pix.getGreen())/3;
        pix.setBlue(average);
        pix.setRed(average);
        pix.setGreen(average);
      }
    }
  }
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  public void mirrorVerticalRightToLeft() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  public void mirrorHorizontal(){
    Pixel[][] picture = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    for(int r = 0; r < picture.length; r++){
      for(int c = 0; c < picture[r].length; c++){
        topPixel = picture[r][c];
        bottomPixel = picture[picture.length-1-r][c];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }

  public void mirrorHorizontalBotToTop() {
    Pixel[][] picture = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    for (int r = 0; r < picture.length; r++) {
      for (int c = 0; c < picture[r].length; c++) {
        topPixel = picture[r][c];
        bottomPixel = picture[picture.length - 1 - r][c];
        topPixel.setColor(bottomPixel.getColor());
      }
    }
  }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }

  //Challenge problems
  public void mirrorDiagonal(){

  }
  public void fixUnderwater(){

  }

  public void mirrorArms(int startRow, int startColumn, int mirrorRow, int endColumn)
  {
    int mirrorPoint = mirrorRow;
    Pixel topPixel = null;
    Pixel botPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    System.out.println("In mirror arms method");
    System.out.println("startRows: " + startRow + ", mirrorPoint: " + mirrorPoint);
    // loop through the rows
    for (int row = startRow; row < mirrorPoint; row++) {
      System.out.println("In row!");
      for (int col = startColumn; col < endColumn; col++) {
        System.out.println("row: " + row + ", column: " + col);
        topPixel = pixels[row][col];
        botPixel = pixels[mirrorPoint*2 - row][col];
        botPixel.setColor(topPixel.getColor());
      }
    }
    System.out.println("end of mirror arms method");
  }
  public void mirrorArms()
  {
    int startRow = 160;
    int startColumn = 100;
    int mirrorRow = 190;
    int endColumn = 170;
    int mirrorPoint = mirrorRow;
    Pixel topPixel = null;
    Pixel botPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    System.out.println("In mirror arms method");
    System.out.println("startRows: " + startRow + ", mirrorPoint: " + mirrorPoint);
    // loop through the rows
    banana(pixels,topPixel,botPixel,startRow,startColumn,mirrorRow,endColumn);
    banana(pixels,topPixel,botPixel,170,235,195 ,290);
  }
  public void banana(Pixel[][] pixels, Pixel topPixel, Pixel botPixel, int startRow, int startColumn, int mirrorRow, int endColumn){
    for (int row = startRow; row < mirrorRow; row++) {
      System.out.println("In row!");
      for (int col = startColumn; col < endColumn; col++) {
        System.out.println("row: " + row + ", column: " + col);
        topPixel = pixels[row][col];
        botPixel = pixels[mirrorRow*2 - row][col];
        botPixel.setColor(topPixel.getColor());
      }
    }
  }

  public void mirrorGull(){
    int startRow = 233;
    int startColumn = 237;
    int endRow = 325;
    int endColumn = 345;
    int mirrorPoint = endColumn;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    System.out.println("In mirror arms method");
    System.out.println("startRows: " + startRow + ", mirrorPoint: " + mirrorPoint);
    // loop through the rows
    for (int row = startRow; row < endRow; row++) {
      System.out.println("In row!");
      for (int col = startColumn; col < mirrorPoint; col++) {
        System.out.println("row: " + row + ", column: " + col);
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][mirrorPoint*2 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  public void mirrorGull(int startRow, int startColumn, int endRow, int endColumn){
    int mirrorPoint = endColumn;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    System.out.println("In mirror arms method");
    System.out.println("startRows: " + startRow + ", mirrorPoint: " + mirrorPoint);
    // loop through the rows
    for (int row = startRow; row < endRow; row++) {
      System.out.println("In row!");
      for (int col = startColumn; col < mirrorPoint; col++) {
        System.out.println("row: " + row + ", column: " + col);
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][mirrorPoint*2 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  public void copy(Picture fromPic, int positionRow, int positionCol, int partStartRow, int partStartCol, int partEndRow, int partEndCol) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = partStartRow, toRow = positionRow; fromRow < partEndRow && toRow < toPixels.length; fromRow++, toRow++)
    {
      for (int fromCol = partStartCol, toCol = positionCol; fromCol < partEndCol && toCol < toPixels[0].length; fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  public void myCollage(){
    Picture bleh = new Picture("images/bleh.jpg");
    Picture caterpiller = new Picture("images/caterpillar.jpg");
    Picture swan = new Picture("images/swan.jpg");
    this.copy(bleh,0,0,0,0,200,300);
    this.copy(caterpiller,200,200);
    this.mirrorVertical();
    this.copy(swan,350,20);
    //this.write("collage.jpg");
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("images/flower1.jpg");
    Picture flower2 = new Picture("images/flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    //this.write("collage.jpg");
  }


  /** Method to show large changes in color
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel botPixel = null;
    Pixel[][] pixels = new Picture("images/swan.jpg").getPixels2D();
    Color rightColor = null;
    Color botColor = null;

    Pixel[][] newPixels = this.getPixels2D();
    Pixel newLeftPixel = null;
    Pixel newTopPixel = null;

    //Top to bottom edge detection
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        newTopPixel = newPixels[row][col];
        botPixel = pixels[row+1][col];
        botColor = botPixel.getColor();
        if (topPixel.colorDistance(botColor) > edgeDist)
          newTopPixel.setColor(Color.BLACK);
        else
          newTopPixel.setColor(Color.WHITE);
      }
    }

    //Left to right edge detection
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0;
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        newLeftPixel = newPixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > edgeDist && newLeftPixel.getColor() != Color.black)
          newLeftPixel.setColor(Color.BLACK);
      }
    }



  }
  public void edgeDetection(int edgeDist, boolean bool)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel botPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color botColor = null;

    //Top to bottom edge detection
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        botPixel = pixels[row+1][col];
        botColor = botPixel.getColor();
        if (topPixel.colorDistance(botColor) > edgeDist)
          topPixel.setColor(Color.BLACK);
        else
          topPixel.setColor(Color.WHITE);
      }
    }
  }
  public void edgeDetection2(int edgeDist){
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel botPixel = null;
    Pixel[][] pixels = new Picture(this).getPixels2D();
    Color rightColor = null;
    Color botColor = null;

    Pixel[][] newPixels = this.getPixels2D();
    Pixel newLeftPixel = null;
    Pixel newTopPixel = null;

    //Top to bottom edge detection
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        newTopPixel = newPixels[row][col];
        botPixel = pixels[row+1][col];
        botColor = botPixel.getColor();
        if (topPixel.colorDistance(botColor) > edgeDist)
          newTopPixel.setColor(Color.BLACK);
        else
          newTopPixel.setColor(Color.WHITE);
      }
    }

    //Left to right edge detection
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0;
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        newLeftPixel = newPixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > edgeDist && newLeftPixel.getColor() != Color.black)
          newLeftPixel.setColor(Color.BLACK);
      }
    }
  }
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
    //Picture p = new SimplePicture();
  }
  
} // this } is the end of class Picture, put all new methods before this
