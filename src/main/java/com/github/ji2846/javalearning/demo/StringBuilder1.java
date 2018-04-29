package com.github.ji2846.javalearning.demo;

/**
 * StringBuilder:
 * jdk1.5以后出现,和StringBuffer用法一样.
 *  StringBuffer是线程同步的.
 * StringBuilder是线程不同步的.
 * 一般建议选择StringBuilder,速度快.
 *
 **/

public class StringBuilder1 {
    public static void main(String[] args) {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello").append(' ').append("World").append('!');
        str = stringBuilder.toString();
        System.out.println(str);
    }
}
