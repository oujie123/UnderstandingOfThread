package com.example.threadtest.customlock;

import java.util.concurrent.locks.Lock;

/**
 * @author Jack_Ou  created on 2020/7/13.
 */
public class TestReSelfLock {

    final Lock lock = new ReSelfLock();

    public void reenter(int x){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "递归次数：" + x);
            int y = x -1;
            if(y == 0) {
                return;
            } else {
                reenter(y);
            }
        }finally {
            lock.unlock();
        }
    }

    public void test(){

        class Worker extends Thread{
            @Override
            public void run() {
                reenter(3);
            }
        }

        for (int i = 0; i < 3; i++) {
            Worker worker = new Worker();
            worker.start();
        }

        // 主线程每隔1秒换行
        for (int i = 0; i < 100; i++) {
            SleepTools.second(1);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TestReSelfLock testSelfLock = new TestReSelfLock();
        testSelfLock.test();
    }
}
