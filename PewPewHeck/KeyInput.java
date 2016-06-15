import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
  
   private Handler handler;
   
   public KeyInput(Handler handler){
      this.handler = handler;
   }


   public void keyPressed(KeyEvent e){
      int key = e.getKeyCode();
      for(int i= 0;i< handler.objects.size();i++){
      
         GameObject tempObject = handler.objects.get(i);
         if(tempObject.getID() == ID.Player){
            if(key == KeyEvent.VK_UP){
               //tempObject.setVelY(0);
               ((Player)tempObject).setUpPressed(true);
            }
            if(key == KeyEvent.VK_DOWN){
               //tempObject.setVelY(0);
               ((Player)tempObject).setDownPressed(true);
            }
            if(key == KeyEvent.VK_LEFT){
               //tempObject.setVelX(0);
               ((Player)tempObject).setLeftPressed(true);
            }
            if(key == KeyEvent.VK_RIGHT){
               //tempObject.setVelX(0);
               ((Player)tempObject).setRightPressed(true);
            }
            if(key == KeyEvent.VK_Z){
               ((Player)tempObject).setShootPressed(true);
            }
         }
      } 
   }//end keyPressed
      
   public void keyReleased(KeyEvent e){
      int key = e.getKeyCode();
      for(int i= 0;i< handler.objects.size();i++){
         GameObject tempObject = handler.objects.get(i);
         if(tempObject.getID() == ID.Player){
            if(key == KeyEvent.VK_UP){
               //tempObject.setVelY(0);
               ((Player)tempObject).setUpPressed(false);
            }
            if(key == KeyEvent.VK_DOWN){
               //tempObject.setVelY(0);
               ((Player)tempObject).setDownPressed(false);
            }
            if(key == KeyEvent.VK_LEFT){
               //tempObject.setVelX(0);
               ((Player)tempObject).setLeftPressed(false);
            }
            if(key == KeyEvent.VK_RIGHT){
               //tempObject.setVelX(0);
               ((Player)tempObject).setRightPressed(false);
            }
            if(key == KeyEvent.VK_Z){
               ((Player)tempObject).setShootPressed(false);
            }
         }
      }   
   }//end keyReleased
}

