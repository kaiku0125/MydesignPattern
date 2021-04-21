package ImageProxy_Pattern;

import java.awt.*;
import javax.swing.*;

public class ImageComponent extends JComponent {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Icon icon;

    public ImageComponent(Icon icon) {
        this.setIcon(icon);
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        int x = (800 - w)/2;
		int y = (600 - h)/2;
        icon.paintIcon(this, graphics, x, y);
    }

    
    


}
    