package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    public List<StudentDTO> getStudents(String query) {
        Specification<Student> spec = query != null ? new StudentSpecifications().getFilterSpecifications(query) : null;
        return studentRepository.findAll(spec)
                .stream()
                .map(StudentDTOMapper.INSTANCE::toDTO)
                .toList();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());

        if (studentEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "student with id " + studentId + "Not found"
        ));

        if (name != null &&
                !name.isEmpty() &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null &&
                !email.isEmpty() &&
                !Objects.equals(student.getName(), email)) {
            student.setEmail(email);
        }
    }

    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "student with id " + studentId + " Not found"
        ));
        studentRepository.deleteById(studentId);
    }
}
