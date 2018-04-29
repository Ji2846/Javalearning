package com.github.ji2846.javalearning.thread;

public class SimpleTicketSellerDemo1 {
    final static int TICKETS = 300;

    public static void main(String[] args) {
        Thread t1 = new Thread(new TicketSeller1("甲"));
        Thread t2 = new Thread(new TicketSeller1("乙"));
        Thread t3 = new Thread(new TicketSeller1("丙"));

        System.out.println("总票数: " + TICKETS);
        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketSeller1 implements Runnable {
    private String name;

    TicketSeller1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        sellTickets();
        System.out.println(name + ": 一共卖出了" + soldTickets + "张票");
    }

    private int soldTickets = 0;
    private static int tickets = SimpleTicketSellerDemo1.TICKETS;

    private boolean checkTicketCount() {
        return tickets > 0;
    }

    private void sellTickets() {
        while (checkTicketCount()) {
            tickets--;
            System.out.println(name + ": 卖出了1张票，还剩下" + tickets + "张");
            soldTickets++;
        }
    }
}