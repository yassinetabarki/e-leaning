package com.example.demo.student;

import com.example.demo.post.Post;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudentDTO {
    private Long id;
    @NotNull(message = "null field")
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;
    private List<Post> posts;

}
