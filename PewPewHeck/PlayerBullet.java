import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;

public class PlayerBullet extends GameObject{

   private boolean dead;
   
   public PlayerBullet(int x, int y, ID id,Handler handler){
      super(x,y,id,handler);
      dead = false;
   }
   
   public void tick(){
      x += 0;
      y += -11;
   }
   
   public void render(Graphics g){
      g.setColor(Color.BLUE);
      g.fillRect(x,y,4,4);
   }
   
   public Rectangle getBounds(){
      Rectangle boundary = new Rectangle(x,y,4,4);
      return boundary;
   }
   
      
   public boolean isDead(){
      return dead;
   }
   
   public void setDead(boolean b){
      dead = b;
   }
   
   
}