package GameProject.libs;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboBoxRenderer extends JLabel implements ListCellRenderer<Object> {

    public ComboBoxRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {

        // setText(value.toString());
        setBackground(isSelected ? Color.RED : Color.white);
        setForeground(isSelected ? Color.white : Color.black);
        return this;
    }

}
