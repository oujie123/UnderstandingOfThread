package com.example.threadtest.thread;
//线程执行顺序控制
public class JoinThread {

    public static void main(String[] args) throws InterruptedException {
        ThreadJoinTest threadJoinTest1 = new ThreadJoinTest("A");
        ThreadJoinTest threadJoinTest2 = new ThreadJoinTest("B");
        ThreadJoinTest threadJoinTest3 = new ThreadJoinTest("C");
        threadJoinTest1.start();
        threadJoinTest2.start();
        threadJoinTest2.join();
        threadJoinTest3.start();
        //threadJoinTest3.join();
    }
}