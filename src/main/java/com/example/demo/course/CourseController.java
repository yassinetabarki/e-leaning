package com.example.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/courses")
public class CourseController {
    private final CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<CourseDTO> getCourses(
            @RequestParam(name = "q") String query
    ) {
        return this.service.getCourses(query);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> store(
            @RequestBody CourseDTO courseDTO
    ) {

        CourseDTO course = service.addCourse(courseDTO);
        return new ResponseEntity<CourseDTO>(course, HttpStatus.OK);
    }
}
