package GameProject.Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.logging.Logger;

public class ViewLogin extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(ViewLogin.class.getName());
    ControllerMainInterface controller;
    ModelInterface model;
    JFrame loginFrame;
    JPanel mainPanel;
    JLabel IDlabel;
    JTextField IDtextField;
    JButton loginBtn;
    String password;

    public ViewLogin(ControllerMainInterface controller, ModelInterface model) {
        this.controller = controller;
        this.model = model;
    }

    public void createLoginView() {
        loginFrame = new JFrame("login");
        loginFrame.setResizable(false);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setLayout(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBounds(0, 40, 200, 30);

        IDlabel = new JLabel("UserID");
        IDlabel.setPreferredSize(new Dimension(50, 20));

        IDtextField = new JTextField();
        IDtextField.setPreferredSize(new Dimension(100, 20));
        IDtextField.addKeyListener(this);

        // loginBtn = new JButton("login");

        mainPanel.add(IDlabel);
        mainPanel.add(IDtextField);
        // mainPanel.add(loginBtn);

        loginFrame.getContentPane().add(mainPanel);
        // loginFrame.pack();
        loginFrame.setSize(240, 150);
        loginFrame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            logger.info("User press enter");
            model.checkID();
            if (IDtextField.getText().equals(model.getpassword())) {
                controller.login();
            } else {
                JOptionPane.showMessageDialog(null, "Uncorrected UserID", "Login error", 0);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void enableLoginFrame(Boolean b) {
        IDtextField.setText("");
        loginFrame.setVisible(b);
    }
}
