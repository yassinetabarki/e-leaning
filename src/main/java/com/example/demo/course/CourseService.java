package com.example.demo.course;

import jakarta.persistence.criteria.JoinType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;


    //    private final CourseMapper mapper;
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public List<CourseDTO> getCourses(String query) {
        PageRequest pageable = PageRequest.of(1,10);
        Specification<Course> spec = new CourseSpecifications().getFilterSpecifications(query);
//        Specification<Course> specWithTeachers = joinTeachers(spec);
        return courseRepository.findAll(spec)
                .stream()
                .map(CourseMapper.INSTANCE::toDTO)
                .toList();
    }

    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course course = courseRepository.save(CourseMapper.INSTANCE.toCourse(courseDTO));
        return CourseMapper.INSTANCE.toDTO(course);
    }

//    public Specification<Course> joinTeachers(Specification<Course> join) {
//        return (root, query, criteriaBuilder) -> {
//            root.fetch("teachers", JoinType.LEFT);
//            return join.toPredicate(root, query, criteriaBuilder);
//        };
//    }
}
