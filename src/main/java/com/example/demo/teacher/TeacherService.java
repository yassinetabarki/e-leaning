package com.example.demo.teacher;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private TeacherRepository repository;

    private final TeacherTDOMapper teacherTDOMapper;

    public TeacherService(TeacherRepository repository, TeacherTDOMapper teacherTDOMapper) {
        this.repository = repository;
        this.teacherTDOMapper = teacherTDOMapper;
    }


    public List<TeacherTDO> getTeachers() {
        return repository.findAll().stream().map(teacher -> teacherTDOMapper.apply(teacher)).collect(Collectors.toList());
    }
}
