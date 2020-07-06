package com.example.threadtest.thread;
//线程中断(和谐方式)
public class EndThread2 {

    public static class UserThread extends Thread{
        @Override
        public void run() {
            super.run();
            String name = Thread.currentThread().getName();
            //和谐停止标志位
            while (!isInterrupted()){
                System.out.println(name + "running ! isInterrupt stats = " + isInterrupted());
            }
            System.out.println(name + " exit ! isInterrupt stats = " + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UserThread userThread = new UserThread();
        userThread.start();

        Thread.sleep(3);
        //通知要中断，但是如果还有在执行的任务，不会真正结束
        userThread.interrupt();

    }
}
