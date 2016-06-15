//import java.awt.Canvas;
//import java.awt.Dimension;
import java.awt.*;
import javax.swing.JFrame;

//Will not compile until game is operable, compiles without mentioning game

public class Window extends Canvas{
  
   public Window(int width, int height, String title, Game game){
      JFrame frame = new JFrame(title); //creates window
      
      frame.setPreferredSize(new Dimension(width, height)); //sets sizes, giving only one size for 
      frame.setMaximumSize(new Dimension(width, height));   //min, prefered, and max (for simplicity)
      frame.setMinimumSize(new Dimension(width, height));
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Allows red exit button to exit program
      frame.setResizable(false); //makes user unable to change window size
      frame.setLocation(new Point(0,0)); //makes window show up in middle of screen
      frame.add(game); //puts game on screen
      frame.setVisible(true); //makes it visible 
      
      game.start();
      
      
   }
}