package com.example.threadtest.thread;
//线程中断(类暴力，无法中断)
public class EndThread {

    public static class UserThread extends Thread{
        @Override
        public void run() {
            super.run();
            String name = Thread.currentThread().getName();
            while (true){
                System.out.println(name + "running !");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UserThread userThread = new UserThread();
        userThread.start();

        Thread.sleep(10);
        //通知要中断，但是如果还有在执行的任务，不会真正结束
        userThread.interrupt();
    }
}
