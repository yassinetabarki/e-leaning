package com.example.demo.student;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record StudentDTO(
        Long id,
        @NotNull(message = "null field")
        String name,
        String email,
        LocalDate dob,
        Integer age
) {

}
