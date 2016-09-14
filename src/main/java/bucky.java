import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class bucky extends JFrame{
  public static void main(String[] args){
    DisplayMode displayMode = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
    bucky b = new bucky();
    b.run(displayMode);
  }

  private Screen screen;
  private Image bg;
  private Animation a;

// loads pics from computer to java
  public void loadPics(){
    bg = new ImageIcon("/Users/Guest/Desktop/java_game/src/main/images/background-2.jpg").getImage();
    Image mega1 = new ImageIcon("/Users/Guest/Desktop/java_game/src/main/images/megaClosed.png").getImage();
    Image mega2 = new ImageIcon("/Users/Guest/Desktop/java_game/src/main/images/megaOpen.png").getImage();
    a = new Animation();
    a.addScene(mega1, 250);
    a.addScene(mega2, 250);
  }
  // main engine to run
  public void run(DisplayMode dm){
    screen = new Screen();
    try{
      screen.setFullScreen(dm, new JFrame());
      loadPics();
      movieLoop();
    }finally{
      screen.restoreScreen();
    }
  }

  // main movie loop
  public void movieLoop() {
    long startingTime = System.currentTimeMillis();
    long cumTime = startingTime;

    while(cumTime - startingTime <5000) {
      long timePassed = System.currentTimeMillis() - cumTime;
      cumTime += timePassed;
      a.update(timePassed);

      Graphics g = screen.getFullScreenWindow().getGraphics();
      draw(g);
      g.dispose();

      try{
        Thread.sleep(20);
      }catch (Exception ex) {}
    }
  }
  // draw method
  public void draw(Graphics g){
    g.drawImage(bg, 0, 0, null);
    g.drawImage(a.getImage(), 200, 200, null);

  }
}

  // public void run(DisplayMode dm){
  //   setBackground(Color.PINK);
  //   setForeground(Color.WHITE);
  //   setFont(new Font("Arial", Font.PLAIN, 24));
  //
  //   Screen s = new Screen();
  //   try{
  //     s.setFullScreen(dm, this);
  //     try{
  //       Thread.sleep(5000);
  //     }catch(Exception ex){}
  //   }finally{
  //     s.restoreScreen();
  //   }
  // }
  // public void paint(Graphics g){
  //   if(g instanceof Graphics2D) {
  //     Graphics2D g2 = (Graphics2D)g;
  //     g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
  //   }
  //   g.drawString("Success!!", 200, 200);
  // }
