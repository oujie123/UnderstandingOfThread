package com.example.threadtest.ProducerConsumer;

public class Tester1 {

    public static void main(String[] args) throws Exception{
        Res3 res = new Res3();
        Consumer consumer = new Consumer(res);
        Producer producer = new Producer(res);

        new Thread(producer).start();
        //Thread.sleep(10);
        new Thread(consumer).start();
    }
}
