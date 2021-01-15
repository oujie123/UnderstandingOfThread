package com.example.threadtest.tools;

import java.util.concurrent.RecursiveTask;

/**
 * @author Jack_Ou  created on 2021/1/12.
 */
public class MyRecursiveTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = MakeArray.ARRAY_LENGTH / 10;
    private int[] src;
    private int from;
    private int to;

    public MyRecursiveTask(int[] src, int from, int to) {
        this.src = src;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Integer compute() {
        // 判断任务位置是否合适。
        // 如果合适就就直接运算返回结果，否则就细分任务
        if (to - from < THRESHOLD) {
            int sum = 0;
            System.out.println("start work! fromIndex:" + from + ",toIndex:" + to);
            for (int i = from; i <= to; i++) {
                sum += src[i];
            }
            return sum;
        } else {
            int mid = (from + to) / 2;
            MyRecursiveTask left = new MyRecursiveTask(src, from, mid);
            MyRecursiveTask right = new MyRecursiveTask(src, mid + 1, to);
            invokeAll(left, right);
            return left.join() + left.join();
        }
    }
}
