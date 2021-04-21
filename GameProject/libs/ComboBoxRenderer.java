package GameProject.libs;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboBoxRenderer extends JLabel implements ListCellRenderer<Object> {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {
        Weapon weapon = (Weapon) value;

        if (weapon != null) {
            setText(weapon.getName());
        } else {
            System.out.println("weapon null!!");
        }

        if (isSelected) {
            setBackground(Color.BLUE);
            setForeground(Color.RED);
        } else {
            setForeground(Color.BLACK);
            setBackground(Color.LIGHT_GRAY);
        }
        setFont(list.getFont());
        return this;
    }

}
