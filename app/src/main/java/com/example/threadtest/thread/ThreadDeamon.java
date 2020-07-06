package com.example.threadtest.thread;
//配置守护进程
public class ThreadDeamon {

    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 5; i++) {
                    System.out.println(getName() + "-----" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //如果该线程是守护线程，那么main线程执行完毕之后，守护线程一起结束
        //如果不是守护线程，Main线程会等待该线程执行结束后结束。如果Main执行的时间小于子线程，则等子线程执行完了就结束；否者Main执行完了结束。
        //thread.setDaemon(true);
        thread.start();

        Thread.sleep(10000);
    }
}
