package com.horsleyli.javalearning.io.encryptDemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        File targetFile = new File("K:\\Java_Projects\\JavaLearning\\TestFiles\\EncryptedText.txt");
        MainWindow mainWindow = new MainWindow("输入文本并加密保存", targetFile);
        mainWindow.createWindow();
    }
}

class MainWindow extends JFrame {
    private File targetFile;

    MainWindow(String title, File targetFile) {
        super(title);
        this.targetFile = targetFile;
    }

    void createWindow() {
        // 绘制窗口
        drawFrame();
        setButtons();
        setTextAreas();
        setScrollPanes();
        addComponents();
        setVisible(true);
    }

    private void drawFrame() {
        // 绘制Frame
        setLayout(null);
        setBounds(600, 200, 500, 600);
        setResizable(false);
        setBackground(new Color(0xF2F2F2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private Container contentPane = getContentPane();

    private void addComponents() {
        // 给窗口添加组件
        contentPane.add(inputTextAreaScrollPane);
        contentPane.add(writeButton);
        contentPane.add(readButton);
        contentPane.add(readTextAreaScrollPane);
    }

    private JTextArea inputTextArea, readTextArea;
    private JButton writeButton, readButton;
    private JScrollPane inputTextAreaScrollPane, readTextAreaScrollPane;
    private Font yaHeiFont = new Font("微软雅黑", Font.PLAIN, 14);

    private void setButtons() {
        Color buttonColor = new Color(0xE3E3E3);
        // 设置Button
        writeButton = new JButton("写入并加密文本");
        writeButton.setFont(yaHeiFont);
        writeButton.setBackground(buttonColor);
        writeButton.setSize(150, 30);
        writeButton.setLocation(50, 285);
        writeButton.addActionListener(this.new WriteButtonActionListener());

        readButton = new JButton("从文件中读取数据");
        readButton.setFont(yaHeiFont);
        readButton.setBackground(buttonColor);
        readButton.setSize(150, 30);
        readButton.setLocation(300, 285);
        readButton.addActionListener(this.new ReadButtonActionListener());
    }

    private void setTextAreas() {
        // 设置TextArea
        inputTextArea = new JTextArea();

        readTextArea = new JTextArea();
        readTextArea.setEditable(false);
    }

    private void setScrollPanes() {
        // 设置TextArea的ScrollPane
        inputTextAreaScrollPane = new JScrollPane(inputTextArea);
        inputTextAreaScrollPane.setSize(496, 280);
        inputTextAreaScrollPane.setLocation(0, 0);
        inputTextAreaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        inputTextAreaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        readTextAreaScrollPane = new JScrollPane(readTextArea);
        readTextAreaScrollPane.setSize(496, 254);
        readTextAreaScrollPane.setLocation(0, 320);
        readTextAreaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        readTextAreaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    private class WriteButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (inputTextArea.getText().length() != 0) {
                writeData();
            } else {
                JOptionPane.showMessageDialog(writeButton, "输入的数据不能为空", "请输入数据", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        private void writeData() {
            // 写入数据
            String data = inputTextArea.getText();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile, true));
                writer.write(DataProcessor.encrypt(data));
                writer.flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            inputTextArea.setText("");
            JOptionPane.showMessageDialog(writeButton, "数据已成功写入", "数据写入", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class ReadButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (targetFile.exists()) {
                readData();
            } else {
                JOptionPane.showMessageDialog(readButton, "错误: 文件不存在", "尝试读写文件时出现了错误", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void readData() {
            // 读取数据
            String readData;
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(targetFile));
                while ((readData = reader.readLine()) != null) {
                    text.append(DataProcessor.decrypt(readData));
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            readTextArea.setText(text.toString());
        }
    }
}
