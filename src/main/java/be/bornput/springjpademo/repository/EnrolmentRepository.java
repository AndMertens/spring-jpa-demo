package be.bornput.springjpademo.repository;

import be.bornput.springjpademo.model.Enrolment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnrolmentRepository extends PagingAndSortingRepository<Enrolment, Long> {
    List<Enrolment> findEnrolmentByStudentId(Long id);
}
