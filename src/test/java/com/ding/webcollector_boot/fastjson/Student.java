package com.ding.webcollector_boot.fastjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ding
 * @Description
 * @date 2018/05/19-15:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private String studentName;
    private Integer studentAge;

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                '}';
    }
}
