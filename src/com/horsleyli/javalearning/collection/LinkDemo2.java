package com.horsleyli.javalearning.collection;

/**
 * 开发一个具体可用的链表（增删查改取等基础功能）:
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
 * public void add(Arg arg)             // 增加数据；
 * public int size()                    // 取得链表中保存元素的个数；
 * public boolean isEmpty()             // 判断链表是否为空；
 * public boolean contains(Arg arg)     // 判断链表是否包含此数据；
 * public Arg get(int index)            // 根据索引取得数据；
 * public void set(int index, Arg arg)  // 修改指定索引的数据；
 * public void remove(Arg arg)          // 删除指定的元素；
 * public Arg[] toArray()               // 将链表转成数组；
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
        System.out.println("link.contains(\"2\"): " + link.contains("2"));      // 判断链表中是否包含此数据
        System.out.println("link.contains(\"4\"): " + link.contains("4"));
        System.out.println("link.get(0): " + link.get(0));                      // 根据索引获取对应的值
        System.out.println("link.get(4): " + link.get(4));

        String tryGetLink5 = "link.get(5): ";
        try {
            System.out.println(tryGetLink5 + link.get(5));
        } catch (IndexOutOfBoundsException IOOBException) {
            System.out.println(tryGetLink5 + IOOBException.getMessage());
        }

        link.set(0, "head");                      // 根据索引修改对应元素的值
        System.out.println("link.get(0): " + link.get(0));
        link.set(4, "emm");                      // 根据索引获取对应的值
        System.out.println("link.get(4): " + link.get(4));

        String trySetLink5 = "link.set(5): ";
        try {
            link.set(5, "ha233");
        } catch (IndexOutOfBoundsException IOOBException) {
            System.out.println(tryGetLink5 + IOOBException.getMessage());
        }

        // 恢复原来的数据
        link.set(0, "root");
        System.out.println("link.get(0): " + link.get(0));
        link.set(4, "end");
        System.out.println("link.get(4): " + link.get(4));
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

        private String getNode(int index) {
            // 使用当前的foot与要查询的索引进行比较，随后将foot + 1，目的是为了方便下次查询
            // 也就是：
            //  1.(判断foot == index)
            //  2.(foot++)
            // 这两步操作
            if (foot++ == index) {  // 如果相等（foot == index），则该节点的下标就是要修改元素的索引（就是要找这个节点(Just You!)）
                return this.data;   // 返回当前节点的data
            } else {
                if (this.next != null) {  // ??已经不需要再进行判断了，因为在Link.get()方法中已经进行过判断了?? //
                    return this.next.getNode(index);
                } else {
                    throw new IndexOutOfBoundsException("输入的索引不正确，必须大于等于0，且小于" + (size - 1));
                }
            }
        }

        private void setNode(int index, String newData) {
            if (foot++ == index) {  // 如果相等（foot == index），则该节点的下标就是要修改元素的索引（就是要找这个节点(Just You!)）
                this.data = newData;   // 修改当前节点的data
            } else {
                if (this.next != null) {
                    this.next.setNode(index, newData);
                } else {  // ??已经不需要再进行判断了，因为在Link.set()方法中已经进行过判断了?? //
                    throw new IndexOutOfBoundsException("输入的索引不正确，必须大于等于0，且小于" + (size - 1));
                }
            }
        }
    }
    /* ===================== 以上为内部类 ===================== */

    private Node root;  // 根节点

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

    private int size = 0;   // 保存的元素个数

    public int getSize() {
        return this.size;   // 返回size
    }

    public boolean isEmpty() {
        /*
         * 两种判断方法：
         * * 一、root是否为null；
         * * 二、size是否为0；
         * 这里是两种都用(233)
         * */
        return (this.size == 0) && (this.root == null);
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

    private int foot = 0;

    public String get(int index) {    // 根据索引取得数据
        /*
         * 我们可以发现，这个链表Demo里保存了多个String对象，原本在程序里只有数组可以保存数据，
         * 但现在使用的链表与数组相比较的话，优势就是没有长度限制，所以链表严格意义上来讲就是一个动态对象数组，
         * 既然属于动态对象数组，那么也应该具备像数组那样可以根据索引取得元素的功能
         * 这是get(int index)方法
         * 既然是动态数组，那么数据也应该是动态的（可以进行增删改）
         * */

        /*
         * 范例：在Link类里增加一个foot（下标）的属性，表示每一个Node元素的编号，当然，此编号是自动生成的
         * 每一查询的时候（链表可以查询多次），那么foot应该在每一次查询的时候都从头开始
         * 但只能在以下情况下才能查询：
         * * 一、index >= 0；
         * * 二、index < size；
         * */
        this.foot = 0;
        if (index >= 0 || index < this.size) {  // 当输入的索引正确时才能进行查询
            return this.root.getNode(index);    // 交给Node类进行查询
        } else {    // 否则就抛出异常（╯°Д°）╯︵ ┻━┻
            throw new IndexOutOfBoundsException("输入的索引不正确，必须大于等于0，且小于" + (this.size - 1));
        }
    }

    public void set(int index, String newData) {
        // 修改和查询的区别不大，查询的时候只是返回满足索引值的数据，而修改只是数据的返回变成重新赋值而已
        if (index >= 0 || index < this.size) {  // 当输入的索引正确时才能进行修改
            this.foot = 0; // 重新设置foot值
            this.root.setNode(index, newData);   // 交给Node类去进行操作
        } else {    // 如果索引不对就抛出异常（╯°Д°）╯︵ ┻━┻
            throw new IndexOutOfBoundsException("输入的索引不正确，必须大于等于0，且小于" + (this.size - 1)); // 如果索引不对则抛出错误
        }
    }

    public void remove(String data) {
        // TODO
    }

    public String[] toArray() {
        // TODO
        return new String[0];
    }
}