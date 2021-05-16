package be.bornput.springjpademo.repository;

import be.bornput.springjpademo.model.StudentIdCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentIdCardRepository extends CrudRepository<StudentIdCard, Long> {
    StudentIdCard findStudentIdCardByStudent(Long id);

    StudentIdCard findStudentIdCardByCardNumber(String cardNumber);
}
