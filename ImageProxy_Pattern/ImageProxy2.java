package ImageProxy_Pattern;

import java.net.*;
import java.awt.*;
import javax.swing.*;

public class ImageProxy2 implements Icon{
    volatile ImageIcon imageIcon;
	final URL imageURL;
	Thread IconLoadedThread;
	boolean IconLoaded = false;
     
	public ImageProxy2(URL url) { imageURL = url; }
     
	public int getIconWidth() {
		if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
			return 800;
		}
	}
 
	public int getIconHeight() {
		if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
			return 600;
		}
	}
	
	synchronized void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}
     
	public void paintIcon(final Component c, Graphics  g, int x,  int y) {
		if (imageIcon != null) {
			System.out.println(" imageIcon != null");
			imageIcon.paintIcon(c, g, x, y);
		} else {
			System.out.println(" imageIcon == null");
			g.drawString("Loading album cover, please wait...", x+300, y+190);
			if (!IconLoaded) {
				IconLoaded = true;
				
				IconLoadedThread = new Thread(new Runnable() {
					public void run() {
						try {
							setImageIcon(new ImageIcon(imageURL, "Album Cover"));
							c.repaint();
							System.out.println("c.repaint.....");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				IconLoadedThread.start();
			}
		}
	}
}
