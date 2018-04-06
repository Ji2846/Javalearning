package com.horsleyli.javalearning.swing.loginWindowDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
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