package com.example.demo;

import com.example.demo.course.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication

public class DemoApplication {

    public static void main(String[] args) {
        Course t = new Course("yazzi");
        System.out.println(t.getName());
        SpringApplication.run(DemoApplication.class, args);
    }


}
