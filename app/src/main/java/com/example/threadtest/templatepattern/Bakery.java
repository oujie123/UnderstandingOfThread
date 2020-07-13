package com.example.threadtest.templatepattern;

import com.example.threadtest.templatepattern.ChineseCake;

/**
 * @author Jack_Ou  created on 2020/7/13.
 */
public class Bakery {

    public static void main(String[] args) {
        ChineseCake chineseCake = new ChineseCake();
        chineseCake.run();
        FranceCake franceCake = new FranceCake();
        franceCake.run();
    }
}
