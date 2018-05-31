package com.ding.webcollector_boot;

/**
 * @author Ding
 * @create 2018/5/30
 * @description :
 */
public class TestTwo {
    public static void main(String[] args) {

        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
