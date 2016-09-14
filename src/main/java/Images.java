import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Images extends JFrame{
  public static void main(String[] args){

    DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
    Images i = new Images();
    i.run(dm);
  }

  private Screen s;
  private Image bg;
  private Image pic;
  private boolean loaded;


  // run method
  public void run(DisplayMode dm){
    setBackground(Color.PINK);
    setForeground(Color.WHITE);
    setFont(new Font("Arial", Font.PLAIN, 24));
    loaded = false;

    s = new Screen();
    try{
      s.setFullScreen(dm, this);
      loadpic();
      try{
        Thread.sleep(5000);
      }catch(Exception ex){}
    }finally{
      s.restoreScreen();
    }
  }
  // loads pics
  public void loadpic(){
    bg = new ImageIcon("/Users/Guest/Desktop/java_game/src/main/images/background.jpg").getImage();
    pic = new ImageIcon("/Users/Guest/Desktop/java_game/src/main/images/angry_crocodile.jpg").getImage();
    loaded = true;
    repaint();
  }


  public void paint(Graphics g){
    if(g instanceof Graphics2D) {
      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }
    if (loaded){
      g.drawImage(bg,0,0,null);
      g.drawImage(pic, 170, 180, null);
    }
  }
}
