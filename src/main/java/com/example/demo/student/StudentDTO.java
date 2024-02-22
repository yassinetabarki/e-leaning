package com.example.demo.student;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDTO {
    private Long id;
    @NotNull(message = "null field")
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

}
