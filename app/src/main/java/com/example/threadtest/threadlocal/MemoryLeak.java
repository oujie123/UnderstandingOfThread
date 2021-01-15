package com.example.threadtest.threadlocal;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author Jack_Ou  created on 2021/1/12.
 */
public class MemoryLeak {
    static Executor executor = new ScheduledThreadPoolExecutor(5);
    static ThreadLocal<LocalValue> threadLocal = new ThreadLocal<>();

    static class LocalValue {
        private byte[] a = new byte[1024 * 1024 * 10];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    threadLocal.set(new LocalValue());
                    System.out.println("use thread local");
                    // threadLocal.get(); 以下是使用threadlocal
                    // ....使用代码

                    // threadLocal.remove();
                }
            });
        }
    }
}
