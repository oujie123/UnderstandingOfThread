package com.example.threadtest.thread;

class ThreadJoinTest extends Thread{

    private String name;

    public ThreadJoinTest(String name){
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + ":" + i);
        }
    }
}

