package com.example.demo.course;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE  = Mappers.getMapper(CourseMapper.class);

//    @Mapping(source = "name" , target = "courseName")
    CourseDTO courseToCourseDTO(Course course);
}
