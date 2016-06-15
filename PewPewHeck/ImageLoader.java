import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class ImageLoader{
   
   
   
   public BufferedImage load(String path){
      try{
         return ImageIO.read(getClass().getResource(path));
      } catch (IOException e){
         e.printStackTrace();
      }
      return null;
   }
   
}