package com.horsleyli.javalearning.io.encryptDemo;

import java.io.File;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow("输入文本并加密保存", new File("K:\\Java_Projects\\JavaLearning\\TestFiles\\EncryptedText.txt"));
        mainWindow.createWindow();
    }
}

class MainWindow extends JFrame{
    private File targetFile;
    public MainWindow(String title, File targetFile) {
        super(title);
        this.targetFile = targetFile;
    }

    public void createWindow() {
        drawFrame();
        setVisible(true);
    }

    private void drawFrame() {
        setLayout(null);
        setBounds(600, 400, 400, 300);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
