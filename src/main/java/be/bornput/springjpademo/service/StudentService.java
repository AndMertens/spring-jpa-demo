package be.bornput.springjpademo.service;

import be.bornput.springjpademo.model.Enrolment;
import be.bornput.springjpademo.model.Student;
import be.bornput.springjpademo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Enrolment> getEnrolmentsByStudentId(Long id) {
        return studentRepository.findEnrolmentById(id);
    }
}
