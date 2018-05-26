package com.ding.webcollector_boot.observer;

import java.util.HashSet;

/**
 * @author ding
 * @Description
 * @date 2018/05/26-13:59
 */
public class TestObserver {

    public static void main(String[] args) {
        ObservableSet<Integer> s = new ObservableSet<Integer>(new HashSet<Integer>());
        s.addObserver(new SetObserver<Integer>(){
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
            }
        });
        for (int i = 0; i < 10; i++) {
            s.add(i);
        }
    }
}
