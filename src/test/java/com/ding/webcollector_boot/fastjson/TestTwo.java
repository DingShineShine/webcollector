package com.ding.webcollector_boot.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ding.webcollector_boot.fastjson.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ding
 * @Description
 * @date 2018/05/19-15:24
 */
public class TestTwo {
    //json字符串-简单对象型
    private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";

    //json字符串-数组类型
    private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

    //复杂格式json字符串
    private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    @Test
    public void test1(){
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
//        Student parse = (Student) JSONObject.parse(JSON_OBJ_STR);
//        System.out.println(parse);
        Student student = JSONObject.parseObject(JSON_OBJ_STR, Student.class);
        System.out.println(student);


        boolean b = jsonObject.toJSONString().equalsIgnoreCase(jsonObject.toString());
        System.out.println(b);
        System.out.println(jsonObject);
    }

    @Test
    public void test2(){
        JSONArray objects = JSONObject.parseArray(JSON_ARRAY_STR);
        System.out.println(objects);
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i));
        }
        for (Object object : objects) {
            System.out.println(object);
        }
    }
    @Test
    public void test3(){
        JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);
        System.out.println(jsonObject);
        Teacher teacher = JSONObject.parseObject(COMPLEX_JSON_STR, Teacher.class);
        System.out.println(teacher);
        JSONObject course = jsonObject.getJSONObject("course");
        System.out.println(course);
        JSONArray studet = jsonObject.getJSONArray("students");
        System.out.println(studet);
    }

    @Test
    public void test5(){
        Student student = new Student("hu",12);
        String s = JSON.toJSONString(student);
        System.out.println(s);
        System.out.println(JSONObject.toJSONString(student).equalsIgnoreCase(s));
    }

    @Test
    public void test70(){
        List<Student> studentList = JSONArray.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});
        System.out.println(studentList);
    }

    @Test
    public void test81(){
        JSONObject jsonObject = JSON.parseObject(JSON_OBJ_STR);
        Student student = JSON.parseObject(JSON_OBJ_STR, Student.class);
        System.out.println(student);
    }



}
