package com.lane.study.design.pattern.singleton;

public class SingletonTest5 {

    public static void main(String[] args) {
        Singleton51 singleton = Singleton51.INSTANCE;
        Singleton51 singleton1 = Singleton51.INSTANCE;
        System.out.println(singleton == singleton1);
        System.out.println("singleton hashCode = " + singleton.hashCode());
        System.out.println("singleton1 hashCode = " + singleton1.hashCode());
        singleton.sayHello();
    }
}

/**
 * 枚举
 *  特点：1.枚举构造函数本就是私有的
 *       2.枚举是单例的，且线程安全
 */
enum Singleton51 {

    INSTANCE;

    public void sayHello() {
        System.out.println("hello");
    }
}
