package com.ding.webcollector_boot.fastjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ding
 * @Description
 * @date 2018/05/19-15:35
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {
    private String teacherAge;
    private String teacherName;
    private Course course;
    private List<Student> students;

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherAge='" + teacherAge + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", course=" + course +
                ", students=" + students +
                '}';
    }
}
