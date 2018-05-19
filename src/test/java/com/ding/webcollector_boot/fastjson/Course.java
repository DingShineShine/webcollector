package com.ding.webcollector_boot.fastjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ding
 * @Description
 * @date 2018/05/19-15:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Course {
    private String courseName;
    private String code;


    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
