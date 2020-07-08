package com.example.threadtest.ProducerConsumer;

//实现生产一个消费一个

/**
 * 为什么wait和notify一定要被synchronized包裹起来
 * 因为在等待区和唤醒区都需要获取对象锁，如果不在synchronized中，就无法获取对象锁，直接会报错
 * notify和wait要同一把锁。
 *
 *
 * sync(this){ 此处已经对wait加锁了，讲道理notify是拿不到这个锁的。那为什么notify是怎么拿到锁的呢
 *     wait()；
 * }
 *因为在调用wait()的时候，这个锁会被释放，所以notify()才能拿到这个锁。
 *
 * notify()是随机唤醒一个线程，由于此案例中只有两个线程，很明确知道唤醒谁，所以就调用notify()即可，否者需要调用notifyall（）方法
 */
public class Res3 {

    private int id;
    private boolean flag; //标记是否有面包已经生产了

    public synchronized void put(String name) {
        if(!flag){
            id ++;
            System.out.println(Thread.currentThread().getName() + ":" + id);

            flag = true;
            /**
             * 唤醒wait（）被冻结的线程，如果没有线程被冻结，java默认也不会报错
             */
            notify();//notify()和wait()必须在锁里面使用，否者会报错

            /**
             * 冻结当前线程，释放CPU执行权，此时CPU会去执行其他线程。
             */
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void out(){
        if(flag){
            System.out.println(Thread.currentThread().getName() + "==============> 消费了" + id);

            flag = false;

            /**
             * 唤醒wait（）被冻结的线程，如果没有线程被冻结，java默认也不会报错
             */
            notify();//notify()和wait()必须在锁里面使用，否者会报错

            /**
             * 冻结当前线程，释放CPU执行权，此时CPU会去执行其他线程。
             */
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
