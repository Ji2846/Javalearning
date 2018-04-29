package com.github.ji2846.javalearning.collection;

import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        method(coll);
    }
    public static void method(Collection coll) {
        coll.add("a");
        coll.add("b");
        coll.add("c");
        coll.remove("a");
        System.out.println("size:\t" + coll.size());
        System.out.println("isEmpty?\t" + coll.isEmpty());
        System.out.println("have a?\t" + coll.contains("a"));
        System.out.println("have b?\t" + coll.contains("b"));
    }
}
