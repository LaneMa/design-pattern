package com.lane.study.design.pattern.singleton;

public class SingletonTest1 {

    public static void main(String[] args) {
        //=====================================================
        Singleton11 singleton = Singleton11.getInstance();
        Singleton11 singleton1 = Singleton11.getInstance();
        System.out.println(singleton == singleton1);
        System.out.println("singleton hashCode = " + singleton.hashCode());
        System.out.println("singleton1 hashCode = " + singleton1.hashCode());

        //=====================================================
        Singleton12 singleton11 = Singleton12.getInstance();
        Singleton12 singleton12 = Singleton12.getInstance();
        System.out.println(singleton11 == singleton12);
        System.out.println("singleton11 hashCode = " + singleton11.hashCode());
        System.out.println("singleton12 hashCode = " + singleton12.hashCode());

    }

}

/**
 * 饿汉模式- 通过静态方法和静态变量，在类加载的时候 就完成了对象的实例化，以此避免了线程同步问题
 * 优点：写法简单
 * 缺点：静态方法和静态变量 在类加载的时候就实例化进内存，如果这个类一直没有调用，内存也会一直占据着，内存浪费。
 *  在本例子中，类加载的情况是getInstance()方法，不会有上述问题。但是在复杂的类中，导致类加载的情况有很多，如果不是getInstance()方法导致类加载的话，
 *  就会出现以上的问题了
 */
class Singleton11 {

    private final static Singleton11 instance = new Singleton11();

    private Singleton11() {

    }

    public static Singleton11 getInstance() {
        return instance;
    }

}

/**
 * 饿汉模式 写法2，将静态变量放置在静态块中实现，优缺点和上面一样
 */
class Singleton12 {

    private final static Singleton12 instance;

    private Singleton12() {

    }

    static {
        instance = new Singleton12();
    }

    public static Singleton12 getInstance() {
        return instance;
    }

}