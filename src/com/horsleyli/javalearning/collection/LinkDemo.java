package com.horsleyli.javalearning.collection;

public class LinkDemo {
    // 链表
    public static void main(String[] args) {
        go();
    }

    private static void go() {
        Node root = new Node("链表头");
        Node n1 = new Node("1号格");
        Node n2 = new Node("2号格");
        Node n3 = new Node("3号格");
        Node end = new Node("链表尾");

        Link link = new Link();
        link.add(root);
        link.add(n1);
        link.add(n2);
        link.add(n3);
        link.add(end);

        link.print();
    }
}

class Node {
    private String data;
    private Node next;

    Node(String data) {
        this.data = data;
    }

    void addNode(Node newNode) {
        if (this.next == null) {
            this.next = newNode;
        } else {
            this.next.addNode(newNode);
        }
    }

    void printNode() {
        System.out.println(this.data);
        if (this.next != null) {
            this.next.printNode();
        }
    }
}

class Link {    // 负责元素操作的类
    private Node root;    // 根节点

    // 添加元素
    void add(Node newNode) {
        if (root == null) {
            this.root = newNode;
        } else {
            root.addNode(newNode);
        }
    }

    // 输出数据
    void print() {
        if (this.root != null) {
            this.root.printNode();
        }
    }
}