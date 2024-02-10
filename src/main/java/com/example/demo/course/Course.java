package com.example.demo.course;

import com.example.demo.teacher.Teacher;
import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Course {
    private Long id;
    private String name;
    public Course(String name) {
        this.name = name;
    }

    @Id
    @SequenceGenerator(
            name = "course",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.UUID,
            generator = "course"
    )

    @ManyToMany
    @JoinTable(
            name = "teacher_course",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Teacher> teachers;
}
