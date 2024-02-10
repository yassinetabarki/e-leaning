package com.example.demo.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfig {
    CommandLineRunner commandLineRunner(CourseRepository courseRepository) {
        return args -> {
            Course cSharp = new Course("c#");
            Course cPlus = new Course("c++");
            Course java = new Course("java");
            courseRepository.saveAll(List.of(cSharp, cPlus, java));
        };
    }
}
