package com.horsleyli.javalearning.collection;

/*
 * 开发一个具体可用的链表（增减改等功能）
 *
 * Node负责的所有节点数据的保存及节点关系的匹配，所以理论上Node类是不能单独使用的
 * 所以需要修改结构，让Node类只能被Link类操作，
 * 这时候使用内部类明显是一个最好的选择。
 * 内部类可以用private定义，这样一来：
 * * 一、Nodeiu不能被其它类给修改
 * * 二、内部类还可以很方便的与外部类进行交互
 *
 ***************************************
 * 链表常用方法：
 * public void add(Arg arg)    增加数据；
 * public int size()           取得链表中保存元素的个数；
 * */

public class LinkDemo2 {
    public static void main(String[] args) {
        Link2 link = new Link2();   // 创建链表对象
        link.add("root");   // 给链表添加元素
        link.add("1");
        link.add("2");
        link.add("3");
        link.add(null); // null并不会被保存（我是这么设定的XD）
        link.add("end");

        System.out.println(link.getSize()); // 获取链表中保存的数据量
    }
}

class Link2 {    // 链表类，外部能看到的只有这一个类
    /* ===================== 以下为内部类 ===================== */
    private class Node {    // 节点类，之所以定义在内部，主要是让其为链表类服务
        private String data;
        private Node next;

        private Node(String data) {
            this.data = data;
        }

        private void addNode(Node newNode) {
            if (this.next == null) {    // 判断下一个节点是否为空（是否是链表尾）
                this.next = newNode;    // 如果是则在后面增加新节点
            } else {    // 否则就继续判断下一个是不是链表尾
                this.next.addNode(newNode);
            }
        }

    }
    /* ===================== 以上为内部类 ===================== */

    private Node root;    // 根节点
    private int size = 0;  // 保存的元素个数

    public void add(String data) {    // 添加节点
        if (data == null) {
            return; // 是否允许添加null（这里是不允许添加）
        }
        Node newNode = new Node(data);    // 要保存的数据
        if (this.root == null) {
            this.root = newNode;    // 保存根节点
        } else {    //如果根节点存在，则保存其它节点（交给Node类进行保存）
            this.root.addNode(newNode);
        }

        this.size++;   // 每一次保存成功后count + 1;
    }

    public int getSize() {
        return this.size;
    }
}
