package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private final StudentDTOMapper studentDTOMapper;


    @Autowired
    public StudentService(StudentRepository studentRepository, StudentDTOMapper studentDTOMapper) {
        this.studentRepository = studentRepository;
        this.studentDTOMapper = studentDTOMapper;
    }

    public List<StudentDTO> getStudents() {
        String[] t = {"test", "ters","dss"};
        return studentRepository.findAll().stream().map(student -> studentDTOMapper.apply(student)).collect(Collectors.toList());
    }

    public void addNewStudent(Student student) {
//        System.out.println(student);
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
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
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
