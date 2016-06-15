import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;

public class Bullet extends GameObject{
   
 
   public Bullet(int x, int y, ID id,Handler handler){
      super(x,y,id,handler);
      
      velX = 0;
      velY = 3;
      
   }
   
   public void tick(){
      x += velX;
      y += velY;
   }
   
   public void render(Graphics g){
      g.setColor(Color.RED);
      g.fillRect(x,y,4,4);
   }
   
   public Rectangle getBounds(){
      Rectangle boundary = new Rectangle(x,y,4,4);
      return boundary;
   }

   
}