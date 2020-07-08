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
    //显示锁
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
