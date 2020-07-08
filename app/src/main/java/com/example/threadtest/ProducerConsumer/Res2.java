package com.example.threadtest.ProducerConsumer;

//此版使用内置锁，解决安全线程安全问题
public class Res2 {
    private String name;
    private int id = 0;

    //该锁是对象锁，和下面锁的持有对象是一样的，都是Res2.this
    public synchronized void put(String name){
        id++;
        this.name = name + "面包编号：" + id;
        System.out.println(Thread.currentThread() + ":" + id);
    }

    public synchronized void out(){
        System.out.println(Thread.currentThread() + ":" + id);
        id--;
    }
}
