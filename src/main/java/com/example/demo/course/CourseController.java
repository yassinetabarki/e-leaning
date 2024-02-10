package com.example.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/courses")
public class CourseController {
    private final CourseService service;
    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<CourseDTO> getCourses(){
        return this.service.getCourses();
    }
}
