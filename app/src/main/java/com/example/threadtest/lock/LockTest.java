package com.example.threadtest.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3.显示锁
 * <p>
 * 由于synchronized是隐式的(或者内置锁)，没法控制，所以有了显示锁，可以控制
 *
 * @author Jack_Ou  created on 2020/7/8.
 */
public class LockTest {

    private int num = 0;
    //synchronized 天生就是可重入锁
    //显示锁,可重入锁
    private Lock lock = new ReentrantLock();

    //错误写法
//    public void incCount4(){
//        lock.lock();
//        num++;//如果这样写可能导致锁无法释放，因为如果锁之间的代码抛出异常，然后就会导致lock.unlock()无法调用
//        lock.unlock();
//    }

    public void incCount4() {
        lock.lock();
        try {
            num++;
        } finally {
            lock.unlock();
        }
    }

    //synchronized 天生是可重入锁，当第一次进入之后，方法就会被锁住，后面无法再次进入，最后会找出卡死状态
    //可重入锁可以让你进入方法，但是会持有一把锁。
    //可重入锁：可以递归调用方法持有锁，反复持有锁
    public synchronized void add(){
        num ++ ;
        add();
    }

    private int getNum(){
        return num;
    }

    public static class Counter extends Thread {

        private LockTest lockTest;

        public Counter(LockTest countTest) {
            this.lockTest = countTest;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 10000; i++) {
                lockTest.incCount4();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        LockTest lockTest = new LockTest();
        Counter counter1 = new Counter(lockTest);
        Counter counter2 = new Counter(lockTest);
        counter1.start();
        counter2.start();

        Thread.sleep(100);
        System.out.println(lockTest.getNum());
    }
}
