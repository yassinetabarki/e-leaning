package com.example.demo.teacher;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Mapper
public interface TeacherTDOMapper {

    TeacherTDOMapper INSTANCE = Mappers.getMapper(TeacherTDOMapper.class);

    TeacherTDO toTDO(Teacher teacher);

    Teacher toTeacher(TeacherTDO teacherTDO);
}
