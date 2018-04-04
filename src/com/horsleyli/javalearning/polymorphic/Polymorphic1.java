package com.horsleyli.javalearning.polymorphic;

/**
 * 多态:
 * 某一种事物的多种体现形态.
 * 重点是事物的多态性.
 *
 * //    class 父 {}
 * //
 * //    class 子 extends 父 {}
 * //
 * //    //子 z = new 子();
 * //    父 s = new 子();//体现多态.        一个实体 "a"  两个类型 "动物" 和 "猫".
 *
 * 多态在程序中的体现: 父类或接口的引用指向了自己的子类对象.
 *
 * 多态的好处: 提高了代码的拓展性,后期出现的功能可以被之前的程序所执行.
 *
 * 多态的弊端: 虽然可以使用后期出现的代码,但是不能使用子类中特有的功能,只能使用覆盖了父类的功能.
 *
 * 多态的前提: 必须要有关系(extends , implements),通常有覆盖操作.
 *
 * 多态自始自终都是子类在做着类型变换.
 *
 * //    //子 z = (子)new 父();
 * 并不能直接把父类强制转换成子类,
 * 因为并不确定一个父类到底有多少个子类,以及子类和父类中的方法是否相同
 *
 **/

public class Polymorphic1 {

    public static void main(String[] args) {

//        非多态:
//        Cat c = new Cat();
//        c.eat();

//        多态:
//        Animal a = new Cat();
//        a.eat();

        eatMethod(new Cat());
        eatMethod(new Dog());

        Animal a = new Cat();
//        向上转型.
//        什么时候用?    需要提高程序的拓展性,隐藏具体子类型时.

        Animal a1 = new Cat();
        Cat c = (Cat)a1;
//        向下转型.
//        什么时候用?    当需要使用子类型的特有方法时.
        c.eat();
        c.catchMouse();

//        向下转型前,必须对具体对象进行类型的判断(instanceof).
//        为了避免运行时出现"ClassCastException".
        Cat c1;
        if (a1 instanceof Cat) {
            c1 = (Cat)a1;
            System.out.println("a1是Cat类对象.");
        }

    }

//    直接使用使用父类型调用子类.
    public static void eatMethod(Animal a) {
        a.eat();

//          只能使用覆盖了父类的方法.
//        a.catchMouse();

    }
}

abstract class Animal {
    void eat() {}
}

class Cat extends Animal {

    @Override
    void eat() {
        System.out.println("Cat.eat()");
    }

    void catchMouse() {
        System.out.println("catchMouse()");
    }
}

class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("Dog.eat()");
    }

    void lookHome() {
        System.out.println("Dog.lookHome()");
    }
}
