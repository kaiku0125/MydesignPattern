package GameProject.Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import GameProject.libs.Weapon;
import GameProject.libs.WeaponComboBox;

public class ViewMain implements ActionListener, CoinObserver, ClockObserver, Callback {
    private Logger logger = Logger.getLogger(ViewMain.class.getName());
    ControllerMainInterface controller;
    ModelInterface model;

    JFrame mainFrame;
    JPanel mainPanel, leftPanel, rightPanel, downPanel, middlePanel;
    JPanel elementPanel, elementNumPanel;
    JLabel coinLabel, stoneNumLabel, stoneClockLabel, descriptionLabel;
    JLabel alchemyImgLabel, enhanceImgLabel, weaponLevelLabel;
    JLabel bananaLabel, appleLabel, orangeLabel, melonLabel;
    JLabel bananaNum, appleNum, orangeNum, melonNum;
    JComboBox<Integer> element1, element2, element3, element4;
    JButton enhanceBtn, dailyBtn, testBtn;
    WeaponComboBox weaponCombo;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem saveItem;
    JProgressBar enhancementBar, alchemyBar;

    public ViewMain(ControllerMainInterface controller, ModelInterface model) {
        this.controller = controller;
        this.model = model;

        model.registerCoinObserver(this);
        model.registerClockObserver(this);
        model.regStoneCallback(this);
    }

    public void createMainView() {
        mainFrame = new JFrame("KaiKuKu's Game");
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.getContentPane().setBackground(Color.BLACK);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        menuBar.add(menu);
        mainFrame.setJMenuBar(menuBar);

        mainPanel = new JPanel();
        leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(Color.GREEN);
        leftPanel.setBounds(0, 0, 200, 500);

        middlePanel = new JPanel();
        middlePanel.setLayout(null);
        middlePanel.setBackground(Color.RED);
        middlePanel.setBounds(200, 0, 300, 320);

        downPanel = new JPanel();
        // downPanel.setLayout(null);
        downPanel.setBackground(Color.BLUE);
        downPanel.setOpaque(true);
        downPanel.setBounds(200, 320, 300, 30);

        elementPanel = new JPanel();
        elementPanel.setBackground(Color.BLUE);
        elementPanel.setOpaque(true);
        elementPanel.setBounds(200, 350, 300, 30);

        elementNumPanel = new JPanel();
        elementNumPanel.setBackground(Color.BLUE);
        elementNumPanel.setOpaque(true);
        elementNumPanel.setBounds(200, 380, 300, 30);

        rightPanel = new JPanel();
        rightPanel.setBounds(500, 0, 100, 500);
        // component.............//
        weaponCombo = new WeaponComboBox(model);
        weaponCombo.setBounds(0, 0, 200, 50);

        weaponLevelLabel = new JLabel("..");
        weaponLevelLabel.setBounds(75, 140, 50, 20);
        weaponLevelLabel.setOpaque(true);
        weaponLevelLabel.setBackground(Color.WHITE);

        enhanceImgLabel = new JLabel();
        enhanceImgLabel.setBounds(0, 50, 200, 200);

        JLayeredPane pane = new JLayeredPane();
        pane.setBounds(0, 50, 200, 200);
        pane.add(enhanceImgLabel);
        pane.add(weaponLevelLabel);

        enhancementBar = new JProgressBar(0, 100);
        enhancementBar.setBounds(0, 250, 200, 20);
        enhancementBar.setStringPainted(true);
        enhancementBar.setString("");
        enhancementBar.setVisible(false);

        stoneNumLabel = new JLabel("0", SwingConstants.CENTER);
        stoneNumLabel.setBackground(Color.WHITE);
        stoneNumLabel.setOpaque(true);
        stoneNumLabel.setBounds(0, 270, 50, 40);

        stoneClockLabel = new JLabel("00:00", SwingConstants.CENTER);
        stoneClockLabel.setBackground(Color.WHITE);
        stoneClockLabel.setOpaque(true);
        stoneClockLabel.setBounds(0, 310, 50, 40);

        enhanceBtn = new JButton("enhance");
        enhanceBtn.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        enhanceBtn.setBounds(50, 270, 150, 80);

        descriptionLabel = new JLabel("...");
        descriptionLabel.setVerticalAlignment(JLabel.NORTH);
        descriptionLabel.setHorizontalAlignment(JLabel.LEFT);
        descriptionLabel.setBackground(Color.GRAY);
        descriptionLabel.setOpaque(true);
        descriptionLabel.setBounds(0, 350, 200, 150);

        alchemyImgLabel = new JLabel();
        alchemyImgLabel.setBackground(Color.PINK);
        alchemyImgLabel.setOpaque(true);
        alchemyImgLabel.setBounds(0, 0, 300, 300);

        alchemyBar = new JProgressBar(0, 100);
        alchemyBar.setBounds(0, 300, 300, 20);
        alchemyBar.setStringPainted(true);
        alchemyBar.setString("s");
        alchemyBar.setVisible(true);

        Integer[] allelement = new Integer[5];
        for (int i = 0; i < 5; i++) {
            allelement[i] = i;
        }
        // String[] element77 = { "0", "1", "2", "3", "4" };
        element1 = new JComboBox<Integer>(allelement);
        element1.setPreferredSize(new Dimension(60, 20));
        element1.setOpaque(true);
        element1.setBackground(Color.white);
        element2 = new JComboBox<Integer>(allelement);
        element2.setPreferredSize(new Dimension(60, 20));
        element3 = new JComboBox<Integer>(allelement);
        element3.setPreferredSize(new Dimension(60, 20));
        element4 = new JComboBox<Integer>(allelement);
        element4.setPreferredSize(new Dimension(60, 20));
        setElementComboNull();

        bananaLabel = new JLabel("Banana", SwingConstants.CENTER);
        bananaLabel.setBackground(Color.WHITE);
        bananaLabel.setOpaque(true);
        bananaLabel.setPreferredSize(new Dimension(60, 20));

        appleLabel = new JLabel("Apple", SwingConstants.CENTER);
        appleLabel.setBackground(Color.WHITE);
        appleLabel.setOpaque(true);
        appleLabel.setPreferredSize(new Dimension(60, 20));

        orangeLabel = new JLabel("Orange", SwingConstants.CENTER);
        orangeLabel.setBackground(Color.WHITE);
        orangeLabel.setOpaque(true);
        orangeLabel.setPreferredSize(new Dimension(60, 20));

        melonLabel = new JLabel("Melon", SwingConstants.CENTER);
        melonLabel.setBackground(Color.WHITE);
        melonLabel.setOpaque(true);
        melonLabel.setPreferredSize(new Dimension(60, 20));

        bananaNum = new JLabel("0", SwingConstants.CENTER);
        bananaNum.setBackground(Color.WHITE);
        bananaNum.setOpaque(true);
        bananaNum.setPreferredSize(new Dimension(60, 20));

        appleNum = new JLabel("0", SwingConstants.CENTER);
        appleNum.setBackground(Color.WHITE);
        appleNum.setOpaque(true);
        appleNum.setPreferredSize(new Dimension(60, 20));

        orangeNum = new JLabel("0", SwingConstants.CENTER);
        orangeNum.setBackground(Color.WHITE);
        orangeNum.setOpaque(true);
        orangeNum.setPreferredSize(new Dimension(60, 20));

        melonNum = new JLabel("0", SwingConstants.CENTER);
        melonNum.setBackground(Color.WHITE);
        melonNum.setOpaque(true);
        melonNum.setPreferredSize(new Dimension(60, 20));

        coinLabel = new JLabel("0", SwingConstants.CENTER);
        coinLabel.setBackground(Color.YELLOW);
        coinLabel.setOpaque(true);
        coinLabel.setPreferredSize(new Dimension(100, 20));

        dailyBtn = new JButton("00:00");
        dailyBtn.setPreferredSize(new Dimension(100, 20));

        testBtn = new JButton("test");
        // panel add component...................//
        leftPanel.add(weaponCombo);
        leftPanel.add(pane);
        leftPanel.add(enhancementBar);
        leftPanel.add(stoneNumLabel);
        leftPanel.add(stoneClockLabel);
        leftPanel.add(enhanceBtn);
        leftPanel.add(descriptionLabel);

        middlePanel.add(alchemyImgLabel);
        middlePanel.add(alchemyBar);

        downPanel.add(element1);
        downPanel.add(element2);
        downPanel.add(element3);
        downPanel.add(element4);

        elementPanel.add(bananaLabel);
        elementPanel.add(appleLabel);
        elementPanel.add(orangeLabel);
        elementPanel.add(melonLabel);

        elementNumPanel.add(bananaNum);
        elementNumPanel.add(appleNum);
        elementNumPanel.add(orangeNum);
        elementNumPanel.add(melonNum);

        rightPanel.add(coinLabel);
        rightPanel.add(dailyBtn);
        rightPanel.add(testBtn);
        // mainFrame add panel................//
        mainFrame.add(leftPanel);
        mainFrame.add(rightPanel);
        mainFrame.add(middlePanel);
        mainFrame.add(downPanel);
        mainFrame.add(elementPanel);
        mainFrame.add(elementNumPanel);
        mainFrame.setSize(700, 550);
        mainFrame.setVisible(true);
    }

    public void createControls() {
        saveItem = new JMenuItem("Save & Quit");
        menu.add(saveItem);
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.stop();
                System.exit(0);
            }
        });
        element1.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                element1.setBackground(Color.white);
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });

        element1.addActionListener(this);
        element2.addActionListener(this);
        element3.addActionListener(this);
        element4.addActionListener(this);
        enhanceBtn.addActionListener(this);
        dailyBtn.addActionListener(this);
        testBtn.addActionListener(this);
        weaponCombo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enhanceBtn) {
            if (controller.coinchecker(1000)) {
                if (controller.stoneChecker(1)) {
                    controller.minusCoin(1000);
                    controller.minusStone(1);
                    controller.enhanceStart();
                    controller.enhanceThread(enhancementBar);
                    enhancementBar.setString("強化中...");
                } else {
                    showDialong("No stone!");
                }
            } else {
                showDialong("No coin!");
            }
        } else if (e.getSource() == dailyBtn) {
            if (model.isDailyfinish()) {
                controller.getdailyBouns();
                enableDailybtn(false);
                controller.dailystart();
            }
        } else if (e.getSource() == testBtn) {
            if (rightSet()) {
                controller.alchemyMinus(getBananaCombo(), getAppleCombo(), getOrangeCombo(), getMelonCombo());
                controller.alchemyThread(alchemyBar);
                alchemyBar.setString("煉金中...");
            }
        } else if (e.getSource() == element1) {
            if (!controller.bananChecker(getBananaCombo())) {
                element1.setSelectedItem(null);
                showDialong("Can't insert more than u have");
            }
        } else if (e.getSource() == element2) {
            if (!controller.appleChecker(getAppleCombo())) {
                element2.setSelectedItem(null);
                showDialong("Can't insert more than u have");
            }
        } else if (e.getSource() == element3) {
            if (!controller.orangeChecker(getOrangeCombo())) {
                element3.setSelectedItem(null);
                showDialong("Can't insert more than u have");
            }
        } else if (e.getSource() == element4) {
            if (!controller.melonChecker(getMelonCombo())) {
                element4.setSelectedItem(null);
                showDialong("Can't insert more than u have");
            }
        } else if (e.getSource() == weaponCombo) {
            model.setCurrentLevel(((Weapon) weaponCombo.getSelectedItem()).getLevel());
            String level = ((Weapon) weaponCombo.getSelectedItem()).getLeveltext();
            weaponLevelLabel.setText(level);
        }

    }

    @Override
    public void updateCoin() {
        coinLabel.setText(String.valueOf(model.getCoin()));
    }

    @Override
    public void updateStoneClock() {
        stoneClockLabel.setText(model.getStoneMinute() + ":" + model.getStoneSecond());
    }

    @Override
    public void updateDailyClock() {
        if (!model.isDailyfinish()) {
            dailyBtn.setText(model.getDailyMinute() + ":" + model.getDailySecond());
            enableDailybtn(false);
        } else {
            dailyBtn.setText("領取獎勵");
            enableDailybtn(true);
        }

    }

    @Override
    public void updateStone() {
        stoneNumLabel.setText(String.valueOf(model.getStone()));
    }

    @Override
    public void enhanceProgressEnd() {
        if (controller.isEnhanceRunning() == false) {
            controller.enhanceEnd();
            String name = ((Weapon) weaponCombo.getSelectedItem()).getName();
            switch (name) {
            case "Sword":
                model.setSwordLevel(model.getCurrentLevel());
                break;
            case "Bow":
                model.setBowLevel(model.getCurrentLevel());
                break;
            }
            ((Weapon) weaponCombo.getSelectedItem()).setlevel(model.getCurrentLevel());

            String level = ((Weapon) weaponCombo.getSelectedItem()).getLeveltext();
            weaponLevelLabel.setText(level);

        }
    }

    @Override
    public void alchemyProgressEnd() {
        if (controller.isAlchemyRunning() == false) {
            System.out.println("煉金結束");
        }
    }

    public void enableEnhanceBtn(boolean b) {
        enhanceBtn.setEnabled(b);
    }

    public void visibleProgressbar(boolean b) {
        enhancementBar.setVisible(b);
    }

    public void enableDailybtn(boolean b) {
        dailyBtn.setEnabled(b);
    }

    public void setdescription(String msg) {
        descriptionLabel.setText(msg);
    }

    public void setElementComboNull() {
        element1.setSelectedItem(null);
        element2.setSelectedItem(null);
        element3.setSelectedItem(null);
        element4.setSelectedItem(null);
    }

    public int getBananaCombo() {
        return (int) element1.getSelectedItem();
    }

    public int getAppleCombo() {
        return (int) element2.getSelectedItem();
    }

    public int getOrangeCombo() {
        return (int) element3.getSelectedItem();
    }

    public int getMelonCombo() {
        return (int) element4.getSelectedItem();
    }

    @Override
    public void updateBanana(int num) {
        bananaNum.setText(String.valueOf(num));

    }

    @Override
    public void updateApple() {
        appleNum.setText(String.valueOf(model.getBanana()));

    }

    @Override
    public void updateOrange() {
        orangeNum.setText(String.valueOf(model.getOrange()));

    }

    @Override
    public void updateMelon() {
        melonNum.setText(String.valueOf(model.getMelon()));

    }

    public void showDialong(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public boolean rightSet() {
        if (element1.getSelectedItem() != null) {
            if (element2.getSelectedItem() != null) {
                if (element3.getSelectedItem() != null) {
                    if (element4.getSelectedItem() != null) {
                        return true;
                    } else {

                    }
                } else {

                }
            } else {

            }
        } else {
            element1.setOpaque(true);
            element1.setBackground(Color.RED);
        }
        showDialong("Please insert element number for Alchemy");
        return false;
    }

}
