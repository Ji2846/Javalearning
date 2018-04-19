package com.horsleyli.javalearning.collection;

public class LinkDemo {
    // 链表
    public static void main(String[] args) {
        Node head = new Node("链表头");
        Node n1 = new Node("1号格");
        Node n2 = new Node("2号格");
        Node n3 = new Node("3号格");
        Node end = new Node("链表尾");

        head.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(end);

        print(head);
    }

    public static void print(Node current) {
        // 递归操作
        while (current != null) {
            // 当current不为空时，输出数据，然后将current设为next
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}

class Node {
    private String data;
    private Node next;

    Node(String data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public String getData() {
        return data;
    }
}
