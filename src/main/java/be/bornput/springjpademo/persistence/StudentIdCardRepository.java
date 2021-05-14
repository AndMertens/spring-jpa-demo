package be.bornput.springjpademo.persistence;

import be.bornput.springjpademo.model.StudentIdCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentIdCardRepository extends CrudRepository<StudentIdCard, Long> {
}
