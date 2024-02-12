package com.example.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    //    private final CourseMapper mapper;
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDTO> getCourses() {

        return courseRepository.findAll().stream().map(CourseMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }
}
