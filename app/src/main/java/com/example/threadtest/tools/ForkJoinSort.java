package com.example.threadtest.tools;


import java.util.concurrent.ForkJoinPool;

/**
 * @author Jack_Ou  created on 2021/1/12.
 */
public class ForkJoinSort {

    public static void main(String[] args) {
        int[] src = MakeArray.makeArray();
        ForkJoinPool pool = new ForkJoinPool();

        MyRecursiveTask task = new MyRecursiveTask(src, 0, src.length - 1);

        long start = System.currentTimeMillis();
        Integer invoke = pool.invoke(task);

        System.out.println("comsume: " + (System.currentTimeMillis() - start) + "ms");
    }
}
