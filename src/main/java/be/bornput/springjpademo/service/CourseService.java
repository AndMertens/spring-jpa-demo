package be.bornput.springjpademo.service;

import be.bornput.springjpademo.model.Course;
import be.bornput.springjpademo.model.Enrolment;
import be.bornput.springjpademo.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Enrolment> getEnrolmentsByCourseId(Long id) {
        return courseRepository.findEnrolmentsById(id);
    }

}
