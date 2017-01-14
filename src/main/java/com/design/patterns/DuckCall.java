package com.design.patterns;

public class DuckCall {

    QuackBehavior quackBehavior;

    public DuckCall() {
        quackBehavior = new Quack();
    }
    public void performQuack() {
        quackBehavior.quack();
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void display() {
        System.out.println("I’m a fake duck");
    }
}
