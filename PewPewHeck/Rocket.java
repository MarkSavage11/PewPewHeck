import java.awt.*;


public class Rocket extends Bullet{

   private int fuseTime;

   public Rocket(int x, int y, ID id, Handler handler){
      
      super(x,y,id,handler);
      
      fuseTime = 180;
   }
   
   public void tick(){
      
      if (fuseTime == 180) eject();
      
      if (fuseTime == 160) aim();
      
      if (fuseTime == 120) seek();
      
      x += velX;
      y += velY;
      
      fuseTime--;
   }
   
   public void render(Graphics g){
      
      g.setColor(Color.orange);
      g.fillRect(x,y,5,5);
      
   }
   
   public boolean isDead(){
      return fuseTime <=0;
   }
   
   public void eject(){
      this.setVelX(0);
      this.setVelY(5);
   }
   
   public void aim(){
      this.setVelX(0);
      this.setVelY(0);
   }
   
   public void seek(){
      
      GameObject player = null;
      for(GameObject o : handler.objects){
         if(o.getID() == ID.Player){
            player = o;
         }
      }
      
      int deltaX = player.getX() - this.getX();
      int deltaY = player.getY() - this.getY();
      
      
      velX = deltaX / 30;
      velY = deltaY / 30;
      
   }
   
   public Rectangle getBounds(){
      
      return new Rectangle(x,y,5,5);
   
   }
   
}