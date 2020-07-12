package com.example.threadtest.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private static AtomicInteger ai = new AtomicInteger(100);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.incrementAndGet());
        System.out.println(ai.addAndGet(20));
    }
}
