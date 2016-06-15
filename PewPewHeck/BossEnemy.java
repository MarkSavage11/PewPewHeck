import java.awt.*;

public class BossEnemy extends Enemy{

   private static final int SIZE = 128;
   private static final int SHOOTDELAY = 30;
   private static final int ROCKETDELAY = 120;

   private int shootTimer, health, rocketTimer;
   private boolean dead;
   
   private SpriteSheet ss;
   
   public BossEnemy(int x, int y, ID id, Handler handler){
      super(x,y,id,handler);
      velY = 1;
      velX = 1;
      shootTimer = 0;
      health = 300;
      rocketTimer = 0;
      ss = new SpriteSheet((Game.loader.load("/BossEnemy2.png")),SIZE,SIZE);
   }
   
//    public void tick(){
//       move();
//       
//       shoot();
// 
//       checkHit();
//       
//       
//    }
   
   public void render(Graphics g){
      
      //g.setColor(Color.red);
      //g.fillRect(x,y,SIZE, SIZE/2);
      Graphics2D g2g = (Graphics2D)g;
      g2g.drawImage(ss.getSprite(),x,y,null);
      
   }
   
   public Rectangle getBounds(){
      Rectangle rect = new Rectangle(x,y,SIZE,SIZE/2);
      return rect;
   }
   
   public void move(){
      x+= velX;
      
      if(x <= 0 || x > Game.WIDTH-128){
         velX = -velX;
      }
      x += velX;
      if(y <= 0 || y > Game.HEIGHT-128){
         velY = -velY;
      }

   }
   
   public void shoot(){
      shootTimer++;
      if(shootTimer % SHOOTDELAY == 0){
         for(int i = -1; i<= 1; i++){
            Bullet tempBullet = new Bullet(x + ((SIZE/2)*(i+1)),y+SIZE/2,ID.Bullet,handler);
            tempBullet.setVelX(1*i);
            tempBullet.setVelY(4);
            handler.addObject(tempBullet);
         }
         shootTimer = 0;
      }
      rocketTimer++;
      if(rocketTimer % ROCKETDELAY == 0){
         handler.addObject(new Rocket(x+4,y+SIZE/2,ID.Bullet,handler));
         handler.addObject(new Rocket(x+SIZE-9,y+SIZE/2,ID.Bullet,handler));
      }
   }
   
   public void hit(){
      damageAnimation();
      health--;
      if(health<=0) deathAnimation();
   }
   
   public void damageAnimation(){
   
   }
   
   public void deathAnimation(){
   
   }
   
   public boolean isDead(){
      return health<=0;
   }


}