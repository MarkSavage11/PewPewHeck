import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.ImageIcon;


public class Game extends Canvas implements Runnable{
   
   public static final int WIDTH = 640, HEIGHT = 800;
   
   private Thread thread;
   private boolean running = false;
   private Handler handler;
   public static ImageLoader loader;   
   private static boolean isGameOver = false;

   public Game(){
      
      handler = new Handler();
      this.addKeyListener(new KeyInput(handler));
      
      new Window(WIDTH, HEIGHT, "PewPew HECK", this);
      
      loader = new ImageLoader();
      handler.addObject(new Player(WIDTH/2 - 8,HEIGHT/2 - 8, ID.Player, handler));
      handler.addObject(new BasicEnemy(100,50,ID.Enemy, handler));
      handler.addObject(new BasicEnemy(300,25,ID.Enemy, handler));
      handler.addObject(new BossEnemy(40,20,ID.Enemy,handler));
      handler.addObject(new Rocket(50,50,ID.Bullet,handler));
   }
   
   
   public static void main(String[] args){
      new Game();
   }
   
   public synchronized void start(){
      thread = new Thread(this);
      thread.start();
      running = true;
   }
   
   public synchronized void stop(){
      try{
         thread.join();
         running = false;
         
      }catch(Exception e){
         e.printStackTrace();
      }
   }
   
   public void run(){
      this.requestFocus();
      long lastTime = System.nanoTime();
      double amountOfTicks = 60.0;
      double ns = 1000000000 / amountOfTicks;
      double delta = 0;
      long timer = System.currentTimeMillis();
      int frames = 0;
      while(running){
         long now = System.nanoTime();
         delta += (now - lastTime) / ns;
         lastTime = now;
         while(delta >= 1){
            tick();
            delta--;
         }
         if(running)
            render();
         frames++;
         
         if(System.currentTimeMillis() - timer > 1000){
            timer += 1000;
            //System.out.println("FPS: " + frames);
            frames = 0;
         }
      }
      stop();
   }
   
   private void tick(){
      handler.tick();
   }
   
   private void render(){
      BufferStrategy bs = this.getBufferStrategy();
      if(bs == null){
         this.createBufferStrategy(3);
         return;
      }  
      
      Graphics g = bs.getDrawGraphics();
      //ImageIcon ii = new ImageIcon("BackGround.png");
      //sprite = ii.getImage();
      // g.setColor(Color.black);
//       g.fillRect(0, 0, WIDTH, HEIGHT);
      
      Graphics2D g2d = (Graphics2D)g;
      g2d.drawImage(new ImageIcon("BackGround.png").getImage(), 0, 0, null);
      if (isGameOver){
         g2d.drawImage(new ImageIcon("GAMEOVER.png").getImage(), 0, 0, null);
      }
      handler.render(g);
      
      g.dispose();
      bs.show();
   }
   
   public static int clamp(int var, int min, int max){
      if(var>= max)
         return var = max;
      else if(var <= min)
         return var = min;
      else 
         return var;
   }
   
   public static void gameOver(Handler handler){
   
      handler.removeAll();
      isGameOver = true;
   
   }
   
}