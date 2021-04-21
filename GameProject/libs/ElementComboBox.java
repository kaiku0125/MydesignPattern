package GameProject.libs;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ElementComboBox extends JComboBox<Object> {
    private DefaultComboBoxModel<Object> model;

    public ElementComboBox() {
        model = new DefaultComboBoxModel<Object>();
        setModel(model);
        setRenderer(new ComboBoxRenderer());
        setEditor(new MyComboBoxEditor());
    }

    public void addItems(String[] items) {
        for (String anItem : items) {
            model.addElement(anItem);
        }
    }
}
