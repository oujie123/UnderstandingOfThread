package com.example.threadtest.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyThread {

    //真正实现一个线程
    public static class StudentThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("do work thread");
        }
    }

    //实现一个任务没有返回值
    public static class PersonThread implements Runnable{

        @Override
        public void run() {
            System.out.println("do work Runnable");
        }
    }

    //实现一个任务有返回值
    public static class WorkerThread implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("do work Callable");
            Thread.sleep(2000);
            return "run success";
        }
    }

    public static void main(String[] args) throws Exception {
        StudentThread studentThread = new StudentThread();
        studentThread.start();

        Thread runnableThread = new Thread(new PersonThread());
        runnableThread.start();

        WorkerThread workerThread = new WorkerThread();
        FutureTask<String> futureTask = new FutureTask<>(workerThread);
        Thread thread = new Thread(futureTask);
        thread.start();
        //get方法是线程阻塞的，等call执行才返回
        System.out.println(futureTask.get());
    }
}
