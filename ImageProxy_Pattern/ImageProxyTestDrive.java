package ImageProxy_Pattern;
import java.net.*;
import javax.swing.*;


import java.util.*;

public class ImageProxyTestDrive {
    ImageComponent imageComponent;
    JFrame frame = new JFrame("Cat Aubum");
    JMenuBar menuBar;
    JMenu menu;
	Hashtable<String, String> albums = new Hashtable<String, String>();

    public static void main(String[] args) throws Exception {
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
    }

    public ImageProxyTestDrive()throws Exception{
        albums.put("CAT","http://pic1.bbzhi.com/dongwubizhi/jiayouchongwu-bosimaobizhi/animal_persian_cat_17175_1.jpg");
		albums.put("DOG","https://img.alicdn.com/imgextra/i1/4089454317/O1CN017tKtCK1hlEKYzivCQ_!!4089454317.jpg");

        URL initialURL = new URL((String)albums.get("CAT"));
		menuBar = new JMenuBar();
		menu = new JMenu("Favorite Albums");
		menuBar.add(menu);
		frame.setJMenuBar(menuBar); 

        for (Enumeration<String> e = albums.keys(); e.hasMoreElements();) {
			String name = (String)e.nextElement();
			JMenuItem menuItem = new JMenuItem(name);
			menu.add(menuItem); 
			System.out.println("...............");
			menuItem.addActionListener(event -> {
				// imageComponent.setIcon(new ImageProxy(getAlbumUrl(event.getActionCommand())));
				imageComponent.setIcon(new ImageProxy2(getAlbumUrl(event.getActionCommand())));
				frame.repaint();
				System.out.println("frame.repaint....");
			});
		}
        // Icon icon = new ImageProxy(initialURL);
		Icon icon = new ImageProxy2(initialURL);
		imageComponent = new ImageComponent(icon);
		frame.getContentPane().add(imageComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.setVisible(true);
    }
	
    URL getAlbumUrl(String name) {
		try {
			return new URL((String)albums.get(name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
