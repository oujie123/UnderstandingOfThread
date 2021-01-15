package com.example.threadtest.thread;
//配置守护进程
public class ThreadDeamon {

    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 5; i++) {
                    System.out.println(getName() + "----->" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //如果该线程是守护线程，那么main线程执行完毕之后，守护线程一起结束
        //如果不是守护线程，Main线程会等待该线程执行结束后结束。
        //如果是守护线程，子线程大于main的时间，main执行完了就结束，不管子线程。
        thread.setDaemon(true);
        thread.start();

        // 设置3000 6000观察守护线程内打印情况可以看出守护线程的生命周期
        Thread.sleep(3000);
    }
}
