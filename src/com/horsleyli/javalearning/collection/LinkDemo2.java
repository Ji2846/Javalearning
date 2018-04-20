package com.horsleyli.javalearning.collection;

/**
 * 开发一个具体可用的链表（增删查改等基础功能）:
 *
 * Node负责的所有节点数据的保存及节点关系的匹配，所以理论上Node类是不能单独使用的
 * 所以需要修改结构，让Node类只能被Link类操作，
 * 这时候使用内部类明显是一个最好的选择。
 * 内部类可以用private定义，这样一来：
 * 一、Nodeiu不能被其它类给修改
 * 二、内部类还可以很方便的与外部类进行交互
 **/

/* =================================== */

/**
 * ***********************************
 * 链表常用方法：
 * public void add(Arg arg)         // 增加数据；
 * public int size()                // 取得链表中保存元素的个数；
 * public boolean isEmpty()         // 判断链表是否为空；
 * public boolean contains(Arg arg) // 判断链表是否包含此数据；
 * public Arg get(int index)        // 根据索引取得数据；
 **/

public class LinkDemo2 {
    public static void main(String[] args) {
        Link2 link = new Link2();   // 创建一个链表
        link.add("root");   // 给链表添加元素
        link.add("1");
        link.add("2");
        link.add("3");
        link.add(null); // 尝试添加null，不过并不会成功（我是这么设定的XD）
        link.add("end");

        System.out.println("link.getSize(): " + link.getSize());                // 获取链表中保存的数据量
        System.out.println("link.isEmpty(): " + link.isEmpty());                // 判断链表是否为空
        System.out.println("ling.contains(\"2\"): " + link.contains("2"));      // 判断链表中是否包含此数据
        System.out.println("ling.contains(\"4\"): " + link.contains("4"));
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

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                return this.data.equals(((Node) obj).data);
            } else {
                return false;
            }
        }

        private boolean containsNode(String data) {
            if (this.data.equals(data)) {   // 先判断当前data是否相等
                return true;    //当满足时就不再继续判断了，直接返回true；
            } else {    // 若当前节点不满足则查询下一个节点
                if (this.next != null) {    // 要是有后续节点
                    return this.next.containsNode(data);    // 就继续查询
                } else {
                    return false;   // 否则就直接返回false（后面没数据继续给你查询了）
                }
            }
        }
    }
    /* ===================== 以上为内部类 ===================== */

    private Node root;           // 根节点
    private int size = 0;                 // 保存的元素个数

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

        this.size++;   // 每一次保存成功后size + 1;
    }

    public int getSize() {
        return this.size;   // 返回size
    }

    public boolean isEmpty() {
        /*
         * 两种判断方法：
         * * 一、root是否为null；
         * * 二、size是否为0；
         * 这里采取的是第二种（参照String类）
         * */
        return size == 0;
    }

    public boolean contains(String data) {    // 用data进行比较
        /*
         * 通过比较节点的data是否相等以进行判断两节点是否相等
         *
         * 如果不是通过String进行比较而是通过自定义对象进行比较，
         * 则可以通过定义一个对象比较的方法(例如compare()方法)
         * */
        if (data == null || this.root == null) {
            return false;   // 如果比较和被比较的数据为空，则直接返回false
        } else {
            return root.containsNode(data);
        }
    }
}
