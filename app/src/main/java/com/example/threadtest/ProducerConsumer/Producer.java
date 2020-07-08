package com.example.threadtest.ProducerConsumer;

public class Producer implements Runnable {

    private Res3 res;

    public Producer(Res3 res){
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            res.put("面包");
        }
    }
}
