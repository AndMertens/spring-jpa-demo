package be.bornput.springjpademo.service;

import be.bornput.springjpademo.model.Enrolment;
import be.bornput.springjpademo.repository.EnrolmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrolmentService {
    private final EnrolmentRepository enrolmentRepository;

    public EnrolmentService(EnrolmentRepository enrolmentRepository) {
        this.enrolmentRepository = enrolmentRepository;
    }

    public List<Enrolment> findAllEnrolments() {
        return (List<Enrolment>) enrolmentRepository.findAll();
    }

    public Optional<Enrolment> getEnrolmentById(Long id) {
        return enrolmentRepository.findById(id);
    }

    public List<Enrolment> getEnrolmentsByStudentId(Long id) {
        return enrolmentRepository.findEnrolmentByStudentId(id);
    }
}
