package com.lane.study.design.pattern.singleton;

public class SingletonTest4 {

    public static void main(String[] args) {
        Singleton41 singleton = Singleton41.getInstance();
        Singleton41 singleton1 = Singleton41.getInstance();
        System.out.println(singleton == singleton1);
        System.out.println("singleton hashCode = " + singleton.hashCode());
        System.out.println("singleton1 hashCode = " + singleton1.hashCode());
    }
}

/**
 * 静态内部类
 *  特点：1.外部类加载的时候，静态内部类不会加载，即懒加载
 *       2.静态内部类被调用的时候会加载，类加载是线程安全的
 */
class Singleton41 {

    private Singleton41(){}

    private static class Singleton41Instance {
        private final static Singleton41 INSTANCE = new Singleton41();
    }

    public static Singleton41 getInstance() {
        return Singleton41Instance.INSTANCE;
    }
}