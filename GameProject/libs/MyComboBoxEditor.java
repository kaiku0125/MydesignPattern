package GameProject.libs;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class MyComboBoxEditor extends BasicComboBoxEditor {
    private JPanel panel = new JPanel();
    private JLabel labelItem = new JLabel();
    private String selectedValue;

    public MyComboBoxEditor() {

        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        constraints.insets = new Insets(2, 5, 2, 2);

        labelItem.setOpaque(false);
        labelItem.setHorizontalAlignment(JLabel.LEFT);
        labelItem.setForeground(Color.WHITE);

        panel.add(labelItem, constraints);
        panel.setBackground(Color.BLUE);
    }

    public Component getEditorComponent() {
        return this.panel;
    }

    public Object getItem() {
        return this.selectedValue;
    }

    public void setItem(Object item) {
        if (item == null) {
            return;
        }
        String[] allelement = new String[5];
        for (int i = 0; i < 5; i++) {
            allelement[i] = String.valueOf(i);
        }
        allelement = (String[]) item;
        selectedValue = allelement[0];
        labelItem.setText(selectedValue);
    }
}
