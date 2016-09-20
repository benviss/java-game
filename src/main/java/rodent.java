import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.awt.Image;
import java.util.Arrays;


public class rodent {
  public static void main(String[] args) {
    rodent b = new rodent();
    b.run();
  }

  private Animation a;
  private ScreenManager s;
  private Image bg;

  private static final DisplayMode modes1[] = {
    // new DisplayMode(800,600,64,0),
    new DisplayMode(800,600,32,0),
    new DisplayMode(800,600,24,0),
    new DisplayMode(800,600,16,0),
    // new DisplayMode(640,480,64,0),
    new DisplayMode(640,480,32,0),
    new DisplayMode(640,480,24,0),
    new DisplayMode(640,480,16,0),
  };

  // load images and add scenes
  public void loadImages() {
    bg = new ImageIcon("/Users/Guest/Desktop/java-game/src/main/images/background-2.jpg").getImage();
    Image face1 = new ImageIcon("/Users/Guest/Desktop/java-game/src/main/images/megaClosed.png").getImage();
    Image face2 = new ImageIcon("/Users/Guest/Desktop/java-game/src/main/images/megaOpen.png").getImage();

    a = new Animation();
    a.addScene(face1, 250);
    a.addScene(face2, 250);
  }
  // main method called from main
  public void run(){
    s = new ScreenManager();
    try{
      DisplayMode dm = s.findFirstCompatibleMode(modes1);
      s.setFullScreen(dm);
      loadImages();
      movieLoop();
    }finally{
      s.restoreScreen();
    }
  }
  // play movie
  public void movieLoop(){
    long startingTime = System.currentTimeMillis();
    long cumTime = startingTime;
    while(cumTime - startingTime < 3000){
      long timePassed = System.currentTimeMillis() - cumTime;
      cumTime += timePassed;
      a.update(timePassed);

      // draw and update graphics
      Graphics2D g = s.getGraphics();
      draw(g);
      g.dispose();
      s.update();
      try{Thread.sleep(20);
      }catch(Exception ex){}
    }
  }
  // draws graphics
  public void draw(Graphics g){
    g.drawImage(bg, 0,0, null);
    g.drawImage(a.getImage(), 0,0, null);

  }
}
