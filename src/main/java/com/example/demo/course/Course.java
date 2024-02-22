package com.example.demo.course;

import com.example.demo.teacher.Teacher;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Course {
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
    private Long id;

    private String name;

    private Double price;

    private String currency;

    protected static  String[] searchAbleField = {"name","description"};
    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "teacher_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    @Fetch(FetchMode.JOIN)
    private Set<Teacher> teachers;

    public Course(String name) {
        this.name = name;
    }


}
