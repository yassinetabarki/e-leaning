package com.example.demo.course;

import com.example.demo.teacher.Teacher;
import jakarta.validation.constraints.NotEmpty;

import lombok.Data;


import java.util.List;
import java.util.Set;

@Data
public class CourseDTO {
    private Long id;

    @NotEmpty(message = "The full name is required.")
    private String courseName;

    private Double price;


    private String currency;

    private String description;

    private List<Teacher> teachers;
}
