package com.github.ji2846.javalearning.thread;

public class ThreadDemo1 extends Thread {
    @Override
    public void run() {
        // TODO: Implement this method
        for (int i = 0; i < 10; i++) {
            System.out.println(this.toString() + " is running...");
        }
    }

    private String name;

    ThreadDemo1(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        // TODO: Implement this method
        return "Thread-" + this.name;
    }

    public static void main(String[] args) {
        ThreadDemo1 t1 = new ThreadDemo1("t1");
        ThreadDemo1 t2 = new ThreadDemo1("t2");
        ThreadDemo1 t3 = new ThreadDemo1("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
