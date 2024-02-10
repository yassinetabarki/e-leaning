package com.example.demo.course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper mapper;

    public CourseService(CourseRepository courseRepository, CourseMapper mapper) {
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    public List<CourseDTO> getCourses() {
        return courseRepository.findAll().stream().map(mapper::courseToCourseDTO).collect(Collectors.toList());
    }
}
