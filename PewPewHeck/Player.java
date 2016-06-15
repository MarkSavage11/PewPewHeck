import java.awt.*;
import javax.swing.ImageIcon;

public class Player extends GameObject{
   private boolean upPressed, downPressed, leftPressed, rightPressed, shootPressed;
   private int shootTime, lives, iFrames, animationFrame;
   public static final int SIZE = 16;
   public static final int MOVSPEED = 3;
   public static final int SHOOTDELAY = 4;
   public static final int HITBOXSIZE = 8;
   private SpriteSheet ss; 
   
   
   public Player(int x, int y, ID id, Handler handler){//constructor
      super(x,y,id,handler);
      shootTime = 0;
      lives = 3;
      iFrames = 0;
      animationFrame = 0;
      ss = new SpriteSheet((Game.loader.load("/PlayerSpriteSheet.png")),SIZE,SIZE);
   }   
   
   public void tick(){
      
      KeyInput k = new KeyInput(handler);
      int velXSum = 0;
      int velYSum = 0;
      //add else statemets to set if false
   
      if(upPressed)    velYSum -= MOVSPEED;
      if(downPressed)  velYSum += MOVSPEED;
      if(leftPressed)  velXSum -= MOVSPEED;
      if(rightPressed) velXSum += MOVSPEED;
      if(shootPressed) {
         animationFrame = 1;
         shootTime++;
         if(shootTime%SHOOTDELAY == 0 && iFrames==0) shoot();
      }else animationFrame = 0;
     //  x += velX;
     //  y += velY;
      
      x += velXSum;
      y += velYSum;
       
      x = Game.clamp(this.x, 0, Game.WIDTH - 22);
      y = Game.clamp(this.y, 0, Game.HEIGHT - 40);
      
      for(GameObject o : handler.objects){
         if((this.getBounds().intersects(o.getBounds()) && (o.getID()==ID.Bullet || o.getID() == ID.Enemy)) && iFrames ==0) hit();
            
         
      }
      
      if(iFrames!=0){
         iFrames--;
         if(iFrames % 3 !=0) animationFrame = 2;
         else animationFrame = 0;
      }
      
      
            
   }
   
   public Rectangle getBounds(){
      Rectangle boundary = new Rectangle(x+HITBOXSIZE/2,y+HITBOXSIZE/2,HITBOXSIZE,HITBOXSIZE);
      return boundary;
   }
   
   public void setUpPressed(boolean keyState) {
      this.upPressed = keyState;
   }
   public void setDownPressed(boolean keyState) {
      this.downPressed = keyState;
   }
   public void setLeftPressed(boolean keyState) {
      this.leftPressed = keyState;
   }
   public void setRightPressed(boolean keyState) {
      this.rightPressed = keyState;
   }
   public void setShootPressed(boolean keyState) {
      this.shootPressed = keyState;
   }
   
   public void render(Graphics g){
      
      
      Graphics2D g2d = (Graphics2D)g;
      g2d.drawImage(ss.getSprite(animationFrame), x, y, null);
      


   }
   
   
   public void shoot(){
   
      animationFrame = 1;
      handler.addObject(new PlayerBullet(x+6,y-2,ID.PlayerBullet,handler));
      
      shootTime = 0;
      
   }
   
   public void hit(){
      deathAnimation();
      //this.setX(Game.WIDTH /2 - 8);
      //this.setY(Game.HEIGHT - 64);
      iFrames += 180;
      lives --;
      if(lives<= 0) Game.gameOver(handler);
   }
   
   public void deathAnimation(){
      
   }

}
