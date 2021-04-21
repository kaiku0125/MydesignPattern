package ImageProxy_Pattern;

import java.net.*;
import java.awt.*;
import javax.swing.*;

public class ImageProxy implements Icon{

    volatile ImageIcon imageIcon;
    final URL imageURL;
    Thread iconLoadedThread;
    boolean iconLoaded = false;
    State noImageState;
    State hasImageState;
    State state;

    public ImageProxy(URL url){
        this.imageURL = url;
        hasImageState = new HasImageState(this);
        noImageState = new NoImageState(this);
        state = noImageState;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        state.paint(c, g, x, y);

    }

    @Override
    public int getIconWidth() {
        return state.getWidth();
    }

    @Override
    public int getIconHeight() {
        return state.getHeight();
    }

    public void setState(State state){
        this.state = state;
    }
    

    public State getHasImageState(){
        return hasImageState;
    }
    public State getnoImageState(){
        return noImageState;
    }
    public synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    // public ImageProxy(URL url){
    //     this.imageURL = url;
    // }

    // public synchronized void setImageIcon(ImageIcon imageIcon) {
    //     this.imageIcon = imageIcon;
    // }


    // @Override
    // public void paintIcon(Component c, Graphics g, int x, int y) {
    //     if(imageIcon != null){
    //         imageIcon.paintIcon(c, g, x, y);
    //     }else{
    //         g.drawString("Downloading!! please wait...", x + 300, y + 190);

    //         if(!iconLoaded){
    //             iconLoaded = true;

    //             iconLoadedThread = new Thread(new Runnable(){
    //                public void run(){
    //                    try {
    //                        setImageIcon(new ImageIcon(imageURL, "Album Cover"));
    //                        c.repaint();
    //                        System.out.println("11111111111111111");
    //                    } catch (Exception e) {
    //                        //TODO: handle exception
    //                        System.out.println("3333333333333333");
    //                    }
    //                } 
    //             });
    //         }iconLoadedThread.start();

    //     }

    // }

    // @Override
    // public int getIconWidth() {
    //     if(imageIcon != null){
    //         return imageIcon.getIconWidth();
    //     }else{
    //         return 800;
    //     }
    // }

    // @Override
    // public int getIconHeight() {
    //    if(imageIcon != null){
    //        return imageIcon.getIconHeight();
    //    }else{
    //        return 600;
    //    }
    // }
    
    
}
