package com.example.threadtest.ProducerConsumer;

import androidx.annotation.Nullable;

/**
 * ThreadLocal中维护了一个map，key是线程值，value是T
 * 当get的时候，会首先获得当前线程的线程值，从map中取得该线程值的T返回
 * 当set的时候，会首先获得当前线程的线程值，在map中找到对应的位置设置T
 *
 *
 * ThreadLocal实现了线程隔离，在Handler会使用到
 */
public class ThreadLocalTest {

    static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
        @Nullable
        @Override
        protected String initialValue() {
            return "广州";
        }
    };

    private static class StudentThread extends Thread {
        @Override
        public void run() {
            super.run();
            String threadName = Thread.currentThread().getName();
            System.out.println("首次拿到threadName：" + threadName + "get:" + threadLocal.get());
            threadLocal.set("重庆");
            System.out.println("set后拿到threadName：" + threadName + "get:" + threadLocal.get());
        }
    }

    private static class PersonThread extends Thread {
        @Override
        public void run() {
            super.run();
            String threadName = Thread.currentThread().getName();
            System.out.println("首次拿到threadName：" + threadName + "get:" + threadLocal.get());
            threadLocal.set("JackOu");
            System.out.println("set后拿到threadName：" + threadName + "get:" + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        StudentThread thread1 = new StudentThread();
        PersonThread thread2 = new PersonThread();

        thread1.start();
        thread2.start();
    }
}
