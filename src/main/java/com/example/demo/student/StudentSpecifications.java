package com.example.demo.student;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentSpecifications {
    private Specification<Student> hasText(String field, String operator, String content) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.equals(operator, "like")) {
                return criteriaBuilder.like(root.get(field), "%" + content + "%");
            } else {
                return criteriaBuilder.equal(root.get(field), content);
            }
        };
    }

    public Specification<Student> getFilterSpecifications(String query) {
        Specification<Student> spec = Specification.where(null);
        String[] parts = query.split(" ");
        String operator = parts[1];
        String content = parts[2];

        List<Specification<Student>> specifications = new ArrayList<>();

        for (int i = 0; i < parts.length - 1; i += 2) {
            for (String field : Student.searchAbleField) {
                specifications.add(hasText(field, operator, content));
            }
        }
        for (Specification<Student> specification : specifications) {
            spec = spec.or(specification);
        }
        return spec;
    }
}
