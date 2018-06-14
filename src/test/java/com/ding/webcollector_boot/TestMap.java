package com.ding.webcollector_boot;

import org.aspectj.weaver.ast.Var;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Ding
 * @create 2018/6/13
 * @description :
 */
public class TestMap {
    Map map = new HashMap<String,String>();


    public void method1(){
        map.put("1","1");
        map.put("2,","2");
        Set set = map.keySet();
        for( Object key : map.keySet()){
            System.out.println("method1 : " + map.get(key));
        }
    }


    public void method2(){
        map.put("3","3");
        map.put("4,","4");
        for( Object key : map.keySet()){
            System.out.println("method2 : " + map.get(key));
        }
    }
}
