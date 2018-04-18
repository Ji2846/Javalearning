package com.horsleyli.javalearning.io.encryptDemo;

class DataProcessor {
    static String encrypt(String unencryptedData) {
        // 加密数据
        char[] dataArray = unencryptedData.toCharArray();// 准备进行加密的数据
        StringBuilder encryptedData = new StringBuilder();// 存储加密好的数据
        int temp;
        for (char c : dataArray) {
            // 进行加密
            temp = c;
            temp = temp + 28;
            encryptedData.append((char) temp);
        }
        return encryptedData.toString();
    }

    static String decrypt(String encryptedData) {
        // 解密数据
        char[] dataArray = encryptedData.toCharArray();// 准备进行解密的数据
        StringBuilder decryptedData = new StringBuilder();// 用来存储解密好的数据
        int temp;
        for (char c : dataArray) {
            // 进行解密
            temp = c;
            temp = temp - 28;
            decryptedData.append((char) temp);
        }
        return decryptedData.toString();
    }
}