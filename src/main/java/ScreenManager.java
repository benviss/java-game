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
        return null;
    }
    // get current DM
    public DisplayMode getCurrentDisplayMode() {
        return vc.getDisplayMode();
    }

    // checks if 2 modes match each other
    public boolean displayModesMatch(DisplayMode m1, DisplayMode m2){
        if(m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight()){
            return false;
        }
        if(m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m1.getBitDepth() != m2.getBitDepth()){
            return false;

        }
        if(m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m1.getRefreshRate() != m2.getRefreshRate()){
            return false;
        }
        return true;
    }



}
