package ImageProxy_Pattern;

import javax.swing.ImageIcon;
import java.awt.*;
import java.net.*;
import javax.swing.*;


public class NoImageState implements State{
    // volatile ImageIcon imageIcon;
    ImageProxy imageProxy;
    
    Thread iconLoadedThread;
    boolean iconLoaded = false;
	
    public NoImageState(ImageProxy imageProxy){
        this.imageProxy = imageProxy;
        // this.imageIcon = imageIcon;
    }

    @Override
    public void paint(Component c, Graphics g, int x, int y) {
        g.drawString("Downloading!! please wait...", x + 300, y + 190);

        if(!iconLoaded){
            iconLoaded = true;
            
            iconLoadedThread = new Thread(new Runnable(){
               public void run(){
                   try {
                        System.out.println("loading.....");
                        imageProxy.setImageIcon(new ImageIcon(imageProxy.imageURL, "Album Cover"));
                        Thread thread = new Thread();
                        thread.sleep(3000);
                        
                        imageProxy.setState(imageProxy.getHasImageState());
                        
                        c.repaint();
                        
                   } catch (Exception e) {
                        System.out.println("image load exception...");
                   }
               } 
            });
            iconLoadedThread.start();
        }
    }

    @Override
    public int getWidth() {
        return 800;
    }

    @Override
    public int getHeight() {
       return 600;
    }
    
    
}
