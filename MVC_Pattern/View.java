package MVC_Pattern;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

public class View implements ActionListener, TemperatureObserver {
    ControllerInterface controller;
    ModelInterface model;
    JFrame viewFrame;
    JPanel mainPanel;
    JButton increase_btn, decrease_btn;
    JLabel showerimageLabel, temperatureLabel;
    JComboBox<String> showerComboBox;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem startMenuItem, stopMenuItem;

    public View(ControllerInterface controller, ModelInterface model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver(this);
    }

    public void createView() {
        viewFrame = new JFrame("自定義熱水器");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        menuBar.setPreferredSize(new DimensionUIResource(20, 20));
        menu = new JMenu("開關");

        menuBar.add(menu);
        viewFrame.setJMenuBar(menuBar);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        showerimageLabel = new JLabel(new ImageIcon());
        showerimageLabel.setSize(600, 600);
        showerimageLabel.setBounds(0, 0, 600, 600);

        temperatureLabel = new JLabel("尚未開機", SwingConstants.CENTER);
        temperatureLabel.setFont(new Font("Serif", Font.BOLD, 15));
        temperatureLabel.setBounds(600, 400, 200, 100);

        String[] option = new String[] { "淋浴", "泡澡" };
        showerComboBox = new JComboBox<String>(option);
        showerComboBox.setSelectedItem(null);
        showerComboBox.setBounds(600, 0, 170, 50);

        increase_btn = new JButton("+");
        increase_btn.setBounds(700, 500, 100, 100);

        decrease_btn = new JButton("-");
        decrease_btn.setBounds(600, 500, 100, 100);

        mainPanel.add(showerimageLabel);
        mainPanel.add(showerComboBox);
        mainPanel.add(increase_btn);
        mainPanel.add(decrease_btn);
        mainPanel.add(temperatureLabel);

        viewFrame.getContentPane().add(mainPanel);
        viewFrame.setSize(818, 660);
        viewFrame.setVisible(true);
    }

    public void createControls() {
        startMenuItem = new JMenuItem("啟動");
        menu.add(startMenuItem);
        startMenuItem.addActionListener((event) -> controller.start());

        stopMenuItem = new JMenuItem("關機");
        menu.add(stopMenuItem);
        stopMenuItem.addActionListener((event) -> controller.stop());

        showerComboBox.addActionListener(this);
        increase_btn.addActionListener(this);
        decrease_btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == increase_btn) {
            controller.increaseTemp();
        } else if (e.getSource() == decrease_btn) {
            controller.decreaseTemp();
        } else if (e.getSource() == showerComboBox) {
            int selected = showerComboBox.getSelectedIndex();
            if (selected == 0) {
                enablebtn(true);
                controller.changeLowState();
                showerimageLabel.setIcon(model.initImage());

            } else if (selected == 1) {
                enablebtn(true);
                controller.changeHighState();
                showerimageLabel.setIcon(model.initImage());
            } else {
                enablebtn(false);
                controller.changenoState();
                showerimageLabel.setIcon(model.initImage());
            }
        }
    }

    @Override
    public void updataTemperature() {
        int temp = model.getTemperature();

        if (model.isStoppable()) {
            temperatureLabel.setText("請啟動電源");
        } else if (!model.isStoppable()) {
            temperatureLabel.setText("當前水溫 : " + String.valueOf(temp) + "°C");
        }

    }

    public void enableStartMenuItem() {
        startMenuItem.setEnabled(true);
    }

    public void disableStartMenuItem() {
        startMenuItem.setEnabled(false);
    }

    public void enableStopMenuItem() {
        stopMenuItem.setEnabled(true);
    }

    public void disableStopMenuItem() {
        stopMenuItem.setEnabled(false);
    }

    public void enablebtn(boolean b) {
        increase_btn.setEnabled(b);
        decrease_btn.setEnabled(b);

    }

    public void enableCombobox(boolean b) {
        showerComboBox.setEnabled(b);
        ;
    }

    public void setcomboboxNULL() {
        showerComboBox.setSelectedItem(null);
    }

}
