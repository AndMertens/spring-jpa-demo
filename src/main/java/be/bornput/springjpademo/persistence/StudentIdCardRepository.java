package be.bornput.springjpademo.persistence;

import be.bornput.springjpademo.model.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentIdCardRepository extends JpaRepository<StudentIdCard, Long> {
}
