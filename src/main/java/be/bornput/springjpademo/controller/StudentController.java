package be.bornput.springjpademo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import be.bornput.springjpademo.model.Book;
import be.bornput.springjpademo.model.Enrolment;
import be.bornput.springjpademo.model.Student;
import be.bornput.springjpademo.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {

        return studentService.getStudentById(id).isPresent() ? studentService.getStudentById(id).get() : null;
       
    }

    @GetMapping("/student/{id}/enrolments")
    public List<Enrolment> getEnrolmentsByStudentId(@PathVariable Long id) {
        Optional<Student> tempStudent = studentService.getStudentById(id);
        if(tempStudent.isPresent()) {
            return Collections.emptyList();
        }
        else {
            return tempStudent.get().getEnrolments();
        }
    }

    @GetMapping("/student/{id}/books")
    public List<Book> getBooksByStudentId(@PathVariable Long id) {
        Optional<Student> tempStudent = studentService.getStudentById(id);
        if(tempStudent.isPresent()) {
            return Collections.emptyList();
        }
        else {
            return new ArrayList<>(tempStudent.get().getBooks());
        }
    }

}
