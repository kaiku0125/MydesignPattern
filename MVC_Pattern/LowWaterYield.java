package MVC_Pattern;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LowWaterYield implements State{

    private String message = "低出水量";
    Icon shower;
    @Override
    public String setwaterYield() {
        return message;
    }
    @Override
    public Icon initImage() {
        try {
            shower = new ImageIcon("MVC_Pattern//src//shower.jpg");
            
        } catch (Exception e) {
            System.out.println("Cant load shower image!");
        }
        return shower;
    }
    
}
