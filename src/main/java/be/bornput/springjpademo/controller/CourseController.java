package be.bornput.springjpademo.controller;

import be.bornput.springjpademo.model.Course;
import be.bornput.springjpademo.model.Enrolment;
import be.bornput.springjpademo.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService CourseService) {
        this.courseService = CourseService;
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id) {

        Course course = courseService.getCourseById(id).get();
        if (courseService.getCourseById(id).isPresent()) {
            return course;
        }
        else
        {
            Optional<Course> optionalCourse = Optional.of(course);
            return optionalCourse.get();
        }
    }

    @GetMapping("/course/{id}/enrolments")
    public List<Enrolment> getEnrolmentsByCourseId(@PathVariable Long id) {
        Optional<Course> tempCourse = courseService.getCourseById(id);
        if(tempCourse.isEmpty()) {
            return Collections.emptyList();
        }
        else {
            return tempCourse.get().getEnrolments();
        }
    }

}
