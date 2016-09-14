import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;

public class ScreenManager {

    private GraphicsDevice vc;

    // Give vc access to monitor
    public ScreenManager(){
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = e.getDefaultScreenDevice();
    }

    // get all compatible DM
    public DisplayMode[] getCompatibleDisplayModes(){
        return vc.getDisplayModes();
    }


    // compare DM passed in to vc DM and see if they match
    public DisplayMode findFirstCompatibleMode(DisplayMode modes[]) {
        DisplayMode goodModes[] = vc.getDisplayModes();
        for(int x =0; x<mdoes.length;x++) {
            for(int y =0;y<goodModes.length;y++){
                if (displayModesMatch(modes[x], goodModes[y])) {
                    return modes[x];
                }
            }
        }
    }
    // get current DM
    public DisplayMode getCurrentDisplayMode() {
        return vc.getDisplayMode();
    }
    



}
