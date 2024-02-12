package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentDTO> getStudents() {
        return service.getStudents();
    }

    @PostMapping
    public void store(@RequestBody Student student) {
        service.addNewStudent(student);
    }

    @PutMapping(path = "{studentId}")
    public void update(@PathVariable("studentId") Long studentId,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String email
    ) {
        service.updateStudent(studentId, name, email);
    }

    @DeleteMapping(path = "{studentId}")
    public void delete(@PathVariable("studentId") Long studentId) {
        service.deleteStudent(studentId);
    }


}


