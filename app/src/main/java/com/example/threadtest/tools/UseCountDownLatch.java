package com.example.threadtest.tools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class UseCountDownLatch {

    public static CountDownLatch latch = new CountDownLatch(5);

    private static class InitThread implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread_" + Thread.currentThread().getId()
                    + " ready init work......");
            latch.countDown();
            for (int i = 0; i < 2; i++) {
                System.out.println("Thread_" + Thread.currentThread().getId()
                        + " ........continue do its work");
            }
        }
    }

    private static class BusiThread implements Runnable {

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("BusiThread_" + Thread.currentThread().getId()
                        + " do business-----");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SleepTools.ms(1);
                System.out.println("Thread_" + Thread.currentThread().getId()
                        + " ready init work step 1st......");
                latch.countDown();
                System.out.println("begin step 2nd.......");
                SleepTools.ms(1);
                System.out.println("Thread_" + Thread.currentThread().getId()
                        + " ready init work step 2nd......");
                latch.countDown();
            }
        }).start();
        new Thread(new BusiThread()).start();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new InitThread());
            thread.start();
        }

        // 多少时间之后，没有执行就不阻塞，继续执行下去
        latch.await(10, TimeUnit.NANOSECONDS);
        System.out.println("Main do ites work........");
    }
}