package com.example.demo.student;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Mapper
interface StudentDTOMapper {

    StudentDTOMapper INSTANCE = Mappers.getMapper(StudentDTOMapper.class);
    StudentDTO toDTO(Student student);

    Student toStudent(StudentDTO studentTDO);
}
