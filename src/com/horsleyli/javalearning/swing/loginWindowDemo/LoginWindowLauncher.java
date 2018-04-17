package com.horsleyli.javalearning.swing.loginWindowDemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginWindowLauncher {
    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.createLoginWindow();
        loginWindow.setVisible(true);
    }

    private static Logger logger = LogManager.getLogger(LoginWindow.class);

    public static void putLog(String message) {
        logger.info(message);
    }
}

class LoginWindow extends JFrame {
    public void createLoginWindow() {
        createFrame();
        painWindow();
    }

    private void createFrame() {
        // 创建窗口框架
        setTitle("登陆");
        setLayout(null);
        setSize(300, 180);
        setLocation(700, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // 创建窗口组件
    private Container loginWindowContainer;
    private JLabel accountLabel, passwordLabel;
    private JTextField accountTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private PasswordOperator passwordOperator = this.new PasswordOperator();

    // 声明事件监听者
    private LoginButtonListener loginButtonListener = this.new LoginButtonListener();
    private AccountAndPasswordTextFileActionListener accountAndPasswordTextFileActionListener = this.new AccountAndPasswordTextFileActionListener();

    private void painWindow() {
        // 绘制窗口组件
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
        // 绘制Label组件
        accountLabel = new JLabel("账号: ");
        accountLabel.setSize(50, 30);
        accountLabel.setLocation(30, 10);

        passwordLabel = new JLabel("密码: ");
        passwordLabel.setSize(50, 30);
        passwordLabel.setLocation(30, 50);
    }

    private void setInputField() {
        // 绘制输入框组件
        accountTextField = new JTextField();
        accountTextField.setSize(140, 28);
        accountTextField.setLocation(90, 14);
        accountTextField.addActionListener(accountAndPasswordTextFileActionListener);
        passwordField = new JPasswordField();
        passwordField.setSize(140, 28);
        passwordField.setLocation(90, 54);
        passwordField.addActionListener(accountAndPasswordTextFileActionListener);
    }

    private void setButton() {
        // 绘制按钮组件
        loginButton = new JButton("登陆");
        loginButton.setSize(70, 30);
        loginButton.setLocation(105, 90);
        this.getRootPane().setDefaultButton(loginButton);
        loginButton.addActionListener(loginButtonListener);
        loginButton.addKeyListener(loginButtonListener);
    }

    private void addComponents() {
        // 向窗口添加组件
        loginWindowContainer.add(accountLabel);
        loginWindowContainer.add(passwordLabel);
        loginWindowContainer.add(accountTextField);
        loginWindowContainer.add(passwordField);
        loginWindowContainer.add(loginButton);
    }

    private class PasswordOperator {
        //  负责密码操作的内部类
        private String getPassword() {
            StringBuilder password = new StringBuilder();
            for (char c : passwordField.getPassword()) {
                password.append(c);
            }
            return password.toString();
        }

        private void login() {
            if (checkAccountAndPassword()) {
                passwordCorrect();
            } else {
                passwordWrong();
            }
        }

        private boolean checkAccountAndPassword() {
            // 检查密码是否正确
            return "123".equals(accountTextField.getText()) && "123".equals(getPassword());
        }

        private void passwordCorrect() {
            // 当密码正确时执行的操作
            JOptionPane.showMessageDialog(loginButton, "登陆成功！", "登陆成功", JOptionPane.INFORMATION_MESSAGE);
            LoginWindowLauncher.putLog("登陆成功！");
            accountTextField.setText("");
            passwordField.setText("");
            accountTextField.requestFocusInWindow();
        }

        private void passwordWrong() {
            // 当密码错误时执行的操作
            JOptionPane.showMessageDialog(loginButton, "登陆失败，账号或密码错误！", "登陆失败", JOptionPane.INFORMATION_MESSAGE);
            LoginWindowLauncher.putLog("登陆失败！\t" + "账号: \"" + accountTextField.getText() + "\"    密码: \"" + getPassword() + "\"");
            accountTextField.setText("");
            passwordField.setText("");
            accountTextField.requestFocusInWindow();
        }
    }

    private class LoginButtonListener implements ActionListener, KeyListener {
        // 负责登陆按钮监听事件的内部类
        @Override
        public void actionPerformed(ActionEvent e) {
            passwordOperator.login();
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // 击键事件
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // 按键按下
            if (e.getKeyCode() == KeyEvent.VK_E) {
                passwordOperator.login();
                accountTextField.requestFocus();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // 按键松开
        }
    }

    private class AccountAndPasswordTextFileActionListener implements ActionListener {
        // 负责处理输入框回车事件的内部类
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(accountTextField)) {
                passwordField.requestFocus();
            } else if (e.getSource().equals(passwordField)) {
                loginButton.requestFocus();
            }
        }
    }
}