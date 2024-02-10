package com.example.demo.teacher;

import com.example.demo.course.Course;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
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

    @ManyToMany
    @JoinTable(
            name = "teacher_course",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    public Teacher() {
    }

    public Teacher(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

