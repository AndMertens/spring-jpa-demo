package be.bornput.springjpademo.repository;

import be.bornput.springjpademo.model.Enrolment;
import be.bornput.springjpademo.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    List<Enrolment> findEnrolmentById(Long id);
}
