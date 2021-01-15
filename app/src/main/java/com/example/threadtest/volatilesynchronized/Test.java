package com.example.threadtest.volatilesynchronized;

/**
 * 演示volatile和synchronized实现原理
 *
 * @author Jack_Ou  created on 2020/7/14.
 */
public class Test {

    private static volatile int i = 0;
    private final Object lock = new Object();

    public void a() {
        synchronized (lock) {
            i++;
        }
    }

    public synchronized void b() {
        i++;
    }

    public synchronized void c() {
        i++;
    }
}