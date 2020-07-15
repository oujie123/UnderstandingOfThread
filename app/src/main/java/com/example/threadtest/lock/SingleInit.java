package com.example.threadtest.lock;

/**
 * 懒汉式：延迟初始化占位类模式
 * 该模式为什么是线程安全的呢？
 * 因为类加载机制保证的，在加载类的时候，在虚拟机中一个类的加载只会被执行一次的，虚拟机会自动加锁，保证任意时刻只有一个线程可以执行类加载。
 *
 */
public class SingleInit {

    private static class InstanceHolder{
        private static SingleInit singleInit = new SingleInit();
    }

    public static SingleInit getInstance(){
        return InstanceHolder.singleInit;
    }
}
