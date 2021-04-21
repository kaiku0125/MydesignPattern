package GameProject.libs;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import GameProject.Game.ModelInterface;

public class WeaponComboBox extends JComboBox<Object> {
    private DefaultComboBoxModel<Object> model;
    ModelInterface modelInterface;

    public WeaponComboBox(ModelInterface modelInterface) {
        this.modelInterface = modelInterface;
        modelInterface.initWeapon();
        Weapon sword = new Weapon("Sword");
        sword.setlevel(modelInterface.getSwordLevel());
        System.out.println(".........." + modelInterface.getSwordLevel());
        Weapon bow = new Weapon("Bow");
        bow.setlevel(modelInterface.getBowLevel());
        model = new DefaultComboBoxModel<Object>();
        model.addElement(sword);
        model.addElement(bow);
        setModel(model);
        setRenderer(new ComboBoxRenderer());
    }

}
