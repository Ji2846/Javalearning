package com.horsleyli.javalearning.exceptions;

public class MyExceptionDemo1 {
    public static void main(String[] args) {
        MyException1 m1 = new MyException1("HAHAHA");
        m1.printStackTrace();
        System.out.println(m1);

        try {
            throwMyException1();
        }catch (MyException1 mE1) {
            System.out.println("catch");
            mE1.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }

    private static void throwMyException1() throws MyException1 {
        throw new MyException1();
    }
}

class MyException1 extends Exception {
    private String message;

    MyException1() {
        super("MyException");
    }

    MyException1(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public String toString() {
        return "MyException1: " + message;
    }
}