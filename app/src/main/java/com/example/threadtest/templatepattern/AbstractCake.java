package com.example.threadtest.templatepattern;

/**
 * @author Jack_Ou  created on 2020/7/13.
 */
public abstract class AbstractCake {

    /**
     * 使用protected限制只有之类或者自己内部可以调用
     */
    protected abstract void shape();

    protected abstract void apply();

    protected abstract void brake();

    /**
     *     使用final不然之类重写
     */
    public final void run() {
        this.shape();
        this.apply();
        this.brake();
    }
}
