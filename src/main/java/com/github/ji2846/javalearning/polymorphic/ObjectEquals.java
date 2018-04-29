package com.github.ji2846.javalearning.polymorphic;

public class ObjectEquals extends Object{
    private int num;
    ObjectEquals(int num) {
        this.num = num;
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof ObjectEquals))
            return false;
        ObjectEquals o = (ObjectEquals)obj;
        return o.num == this.num;
    }
}

class ObjectTest {
    public static void main(String[] args) {
        ObjectEquals o = new ObjectEquals(1);
        ObjectEquals o1 = new ObjectEquals(1);
        ObjectEquals o2 = new ObjectEquals(2);
        System.out.println(o.equals(o1));
        System.out.println(o.equals(o2));
    }
}
