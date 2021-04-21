package ImageProxy_Pattern;
import java.awt.*;




public interface State {
    public void paint(Component c, Graphics g, int x, int y);
    public int getWidth();
    public int getHeight();
}
