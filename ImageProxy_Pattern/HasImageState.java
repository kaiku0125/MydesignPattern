package ImageProxy_Pattern;


import java.awt.*;

import javax.swing.ImageIcon;
                                        

public class HasImageState implements State{
    ImageProxy imageProxy;
    // volatile ImageIcon imageIcon;

    public HasImageState(ImageProxy imageProxy){
        this.imageProxy = imageProxy;
        // this.imageIcon = imageIcon;
    }


    @Override
    public void paint(Component c, Graphics g, int x, int y) {
        System.out.println("有圖片...paint");
        // imageIcon.paintIcon(c, g, x, y);
        imageProxy.imageIcon.paintIcon(c, g, x, y);
        
    }

    @Override
    public int getWidth() {
        System.out.println("有圖片...getWidth");
         return imageProxy.imageIcon.getIconWidth();
        // return 800;
    }

    @Override
    public int getHeight() {
        System.out.println("有圖片...getWidth");
         return imageProxy.imageIcon.getIconHeight();
    //    return 600;
    }
    

}
    

