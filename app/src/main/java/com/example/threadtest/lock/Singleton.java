package com.example.threadtest.lock;

/**
 * 1.类锁
 *
 * @author Jack_Ou  created on 2020/7/8.
 */
public class Singleton {

    private static Singleton mInstance;

    /**
     *  1.类锁：要把这个类的方法执行完之后才会被释放,效率比较低
     *  方法是静态的，synchronized持有的是类锁
     * @return
     */
//    public static synchronized Singleton getInstance() {
//        if (mInstance == null) {
//            mInstance = new Singleton();
//        }
//        return mInstance;
//    }

    /**
     *  该锁也是类锁
     *
     * @return
     */
    public static Singleton getInstance(){
        if (mInstance == null){
            //两个判断的原因是：多个线程在此处等待的时候，第一个线程new 完成之后，后面不能在new了
            synchronized (Singleton.class){
                if (mInstance == null){
                    mInstance = new Singleton();
                }
            }
        }
        return mInstance;
    }

}
