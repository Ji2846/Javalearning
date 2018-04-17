package com.horsleyli.javalearning.algorithm;

import java.math.*;
import java.util.*;

public class AlgorithmDemo
{
    public static void main(String[] args)
    {
        AlgorithmDemo a = new AlgorithmDemo();
        System.out.println(a.euclideanAlgorithm(6105, 8251));
        System.out.println(a.euclideanAlgorithm(957, 693));
    }

    public int euclideanAlgorithm(int a, int b)
    {
        // 欧几里德算法
        int r = -1;
        if (b > a)
        {
            // 判断a b大小,保证a>b
            int t = b;
            b = a;
            a = t;
        }

        while (r != 0)
        {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
