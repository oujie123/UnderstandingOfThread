package com.example.threadtest.templatepattern;

/**
 * @author Jack_Ou  created on 2020/7/13.
 */
public class ChineseCake extends AbstractCake {


    @Override
    protected void shape() {
        System.out.println("ChineseCake---->shape");
    }

    @Override
    protected void apply() {
        System.out.println("ChineseCake---->apply");
    }

    @Override
    protected void brake() {
        System.out.println("ChineseCake---->brake");
    }
}
