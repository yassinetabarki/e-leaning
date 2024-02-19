package com.example.demo.teacher;

import com.example.demo.course.Course;
import lombok.Data;

import java.util.Set;

@Data
public class TeacherTDO {
    private  Long id;
    private  String name;
    private  String email;
    private Set<Course> courses;
}


