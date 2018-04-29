package com.github.ji2846.javalearning.demo;

public class MyDemo1
{
    public static void main(String[] args)
    {
        Animal d1 = new Dog("Jerry");
        Animal d2 = new Dog("Lily");
        d1.say();
        d2.say();
        d1.setName(d2.getName());
        d1.say();
        d1.setName("Jerry");
        d1.say();
    }
}

abstract class Animal
{
    private String name;
    Animal(String name)
    {
        this.name = name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public abstract void say();
}

class Dog extends Animal
{
    public Dog(String name)
    {
        super(name);
    }

    @Override
    public void say()
    {
        // TODO: Implement this method
        System.out.println(getName() + ": wang! wang!");
    }
}
