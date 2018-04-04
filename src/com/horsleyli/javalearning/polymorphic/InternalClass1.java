package com.horsleyli.javalearning.polymorphic;

/**
 * 内部类:
 * 定义在类中的类,称为内部类.
 *
 * 好处是可以直接访问外部类中的成员.
 * 内部类可以直接访问外部类的原理: 因为内部类持有了外部类的引用(外部类名.this)
 *
 * 外部类想要访问内部类需要先创建内部类对象.
 *
**/

public class InternalClass1 {
    public static void main(String[] args) {
        Outer out = new Outer();
        out.method();

        Outer.Inner in = out.new Inner();
//        创建内部类对象.
        in.show();
    }
}

class Outer {
    private int num = 1;
    class Inner {
//        内部类
        void show() {
            System.out.println("Inner.show()\t" + num);
        }

//        static int a = 1;
//        static void method() {}
//        非静态内部类中不允许声明静态变量或方法.
        static final int a = 1;
//        非静态内部类中只能定义静态常量(final),其他静态修饰的成员都不允许.
    }
    void method() {
        System.out.println("Outer.method()");
        Inner in = new Inner();
//        创建内部类对象来访问内部类.
        in.show();

//        内部类是静态时,访问非静态的方法.
        Outer1.staticInner staticIn = new Outer1.staticInner();
        staticIn.show1();

//        内部类是静态时,访问静态的方法.
        Outer1.staticInner.staticShow();

    }

//    内部类还可以定义在局部中.
    void inMethod() {
        class inMehodClass {
            void doWork() {
                System.out.println("inMethod.doWork()\t" + num);
            }
        }



//        当方法定义在局部中时的调用方法.
        new inMehodClass().doWork();
    }
}

class Outer1 {
    static class staticInner {
        void show1() {
            System.out.println("staticInner.show1()");
        }
        static void staticShow() {
            System.out.println("staticInner.staticShow()");
        }
    }
}
