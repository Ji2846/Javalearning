package com.horsleyli.javalearning.exceptions;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        try {
            int i = 44/0;
        }catch (ArithmeticException aE1){
            System.out.println("抛出异常: " + aE1.getMessage());
            System.out.println("被除数不能为零");

            try {
                throwException1(46);
            }catch (Exception e1){
                e1.printStackTrace();
                System.out.println(e1.getMessage());
            }

            try {
                throwException1(0);
            }catch (Exception e1){
                e1.printStackTrace();
                System.out.println(e1.getMessage());
            }

            try {
                throwException1(58);
            }catch (Exception e1){
                e1.printStackTrace();
                System.out.println(e1.getMessage());
            }finally {
                System.out.println("this finally");
            }
        }
    }

    private static void throwException1(int i) throws Exception {
        if (i != 0){
            throw new Exception("错误: 传入数据必须是0，而你传入的是" + i);
        }else{
            System.out.println("正常: i = " + i);
        }
    }
}
