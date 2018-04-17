package com.horsleyli.javalearning.demo.loginWindowDemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginWindow extends JFrame {
    public void createLoginWindow() {
        createFrame();
        painWindow();
    }

    private void createFrame() {
        setTitle("登陆");
        setLayout(null);
        setSize(300, 180);
        setLocation(700, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private Container loginWindowContainer;
    private JLabel accountLabel, passwordLabel;
    private JTextField accountTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private void painWindow() {
        setContainer();
        setLabel();
        setButton();
        setInputField();
        addComponents();
    }

    private void setContainer() {
        loginWindowContainer = this.getContentPane();
    }

    private void setLabel() {
        accountLabel = new JLabel("账号: ");
        accountLabel.setSize(50, 30);
        accountLabel.setLocation(30, 10);

        passwordLabel = new JLabel("密码: ");
        passwordLabel.setSize(50, 30);
        passwordLabel.setLocation(30, 50);
    }

    private void setInputField() {
        accountTextField = new JTextField();
        accountTextField.setSize(140, 28);
        accountTextField.setLocation(90, 14);
        accountTextField.addActionListener(enterKeyListener(accountTextField));
        passwordField = new JPasswordField();
        passwordField.setSize(140, 28);
        passwordField.setLocation(90, 54);
        passwordField.addActionListener(enterKeyListener(passwordField));
    }

    private void setButton() {
        loginButton = new JButton("登陆");
        loginButton.setSize(70, 30);
        loginButton.setLocation(105, 90);
        loginButton.addActionListener(loginButtonListener());
        loginButton.addKeyListener(loginButtonEnterKeyListener());
    }

    private void addComponents() {
        loginWindowContainer.add(accountLabel);
        loginWindowContainer.add(passwordLabel);
        loginWindowContainer.add(accountTextField);
        loginWindowContainer.add(passwordField);
        loginWindowContainer.add(loginButton);
    }

    private String getPassword() {
        StringBuilder password = new StringBuilder();
        for (char c : passwordField.getPassword()) {
            password.append(c);
        }
        return password.toString();
    }

    private boolean checkAccountAndPassword() {
        return "123".equals(accountTextField.getText()) && "123".equals(getPassword());
    }

    private void passwordCorrect() {
        LoginWindowLauncher.putLog("登陆成功！");
        JOptionPane.showMessageDialog(loginButton, "登陆成功！", "登陆成功", JOptionPane.INFORMATION_MESSAGE);
        accountTextField.setText("");
        passwordField.setText("");
        accountTextField.requestFocusInWindow();
    }

    private void passwordWrong() {
        LoginWindowLauncher.putLog("登陆失败！\t" + "账号: \"" + accountTextField.getText() + "\"    密码: \"" + getPassword() + "\"");
        JOptionPane.showMessageDialog(loginButton, "登陆失败，账号或密码错误！", "登陆失败", JOptionPane.INFORMATION_MESSAGE);
        accountTextField.setText("");
        passwordField.setText("");
        accountTextField.requestFocusInWindow();
    }

    private ActionListener loginButtonListener() {
        return e -> {
            if (checkAccountAndPassword())
                passwordCorrect();
            else
                passwordWrong();
        };
    }

    private ActionListener enterKeyListener(Component component) {
        return e -> {
            if (accountTextField.equals(component))
                passwordField.requestFocusInWindow();
            if (passwordField.equals(component)) {
                loginButton.requestFocusInWindow();
            }
        };
    }

    private KeyListener loginButtonEnterKeyListener() {
        return new myKeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (checkAccountAndPassword()) {
                        passwordCorrect();
                    } else {
                        passwordWrong();
                    }
                }
            }
        };
    }
}

class myKeyListener implements KeyListener{
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
}