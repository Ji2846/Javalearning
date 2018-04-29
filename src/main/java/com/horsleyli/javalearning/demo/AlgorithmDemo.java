package com.horsleyli.javalearning.demo;

public class AlgorithmDemo {
    public static void main(String[] args) {
        AlgorithmDemo a = new AlgorithmDemo();
        a.euclideanAlgorithm(415, 6460);
        a.euclideanAlgorithm(48484, 84);
    }

    public void euclideanAlgorithm(int a, int b) {
        // 欧几里德算法，输出两个数的最大公约数
        int na = a;
        int nb = b;
        int r = -1;
        if (b > a) {
            // 判断a、b的大小，保证a>b
            int t = b;
            b = a;
            a = t;
        }
        while (r != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        System.out.println(na + "与" + nb + "的最大公约数是: " + a);
    }
}
