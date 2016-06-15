import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;


public class BasicEnemy extends Enemy{

   private static final int SHOOTDELAY = 20;
   private static final int SIZE = 48;
   
   private int shootTimer, health, animationFrame;

   private boolean dead;
   
   private SpriteSheet ss;
    
   public BasicEnemy(int x, int y, ID id, Handler handler){
    
      super(x,y,id,handler);
      velX = 2;
      velY = 1;
      health = 45;
      ss = new SpriteSheet((Game.loader.load("/BasicEnemy.png")),SIZE,SIZE);
   
   }

   public void tick(){
      
      move();
      
      shoot();
      
      checkHit();
   
      
   }
   
   public void render(Graphics g){
      
      Graphics2D g2d = (Graphics2D)g;
      g2d.drawImage(ss.getSprite(0), x, y, null);
      
      if(health<=0) deathAnimation(g);
   }
   
   public void shoot(){
      shootTimer++;
      if(shootTimer % SHOOTDELAY == 0){
         for(int i = -1; i<= 1; i++){
            Bullet tempBullet1 = new Bullet(x + ((SIZE/2)*(i+1)),y+SIZE/2,ID.Bullet,handler);
            tempBullet1.setVelX(3*i);
            tempBullet1.setVelY(2);
            handler.addObject(tempBullet1);
            
            Bullet tempBullet2 = new Bullet(x + ((SIZE/2)*(i+1)),y,ID.Bullet,handler);
            tempBullet2.setVelX(3*i);
            tempBullet2.setVelY(-2);
            handler.addObject(tempBullet2);
            
         }
         shootTimer = 0;
      }
   }
   
   public void move(){
      if(x <= 0 || x > Game.WIDTH-48){
         velX = -velX;
      }
      x += velX;
      if(y <= 0 || y > Game.HEIGHT-48){
         velY = -velY;
      }
      y += velY;
   }
   
   public Rectangle getBounds(){
      Rectangle boundary = new Rectangle(x,y,48,48);
      return boundary;
   }
   
   public void checkHit(){
      for(GameObject o : handler.objects){
         if((this.getBounds().intersects(o.getBounds()) && (o.getID()==ID.PlayerBullet))){
            hit();
            o.setDead(true);
         }   
         
      }
   }
   
   public void hit(){
      //damageAnimation();
      health --;
   }

   public void damageAnimation(Graphics g){
      
   }
   
   public boolean isDead(){
      return health <= 0;
   }
   
   public void deathAnimation(Graphics g){
   
   }
}