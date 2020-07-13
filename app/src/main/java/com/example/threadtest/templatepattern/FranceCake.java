package com.example.threadtest.templatepattern;

/**
 * @author Jack_Ou  created on 2020/7/13.
 */
public class FranceCake extends AbstractCake{
    @Override
    protected void shape() {
        System.out.println("FranceCake---->shape");
    }

    @Override
    protected void apply() {
        System.out.println("FranceCake---->apply");
    }

    @Override
    protected void brake() {
        System.out.println("FranceCake---->brake");
    }
}
