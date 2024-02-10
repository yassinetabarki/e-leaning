package com.example.demo.teacher;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TeacherTDOMapper implements Function<Teacher, TeacherTDO> {
    @Override
    public TeacherTDO apply(Teacher teacher) {
        return new TeacherTDO(
                teacher.getId(),
                teacher.getName(),
                teacher.getEmail()
        );
    }
}
