package MVC_Pattern;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class HighWaterYield implements State{

    private String message = "高出水量";
    Icon bath;

    @Override
    public String setwaterYield() {
        return message;       
    }
    @Override
    public Icon initImage() {
        try {
            bath  = new ImageIcon("MVC_Pattern//src//bath.jpeg");
        } catch (Exception e) {
            System.out.println("Cant load bath image!");
        }
        return bath;
    }
    
}
