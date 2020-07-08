package com.example.threadtest.ProducerConsumer;

public class Consumer implements Runnable {

    private Res3 res;

    public Consumer(Res3 res){
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            res.out();
        }
    }
}
