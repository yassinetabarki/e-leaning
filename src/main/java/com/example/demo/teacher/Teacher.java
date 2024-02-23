package com.example.demo.teacher;

import com.example.demo.course.Course;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher",
            sequenceName = "teacher_sequence",
            allocationSize = 5

    )
    @GeneratedValue(
            strategy = GenerationType.UUID,
            generator = "teacher"
    )
    private Long id;

    private String name;
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "teacher_course",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
//    @Fetch(FetchMode.JOIN)
    @JsonBackReference

    private List<Course> courses;


}

