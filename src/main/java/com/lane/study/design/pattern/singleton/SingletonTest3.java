package com.lane.study.design.pattern.singleton;

public class SingletonTest3 {

    public static void main(String[] args) {
        Singleton31 singleton = Singleton31.getInstance();
        Singleton31 singleton1 = Singleton31.getInstance();
        System.out.println(singleton == singleton1);
        System.out.println("singleton hashCode = " + singleton.hashCode());
        System.out.println("singleton1 hashCode = " + singleton1.hashCode());
    }
}

/**
 * 双重检查
 *  变量加入volatile关键字，只要instance发生变化就会同步到内存中。所谓的双重检查，就是在getInstance()方法中对变量instance有两次null校验，
 *  第一次校验实现了懒加载并保证了效率，第二次校验实现了线程安全
 */
class Singleton31 {

    private static volatile Singleton31 instance;

    private Singleton31(){}

    public static Singleton31 getInstance() {
        if (instance == null) {
            synchronized (Singleton31.class) {
                if (instance == null) {
                    instance = new Singleton31();
                }
            }
        }
        return instance;
    }
}
