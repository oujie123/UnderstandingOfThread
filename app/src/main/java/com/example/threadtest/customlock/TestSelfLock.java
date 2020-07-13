package com.example.threadtest.customlock;

import java.util.concurrent.locks.Lock;

/**
 * 不可重入锁
 * @author Jack_Ou  created on 2020/7/13.
 */
public class TestSelfLock {

    public void test(){
        final Lock lock = new SelfLock();

        class Worker extends Thread{
            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName());
                try{
                    SleepTools.second(1);
                }finally {
                    lock.unlock();
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            Worker worker = new Worker();
            worker.start();
        }

        // 主线程每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepTools.second(1);
            //System.out.println();
        }
    }

    public static void main(String[] args) {
        TestSelfLock testSelfLock = new TestSelfLock();
        testSelfLock.test();
    }
}
