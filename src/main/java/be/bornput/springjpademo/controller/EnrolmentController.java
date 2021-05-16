package be.bornput.springjpademo.controller;

import be.bornput.springjpademo.model.Enrolment;
import be.bornput.springjpademo.service.EnrolmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EnrolmentController {

    private final EnrolmentService enrolmentService;

    public EnrolmentController(EnrolmentService enrolmentService) {
        this.enrolmentService = enrolmentService;
    }

    @GetMapping("/enrolments")
    public List<Enrolment> getAllEnrolments() {
        return enrolmentService.findAllEnrolments();
    }

    @GetMapping("/enrolment/{id}")
    public Enrolment getEnrolmentById(@PathVariable Long id) {

        Enrolment enrolment = enrolmentService.getEnrolmentById(id).get();
        if (enrolmentService.getEnrolmentById(id).isPresent()) {
             return enrolment;
        }
        else
        {
            Optional<Enrolment> optionalenrolment = Optional.of(enrolment);
            return optionalenrolment.get();
        }
    }

    @GetMapping("/enrolment/{id}/students")
    public List<Enrolment> getStudentsByEnrolmentId(@PathVariable Long id) {
        Optional<Enrolment> tempEnrolment = enrolmentService.getEnrolmentById(id);
        if (tempEnrolment.isEmpty()) {
            return Collections.emptyList();
        } else {
            return enrolmentService.getEnrolmentsByStudentId(id);
        }
    }
}
