import java.awt.Graphics;
import java.util.LinkedList;

public class Handler{
   
   LinkedList<GameObject> objects = new LinkedList<GameObject>();
   
   public void tick(){
      for(int i = 0; i < objects.size(); i++){
         GameObject tempObject = objects.get(i);
         
         tempObject.tick();
         
         if(tempObject.isDead()) this.removeObject(tempObject);
         
         if(tempObject.getY() > Game.HEIGHT || tempObject.getY() < -10 || tempObject.getX() > Game.WIDTH|| tempObject.getX() < -10){
            this.removeObject(objects.get(i));
         }
         
         

      }
   }
   
   public void render(Graphics g){
      for(int i = 0; i < objects.size(); i++){
         GameObject tempObject = objects.get(i);
         
         tempObject.render(g);
      }
   }
   
   public void addObject(GameObject object){
      this.objects.add(object);
   }
   
   public void removeObject(GameObject object){
      this.objects.remove(object);
   }
   
   public void removeAll(){
      objects.clear();
   }
}