package com.example.demo.course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CourseSearchDao {
    private final EntityManager em;

    public List<Course> findAllCourse(
            String name,
            String description
    ) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> rootCourse = cq.from(Course.class);

        Predicate nameCourse = cb
                .like(rootCourse.get("name"), "%" + name + "%");

        Predicate descriptionCourse = cb
                .like(rootCourse.get("description"), "%" + description + "%");

        Predicate or = cb.or(
                nameCourse,
                descriptionCourse
        );

        cq.where(or);

        TypedQuery<Course> query = em.createQuery(cq);
        return query.getResultList();

    }
}
