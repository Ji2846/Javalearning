package com.horsleyli.javalearning.collection;

/*
* 可以通过此Demo发现链表的基本操作特点：
* * 客户端代码不用去关注具体节点及引用关系的细节，自关注于其提供的功能
* * Link类的主要功能是控制Node类对象的产生和根节点
* * Node类主要负责数据的保存及其引用关系的分配.
* */

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

        Link1 link2 = new Link1();
        link2.add(root);
        link2.add(n1);
        link2.add(n2);
        link2.add(n3);
        link2.add(end);

        link2.print();
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

// 负责元素操作的类
class Link1 {
    private Node root;      // 根节点

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