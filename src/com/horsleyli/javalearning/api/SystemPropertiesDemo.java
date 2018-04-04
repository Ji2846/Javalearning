package com.horsleyli.javalearning.api;

import java.util.Properties;
import java.util.Set;

/**
 * java.lang.System类是一个final类
 * 不能被实例化.
 * 里面定义的方法都是static方法.
 * <p>
 * out: 标准输出流,默认是系统屏幕.
 * in: 标准输入流,默认是键盘.
 * err: 标准错误输出流.
 **/

public class SystemPropertiesDemo {
    public static void main(String[] args) {
        Properties prop = System.getProperties();
        Set<String> keySet = prop.stringPropertyNames();
        for (String key : keySet) {
            String value = prop.getProperty(key);
            System.out.println(key + ": " + value);
        }
        System.out.println("java.vm.name: " + prop.getProperty("java.vm.name"));
        System.out.println("java.version: " + prop.getProperty("java.version"));
        System.out.println("sun.boot.library.path: " + prop.getProperty("sun.boot.library.path"));
        System.out.println("user.language: " + prop.getProperty("user.language"));
        System.out.println("sun.desktop: " + prop.getProperty("sun.desktop"));
        System.out.println("os.name: " + prop.getProperty("os.name"));
        System.out.println("sun.cpu.isalist: " + prop.getProperty("sun.cpu.isalist"));
    }
}
