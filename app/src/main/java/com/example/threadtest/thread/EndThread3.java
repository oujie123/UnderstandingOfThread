package com.example.threadtest.thread;
//线程中断(和谐方式)
public class EndThread3 {

    public static class UserThread implements Runnable{

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            while (!Thread.currentThread().isInterrupted()){
                System.out.println(name + "running ! isInterrupt stats = " + Thread.currentThread().isInterrupted());
            }
            System.out.println(name + " exit ! isInterrupt stats = " + Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UserThread userThread = new UserThread();
        Thread thread = new Thread(userThread);
        thread.start();

        Thread.sleep(3);
        thread.interrupt();
    }
}
