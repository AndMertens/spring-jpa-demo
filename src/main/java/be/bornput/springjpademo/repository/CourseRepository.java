package be.bornput.springjpademo.repository;

import be.bornput.springjpademo.model.Course;
import be.bornput.springjpademo.model.Enrolment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
    List<Enrolment> findEnrolmentsById(Long id);
}
