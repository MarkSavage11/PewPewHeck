import java.awt.*;
import javax.swing.ImageIcon;

public abstract class GameObject {

   protected int x, y;
   protected int velX, velY;
   protected ID id;
   protected Handler handler;
   
   
   protected Image sprite1;
   
   public GameObject(int x, int y, ID id, Handler handler){
      this.x = x;
      this.y = y;
      this.id = id;
      this.handler = handler;
      this.sprite1 = null;
   }
   
   public abstract void tick();
   public abstract void render(Graphics g);
   public abstract Rectangle getBounds();
   
   public void setX(int x){
      this.x = x;
   }
   public void setY(int y){
      this.y = y;
   }
   public int getX(){
      return x;
   }
   public int getY(){
      return y;
   }
   public void setID(ID id){
      this.id = id;
   }
   public ID getID(){
      return id;
   }
   public void setVelX(int velX){
      this.velX = velX;
   }  
   public void setVelY(int velY){
      this.velY = velY;
   }
   public int getVelY(){
      return velY;
   }
   public int getVelX(){
      return velX;
   }   
   
   public boolean isDead(){
      return false;
   }
   
   public void setDead(boolean b){
   
   }
}