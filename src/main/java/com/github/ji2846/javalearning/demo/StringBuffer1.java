package com.github.ji2846.javalearning.demo;

/**
 * StringBuffer: 字符串缓冲区.
 * 字符的容器.
 *
 * 特点:
 * 1.长度可以变化.
 * 2.可以用指定方法对内容进行修改.
 * 3.容器一般都会具有对其中的元素进行操作的方法.
 *
 *
 * //创建一个字符串对象的过程:                  // String str = "a" + 0 + 'b';
 * //1.创建一个字符串缓冲容器(StringBuffer).    // StringBuffer s = new StringBuffer();
 * //2.将组成字符串的元素先用缓冲容器存储起来.    // s.append("a").append(4).append('b');
 * //3.将缓冲区的数据转换成字符串.               // s.toString();
 *
 **/

public class StringBuffer1 {
    public static void main(String[] args) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Hello").append(' ').append("Hello").append('!');
        str = stringBuffer.toString();
        System.out.println(str);
    }
}
