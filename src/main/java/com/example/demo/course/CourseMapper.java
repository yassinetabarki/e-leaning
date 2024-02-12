package com.example.demo.course;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
    //create a singleton
    CourseMapper INSTANCE  = Mappers.getMapper(CourseMapper.class);

    @Mapping(source = "name" , target = "courseName")
    CourseDTO toDTO(Course course);
    @Mapping(source = "courseName", target="name")
    Course toCourse(CourseDTO courseDTO);
}
