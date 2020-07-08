package com.example.threadtest.lock;

/**
 * 2.对象锁
 *
 * @author Jack_Ou  created on 2020/7/8.
 */
public class CountTest {

    private int num = 0;

    public int getNum(){
        return num;
    }

    /**
     * 1.对象锁
     * 因为这个方法没有static，synchronized是持有的counttest.this，所以是对象锁
     *
     */
    public synchronized void incCount1() {
        num++;
    }

    /**
     * 同样持有的是对象锁
     */
    public void incCount2(){
        synchronized (CountTest.this){
            num++;
        }
    }

    /**
     * 随意一个对象持有锁
     */
    Object object = new Object();
    public void incCount3(){
        synchronized (object){
            num++;
        }
    }

    public static class Counter extends Thread {

        private CountTest countTest;

        public Counter(CountTest countTest) {
            this.countTest = countTest;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 10000; i++) {
                //countTest.incCount1();
                //countTest.incCount2();
                countTest.incCount3();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        CountTest countTest = new CountTest();
        Counter counter1 = new Counter(countTest);
        Counter counter2 = new Counter(countTest);
        counter1.start();
        counter2.start();

        Thread.sleep(100);
        System.out.println(countTest.getNum());
    }
}
