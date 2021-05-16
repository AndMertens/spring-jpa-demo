package be.bornput.springjpademo.service;

import be.bornput.springjpademo.model.StudentIdCard;
import be.bornput.springjpademo.repository.StudentIdCardRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentIdCardService {

    private final StudentIdCardRepository studentIdCardRepository;

    public StudentIdCardService(StudentIdCardRepository StudentIdCardRepository) {
        this.studentIdCardRepository = StudentIdCardRepository;
    }

    public List<StudentIdCard> findAllStudentIdCards() {
        return (List<StudentIdCard>) studentIdCardRepository.findAll();
    }

    public Optional<StudentIdCard> getStudentIdCardById(Long id) {
        return studentIdCardRepository.findById(id);
    }

    public StudentIdCard getStudentIdCardByStudentId(Long id) {
        return studentIdCardRepository.findStudentIdCardByStudent(id);
    }

    public StudentIdCard getStudentIdCardByCardNumber(String cardNumber) {
        return studentIdCardRepository.findStudentIdCardByCardNumber(cardNumber);
    }
}
