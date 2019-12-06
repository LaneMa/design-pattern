package com.lane.study.design.pattern.singleton;

public class SingletonTest2 {

    public static void main(String[] args) {

        Singleton21 singleton21 = Singleton21.getInstance();
        Singleton21 singleton22 = Singleton21.getInstance();
        System.out.println(singleton21 == singleton22);
        System.out.println("singleton21 hashCode = " + singleton21.hashCode());
        System.out.println("singleton22 hashCode = " + singleton22.hashCode());

    }
}

/**
 * 懒汉式，即用到的时候再去实例化对象
 * 优点：实现了懒加载，即用到的时候再去实例化对象
 * 缺点：线程不安全。在多线程的情况下，若线程A执行了if(instance == null)语句，还没执行下一步，线程切换到B，线程A处于挂起状态，
 *  这时候线程B执行完if(instance == null)语句后实例化对象，线程再切换到A，由于之前已经执行完if判断了，此时线程A也会new一个新的对象，
 *  那么此时 线程A和线程B不是同一个对象了。
 */
class Singleton21 {

    private static Singleton21 instance;

    private Singleton21() {}

    public static Singleton21 getInstance() {
        if (instance == null) {
            instance = new Singleton21();
        }
        return instance;
    }
}

/**
 * 懒汉式 写法2，在getInstance方法前加上同步关键字synchronized，解决上个方法的线程不同步问题
 * 优点：线程安全
 * 缺点：每次调用getInstance()获取对象的时候，都要进行同步，效率低。对于单例来说，只要一次实例化，获取对象直接return就可以了。
 */
class Singleton22 {

    private static Singleton22 instance;

    private Singleton22() {}

    public static synchronized Singleton22 getInstance() {
        if (instance == null) {
            instance = new Singleton22();
        }
        return instance;
    }
}