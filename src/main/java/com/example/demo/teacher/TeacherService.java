package com.example.demo.teacher;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository repository;


    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }


    public List<TeacherTDO> getTeachers() {
        return repository.findAll().stream().map(TeacherTDOMapper.INSTANCE::toTDO).toList();
    }

    public TeacherTDO addTeacher(TeacherTDO teacherTDO) {
        Teacher teacher = repository.save(TeacherTDOMapper.INSTANCE.toTeacher(teacherTDO));
        return TeacherTDOMapper.INSTANCE.toTDO(teacher);
    }
}
