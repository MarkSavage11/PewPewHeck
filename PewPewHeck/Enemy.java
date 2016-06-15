import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;

public class Enemy extends GameObject{
   

   
   public Enemy(int x, int y, ID id, Handler handler){
      super(x,y,id,handler);
      
   }
   
   public void tick(){
      move();
      
      shoot();
      
      checkHit();
   
   }
   
   public void render(Graphics g){
      
   }
   
   public void move(){
   
   }
   
   public void shoot(){
   
   }
   
   public void checkHit(){
      for(GameObject o : handler.objects){
         if((this.getBounds().intersects(o.getBounds()) && (o.getID()==ID.PlayerBullet))){
            hit();
            o.setDead(true);
         }   
         
      }
   }
   
   public Rectangle getBounds(){
      return null;
   }
   
   public void hit(){
      
   }
}