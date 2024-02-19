package com.example.demo.teacher;

import com.example.demo.course.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teachers")
public class TeacherController {
    private final TeacherService service;

    @Autowired
    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public List<TeacherTDO> getTeachers() {

        return service.getTeachers();
    }

    @PostMapping
    public ResponseEntity<TeacherTDO> Store(@RequestBody TeacherTDO teacherTDO) {
        TeacherTDO teacher = service.addTeacher(teacherTDO);
        return new ResponseEntity<TeacherTDO>(teacher, HttpStatus.OK);
    }
}
