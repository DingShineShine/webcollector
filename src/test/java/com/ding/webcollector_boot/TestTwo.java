package com.ding.webcollector_boot;

/**
 * @author ding
 * @Description
 * @date 2018/05/30-20:49
 */
public class TestTwo {
    public static void main(String[] args) {
        /*String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);*/
        String s2 = new StringBuilder("阿达a").append("vd").toString();
        System.out.println(s2.intern() == s2);
        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);
    }
}
