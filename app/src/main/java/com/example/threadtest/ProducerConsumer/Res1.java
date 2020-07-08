package com.example.threadtest.ProducerConsumer;

//此版有线程安全问题，因为没有锁
public class Res1 {
    private String name;
    private int id = 0;

    public void put(String name){
        id++;
        this.name = name + "面包编号：" + id;
        System.out.println(Thread.currentThread() + ":" + id);
    }

    public void out(){
        id--;
        System.out.println(Thread.currentThread() + ":" + id);
    }
}
