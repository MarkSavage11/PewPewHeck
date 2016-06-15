
import java.awt.image.BufferedImage;
import javax.swing.*;

public class SpriteSheet{
   
   private BufferedImage sheet;
   private int spriteWidth, spriteHeight;
   
   public SpriteSheet(BufferedImage sheet, int spriteWidth, int spriteHeight){
   
      this.sheet = sheet;
      this.spriteWidth = spriteWidth;
      this.spriteHeight = spriteHeight;
   }
   
   public BufferedImage getSprite(int cell){
      
      return sheet.getSubimage(cell*spriteWidth, 0, spriteWidth, spriteHeight);
      
   }
   
   public BufferedImage getSprite(){
      return sheet;
   }
   
   
   
}